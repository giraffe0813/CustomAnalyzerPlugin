package org.elasticsearch.plugin.custom;

import org.elasticsearch.common.inject.Module;
import org.elasticsearch.index.analysis.AnalysisModule;
import org.elasticsearch.plugin.custom.analysis.CustomAnalysisBinderProcessor;
import org.elasticsearch.plugin.custom.analysis.CustomAnalyzerModule;
import org.elasticsearch.plugins.Plugin;

import java.util.Collection;
import java.util.Collections;


/**
 * Created by yemengying on 15/12/2.
 */
public class CustomAnalysisPlugin extends Plugin {

    public String name() {
        return "custom-analysis";
    }

    public String description() {
        return "an analysis plugin  based on elasticsearch";
    }

    @Override
    public Collection<Module> nodeModules() {
        return Collections.<Module>singletonList(new CustomAnalyzerModule());
    }
    public void onModule(AnalysisModule module) {
        module.addProcessor(new CustomAnalysisBinderProcessor());
    }

}
