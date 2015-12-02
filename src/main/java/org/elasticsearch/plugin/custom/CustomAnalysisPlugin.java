package org.elasticsearch.plugin.custom;

import org.elasticsearch.common.collect.ImmutableList;
import org.elasticsearch.common.inject.Module;
import org.elasticsearch.index.analysis.AnalysisModule;
import org.elasticsearch.plugin.custom.analysis.CustomAnalysisBinderProcessor;
import org.elasticsearch.plugin.custom.analysis.CustomAnalyzerModule;
import org.elasticsearch.plugins.AbstractPlugin;

import java.util.Collection;


/**
 * Created by yemengying on 15/12/2.
 */
public class CustomAnalysisPlugin extends AbstractPlugin {

    public String name() {
        return "custom-analysis-plugin";
    }

    public String description() {
        return "an analysis plugin  based on elasticsearch";
    }

    @Override
    public Collection<Class<? extends Module>> modules() {
        return ImmutableList.<Class<? extends
                Module>>of(CustomAnalyzerModule.class);
    }
    public void onModule(AnalysisModule module) {
        module.addProcessor(new CustomAnalysisBinderProcessor());
    }

}
