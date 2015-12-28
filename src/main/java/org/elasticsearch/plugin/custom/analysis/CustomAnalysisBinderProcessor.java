package org.elasticsearch.plugin.custom.analysis;

import org.elasticsearch.index.analysis.AnalysisModule;

/**
 * inform elasticsearch under which names our analyzer and token filter will be available
 * Created by yemengying on 15/12/2.
 */
public class CustomAnalysisBinderProcessor extends AnalysisModule.AnalysisBinderProcessor {



    //register our analyzer under name "custom-analyzer"
    @Override
    public void processAnalyzers(AnalyzersBindings
                                         analyzersBindings) {
        analyzersBindings.processAnalyzer("custom-analysis",
                CustomAnalyzerProvider.class);
    }

    //register our filter under name  custom_filter
    @Override
    public void processTokenFilters(TokenFiltersBindings
                                            tokenFiltersBindings) {
        tokenFiltersBindings.processTokenFilter("custom-filter",
                CustomFilterFactory.class);
    }
}
