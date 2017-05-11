package com.vnaskos.pitagyro.grammar;

/**
 *
 * @author Vasilis Naskos
 */
public class DefaultCommandTokenizer implements Tokenizer {

    @Override
    public String[] tokenize(String sentence) {
        sentence = sentence.replaceAll("[.|,]", " ");
        return sentence.split(" ");
    }
    
}
