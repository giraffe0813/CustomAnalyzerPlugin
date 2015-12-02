package org.elasticsearch.plugin.custom.analysis;

import org.elasticsearch.common.inject.AbstractModule;

/**
 * Created by yemengying on 15/12/2.
 */
public class CustomAnalyzerModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(CustomAnalyzerIndicesComponent.class).asEagerSingleton();
    }
}
