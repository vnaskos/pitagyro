package com.vnaskos.pitagyro.grammar;

import com.vnaskos.pitagyro.command.Command;
import com.vnaskos.pitagyro.grammar.Syntax.Type;
import com.vnaskos.pitagyro.location.Direction;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Vasilis Naskos
 */
public class DefaultDictionary implements Dictionary {

    private static DefaultDictionary instance;
    private final Map<String, Type> typeMap;
    private final Map<String, Command> commandsMap;

    private DefaultDictionary() {
        commandsMap = new HashMap<>();
        typeMap = new HashMap<>();
    }

    public static DefaultDictionary getInstance() {
        if(instance == null) {
            instance = new DefaultDictionary();
        }
        return instance;
    }
    
    @Override
    public Type recognizeToken(String token) {
        return typeMap.get(token);
    }
    
    @Override
    public Command recognizeCommand(String verb) {
        return commandsMap.get(verb);
    }
    
    @Override
    public Direction recognizeDirection(String direction) throws Exception {
        return Direction.valueOf(direction.toUpperCase());
    }

    @Override
    public void registerWord(String word, Type syntaxType) {
        typeMap.put(word, syntaxType);
    }
    
    @Override
    public void registerCommand(String verb, String className)
            throws Exception {
        registerWord(verb, Type.VERB);
        
        Class<?> klass = Class.forName(className);
        Constructor<?> ctor = klass.getConstructor();
        Command c = (Command) ctor.newInstance();
        
        commandsMap.put(verb, c);
    }
    
}
