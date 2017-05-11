package com.vnaskos.pitagyro.grammar;

import com.vnaskos.pitagyro.command.Command;

/**
 *
 * @author Vasilis Naskos
 */
public interface Parser {
    
    Command constructCommand(String[] tokens) throws Exception;
    
}
