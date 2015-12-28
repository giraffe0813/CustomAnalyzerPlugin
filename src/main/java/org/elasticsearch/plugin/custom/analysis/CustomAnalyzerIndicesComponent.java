package org.elasticsearch.plugin.custom.analysis;

import org.apache.lucene.analysis.TokenStream;
import org.elasticsearch.common.component.AbstractComponent;
import org.elasticsearch.common.inject.Inject;
import org.elasticsearch.common.lucene.Lucene;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.index.analysis.*;
import org.elasticsearch.indices.analysis.IndicesAnalysisService;

/**
 * Created by yemengying on 15/12/2.
 */
public class CustomAnalyzerIndicesComponent extends AbstractComponent {


    @Inject
    public CustomAnalyzerIndicesComponent(Settings settings,
                                          IndicesAnalysisService indicesAnalysisService) {
        super(settings);
        indicesAnalysisService.analyzerProviderFactories().put(
                "custom_analyzer",
                new PreBuiltAnalyzerProviderFactory("custom-analysis",
                        AnalyzerScope.INDICES, new CustomAnalyzer(
                        Lucene.ANALYZER_VERSION)));


        indicesAnalysisService.tokenFilterFactories().put("custom-filter",
            new PreBuiltTokenFilterFactoryFactory(new TokenFilterFactory() {


                public String name() {
                    return "custom-filter";
                }

                public TokenStream create(TokenStream tokenStream) {
                    return new CustomFilter(tokenStream);
                }
            }));
    }
}





