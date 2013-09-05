/*
 * generated by Xtext
 */
package jkind.xtext.scoping;


import jkind.xtext.jkind.RecordExpr;
import jkind.xtext.jkind.RecordType;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;


/**
 * This class contains custom scoping description.
 * 
 * see : http://www.eclipse.org/Xtext/documentation.html#scoping on how and when
 * to use it
 * 
 */
public class JKindScopeProvider extends
		org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider {
	IScope scope_Field(RecordExpr e, @SuppressWarnings("unused") EReference reference) {
		if (e.getDef().getType() instanceof RecordType) {
			RecordType record = (RecordType) e.getDef().getType();
			return Scopes.scopeFor(record.getFields());
		}
		return IScope.NULLSCOPE;
	}
}
