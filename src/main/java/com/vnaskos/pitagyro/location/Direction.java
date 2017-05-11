package com.vnaskos.pitagyro.location;

import com.vnaskos.pitagyro.grammar.Syntax;
import com.vnaskos.pitagyro.grammar.DefaultDictionary;
import com.vnaskos.pitagyro.grammar.Dictionary;

/**
 *
 * @author Vasilis Naskos
 */
public enum Direction {
    
    PANO, KATO, ARISTERA, DEXIA;
    
    static {
        Dictionary dictionary = DefaultDictionary.getInstance();
        dictionary.registerWord("pano", Syntax.Type.DIRECTION);
        dictionary.registerWord("kato", Syntax.Type.DIRECTION);
        dictionary.registerWord("aristera", Syntax.Type.DIRECTION);
        dictionary.registerWord("dexia", Syntax.Type.DIRECTION);
    }
}
