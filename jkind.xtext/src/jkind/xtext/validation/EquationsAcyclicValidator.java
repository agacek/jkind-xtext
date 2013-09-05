/*
 * generated by Xtext
 */
package jkind.xtext.validation;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import jkind.xtext.jkind.Equation;
import jkind.xtext.jkind.JkindPackage;
import jkind.xtext.jkind.Node;
import jkind.xtext.jkind.Variable;

import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.EValidatorRegistrar;

public class EquationsAcyclicValidator extends AbstractJKindJavaValidator {
	@Check
	public void checkAlgebraicLoops(Node node) {
		Map<Variable, Set<Variable>> dependencies = getEquationDependencies(node);
		for (Equation eq : node.getEquations()) {
			for (Variable var : eq.getLhs()) {
				checkAlgebaricLoops(var, new ArrayDeque<Variable>(), dependencies);
			}
		}
	}

	private Map<Variable, Set<Variable>> getEquationDependencies(Node node) {
		Map<Variable, Set<Variable>> dependencies = new HashMap<>();
		for (Equation eq : node.getEquations()) {
			Set<Variable> set = CurrentVariableExtractor.get(eq.getRhs());
			for (Variable var : eq.getLhs()) {
				dependencies.put(var, set);
			}
		}
		return dependencies;
	}

	private Set<Variable> done = new HashSet<>();

	private void checkAlgebaricLoops(Variable var, Deque<Variable> stack,
			Map<Variable, Set<Variable>> dependencies) {
		if (done.contains(var)) {
			return;
		}
		
		if (stack.contains(var)) {
			warnEquationCycle(stack, var);
		} else {
			if (dependencies.containsKey(var)) {
				stack.addLast(var);
				for (Variable next : dependencies.get(var)) {
					checkAlgebaricLoops(next, stack, dependencies);
				}
				stack.removeLast();
			}
			done.add(var);
		}
	}
	
	private Set<Variable> marked = new HashSet<>();

	private void warnEquationCycle(Deque<Variable> stack, Variable last) {
		StringBuilder text = new StringBuilder();
		text.append("Possible algebraic loop ");
		boolean cycleStarted = false;
		for (Variable var : stack) {
			if (var.equals(last)) {
				cycleStarted = true;
			}
			if (cycleStarted) {
				text.append(var.getName());
				text.append(" -> ");
			}
		}
		text.append(last.getName());
		String message = text.toString();

		cycleStarted = false;
		for (Variable var : stack) {
			if (var.equals(last)) {
				cycleStarted = true;
			}
			if (cycleStarted && !marked.contains(var)) {
				marked.add(var);
				Equation eq = getEquationFor(var);
				warning(message, eq, JkindPackage.Literals.EQUATION__LHS, eq.getLhs().indexOf(var));
			}
		}
	}
	
	private Equation getEquationFor(Variable var) {
		Node node = EcoreUtil2.getContainerOfType(var, Node.class);
		for (Equation eq : node.getEquations()) {
			if (eq.getLhs().contains(var)) {
				return eq;
			}
		}
		return null;
	}

	@Override
	public void register(EValidatorRegistrar registrar) {
		// Since this is a composed check we prevent it from registering on its own
	}
}
