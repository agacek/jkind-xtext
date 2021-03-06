package jkind.xtext.ui.validation;

import org.eclipse.jface.preference.IPreferenceStore;

import jkind.xtext.ui.internal.JKindActivator;
import jkind.xtext.ui.preferences.PreferenceConstants;
import jkind.xtext.validation.IValidatorAdvisor;

public class PreferenceBasedValidatorAdvisor implements IValidatorAdvisor {
	private final IPreferenceStore preferencesStore;

	public PreferenceBasedValidatorAdvisor() {
		preferencesStore = JKindActivator.getInstance().getPreferenceStore();
	}
	
	@Override
	public boolean allowNonlinear() {
		String solver = preferencesStore.getString(PreferenceConstants.PREF_SOLVER);
		return solver.equals(PreferenceConstants.SOLVER_Z3);
	}
	
	@Override
	public boolean isYices2() {
		String solver = preferencesStore.getString(PreferenceConstants.PREF_SOLVER);
		return solver.equals(PreferenceConstants.SOLVER_YICES2);
	}
	
	@Override
	public boolean isMathSat() {
		String solver = preferencesStore.getString(PreferenceConstants.PREF_SOLVER);
		return solver.equals(PreferenceConstants.SOLVER_MATHSAT);
	}

	@Override
	public String getSolverName() {
		return preferencesStore.getString(PreferenceConstants.PREF_SOLVER);
	}
}
