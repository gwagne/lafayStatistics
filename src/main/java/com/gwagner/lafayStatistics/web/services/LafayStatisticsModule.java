package com.gwagner.lafayStatistics.web.services;

import com.gwagner.lafayStatistics.web.services.config.LafayStatisticsExternalConfiguration;
import org.apache.tapestry5.ComponentParameterConstants;
import org.apache.tapestry5.MetaDataConstants;
import org.apache.tapestry5.SymbolConstants;
import org.apache.tapestry5.ioc.*;
import org.apache.tapestry5.ioc.annotations.Contribute;
import org.apache.tapestry5.ioc.annotations.Symbol;
import org.apache.tapestry5.ioc.internal.services.ResourceSymbolProvider;
import org.apache.tapestry5.ioc.internal.util.ClasspathResource;
import org.apache.tapestry5.ioc.services.CoercionTuple;
import org.apache.tapestry5.ioc.services.SymbolProvider;
import org.apache.tapestry5.ioc.services.SymbolSource;
import org.apache.tapestry5.ioc.services.TypeCoercer;
import org.apache.tapestry5.services.*;

import java.util.ResourceBundle;
import java.util.UUID;

public class LafayStatisticsModule {


    public static void bind(ServiceBinder binder) {
        //TODO Bind services???
    }

    public static void contributeFactoryDefaults(MappedConfiguration<String, Object> configuration) {
        String version = ResourceBundle.getBundle("lafayStatistics").getString("version");
        configuration.override(SymbolConstants.APPLICATION_VERSION, version + "-" + UUID.randomUUID().toString());
    }

    public static void contributeApplicationDefaults(MappedConfiguration<String, Object> configuration) {
        configuration.add(SymbolConstants.SUPPORTED_LOCALES, "fr,en,it,es,de");
        configuration.add(SymbolConstants.ENCODE_LOCALE_INTO_PATH, "true");
        configuration.add(ComponentParameterConstants.ZONE_UPDATE_METHOD, "show");
        configuration.add(ComponentParameterConstants.FORMINJECTOR_SHOW_FUNCTION, "show");

    }

    public static void contributeComponentMessagesSource(AssetSource assetSource,
                                                         OrderedConfiguration<Resource> configuration) {
        configuration.add("GlobalCatalog",
                assetSource.resourceForPath("com/gwagner/lafayStatistics/web/Catalog.properties"), "after:AppCatalog");
    }

    @Contribute(TypeCoercer.class)
    public static void contributeTypeCoercer(Configuration<CoercionTuple> configuration) {
        //TODO Coercers
    }

    public static void contributeDefaultDataTypeAnalyzer(MappedConfiguration<Class, String> configuration) {
        //TODO DataType
    }

    public static void contributeBeanBlockSource(Configuration<BeanBlockContribution> configuration) {
        //TODO Display Blocks
    }

    public static void contributeComponentEventRequestHandler(OrderedConfiguration<ComponentEventRequestFilter> configuration) {
        //TODO Event Exceptions
    }

    @Contribute(SymbolSource.class)
    public static void contributeSymbolSource(OrderedConfiguration<SymbolProvider> configuration) {
        configuration.add("LafayStatistics Properties", new ResourceSymbolProvider(
                new ClasspathResource("ls.properties")));

        configuration.add("Environment Lafay Statistics Properties", new LafayStatisticsExternalConfiguration().createSymbolProvider());
    }

    @Contribute(MarkupRenderer.class)
    public static void contributeMarkupRenderer(OrderedConfiguration<MarkupRendererFilter> configuration, final Environment environment) {
        //TODO Renderers validation
    }

    public static void contributeMetaDataLocator(MappedConfiguration<String, String> configuration,
                                                 @Symbol(SymbolConstants.PRODUCTION_MODE) boolean productionMode) {
        //Toutes les pages sont en HTTPS pour la prod
        if (productionMode) {
            configuration.add(MetaDataConstants.SECURE_PAGE, "true");
        }
    }

    @Contribute(PartialMarkupRenderer.class)
    public static void contributePartialMarkupRenderer(OrderedConfiguration<PartialMarkupRendererFilter> configuration, Environment environment) {
        //TODO Renderers validation
    }


    //TODO en cas de service override
//        @Contribute(ServiceOverride.class)
//        public static void setupServiceOverrides(MappedConfiguration<Class, Object> configuration,
//                                                 @Local ConfigurateurDeParametres configurateurDeParametresCautions) {
//            configuration.add(ConfigurateurDeParametres.class, configurateurDeParametresCautions);
//        }

    //TODO si on a des value encoders
//        public static void contributeValueEncoderSource(MappedConfiguration<Class, ValueEncoderFactory> configuration,
//
//        }

}