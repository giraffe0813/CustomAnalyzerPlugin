package org.elasticsearch.plugin.custom.analysis;

import org.apache.lucene.analysis.TokenFilter;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;

import java.io.IOException;

/**
 * Created by yemengying on 15/12/2.
 */
public class CustomFilter extends TokenFilter {

    //allows us to retrieve the text of the token we are currently procession
    private final CharTermAttribute termAttr =
            addAttribute(CharTermAttribute.class);

    //constructor
    protected CustomFilter(TokenStream input) {
        super(input);
    }

    //if there is a token left to be processed return true;otherwise return false
    @Override
    public boolean incrementToken() throws IOException {
        if (input.incrementToken()) {
            //get the term text by buffer()
            char[] originalTerm = termAttr.buffer();
            if (originalTerm.length > 0) {
                StringBuilder builder = new StringBuilder(new
                        String(originalTerm).trim()).reverse();
                termAttr.setEmpty();
                termAttr.append(builder.toString());
            }
            return true;
        } else {
            return false;
        }
    }
}
