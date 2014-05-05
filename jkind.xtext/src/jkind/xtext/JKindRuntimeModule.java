/*
 * generated by Xtext
 */
package jkind.xtext;

import jkind.xtext.converter.JKindValueConverter;
import jkind.xtext.naming.JKindDeclarativeQualifiedNameProvider;

import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.generator.IGenerator;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.scoping.IGlobalScopeProvider;
import org.eclipse.xtext.scoping.impl.ImportUriGlobalScopeProvider;

/**
 * Use this class to register components to be used at runtime / without the
 * Equinox extension registry.
 */
public class JKindRuntimeModule extends AbstractJKindRuntimeModule {
	@Override
	public Class<? extends IValueConverterService> bindIValueConverterService() {
		return JKindValueConverter.class;
	}

	public Class<? extends IGenerator> bindIGenerator() {
		return IGenerator.NullGenerator.class;
	}

	@Override
	public Class<? extends IGlobalScopeProvider> bindIGlobalScopeProvider() {
		return ImportUriGlobalScopeProvider.class;
	}
	
	@Override
	public Class<? extends IQualifiedNameProvider> bindIQualifiedNameProvider() {
		return JKindDeclarativeQualifiedNameProvider.class;
	}
}
