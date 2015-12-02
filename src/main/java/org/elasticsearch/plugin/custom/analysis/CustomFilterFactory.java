package org.elasticsearch.plugin.custom.analysis;

import org.apache.lucene.analysis.TokenStream;
import org.elasticsearch.common.inject.Inject;
import org.elasticsearch.common.inject.assistedinject.Assisted;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.index.Index;
import org.elasticsearch.index.analysis.AbstractTokenFilterFactory;
import org.elasticsearch.index.settings.IndexSettings;

/**
 *
 * this class is simple ,just for provide TalosFilter instance to Elasticsearch
 * Created by yemengying on 15/12/2.
 */
public class CustomFilterFactory extends AbstractTokenFilterFactory {


    @Inject
    public CustomFilterFactory(Index index, @IndexSettings Settings
            indexSettings, @Assisted String name, @Assisted Settings
                                       settings) {
        super(index, indexSettings, name, settings);
    }

    public TokenStream create(TokenStream tokenStream) {
        return new CustomFilter(tokenStream);
    }
}
