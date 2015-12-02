package org.elasticsearch.plugin.custom.analysis;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.core.WhitespaceTokenizer;
import org.apache.lucene.util.Version;

import java.io.Reader;

/**
 * Created by yemengying on 15/12/2.
 */
public class CustomAnalyzer extends Analyzer {

    private final Version version;

    public CustomAnalyzer(Version version) {
        this.version = version;
    }


    @Override
    protected TokenStreamComponents createComponents(String s, Reader reader) {
        final Tokenizer src = new WhitespaceTokenizer(this.version,
                reader);
        return new TokenStreamComponents(src, new CustomFilter(src));
    }
}
