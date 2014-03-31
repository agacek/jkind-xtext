/*
 * generated by Xtext
 */
package jkind.xtext.ui;

import jkind.xtext.ui.validation.PreferenceBasedValidatorAdvisor;
import jkind.xtext.validation.IValidatorAdvisor;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.ui.editor.hover.IEObjectHoverProvider;

/**
 * Use this class to register components to be used within the IDE.
 */
public class JKindUiModule extends jkind.xtext.ui.AbstractJKindUiModule {
	public JKindUiModule(AbstractUIPlugin plugin) {
		super(plugin);
	}
	
	public Class<? extends IEObjectHoverProvider> bindIEObjectHoverProvider() {
		return JKindEObjectHoverProvider.class;
	}
	
	public Class<? extends IValidatorAdvisor> bindIValidatorAdvisor() {
		return PreferenceBasedValidatorAdvisor.class;
	}
}
