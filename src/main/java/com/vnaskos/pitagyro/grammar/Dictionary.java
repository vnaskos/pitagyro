package com.vnaskos.pitagyro.grammar;

import com.vnaskos.pitagyro.command.Command;
import com.vnaskos.pitagyro.grammar.Syntax.Type;
import com.vnaskos.pitagyro.location.Direction;

/**
 *
 * @author Vasilis Naskos
 */
public interface Dictionary {
    
    /**
     * Find the token's type
     * example: Verb
     * 
     * @param token String used as key on Types Map/Dictionary
     * @return Type
     */
    Type recognizeToken(String token);
    
    /**
     * Returns a command object based on the given verb token
     * 
     * @param verb String token
     * @return Command
     */
    Command recognizeCommand(String verb);
    
    /**
     * Get the direction based on the given direction token
     * 
     * @param direction String token
     * @return Direction
     * @throws Exception Direction not found 
     */
    Direction recognizeDirection(String direction) throws Exception;
    
    /**
     * Add a new pair (word - type) to the dictionary
     * example: potion - Item
     * 
     * @param word
     * @param syntaxType Type 
     */
    void registerWord(String word, Type syntaxType);
    
    /**
     * Add a new command to the dictionary
     * The command name is linked to a command class
     * 
     * Next step, in order to use them, is command recognition
     * @see recognizeCommand
     * 
     * @throws java.lang.Exception
     * @param verb command name
     * @param className class which represents the command
     */
    void registerCommand(String verb, String className) throws Exception;
    
}
