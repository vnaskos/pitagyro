package com.vnaskos.pitagyro.command;

import com.vnaskos.pitagyro.grammar.Syntax;

/**
 *
 * @author Vasilis Naskos
 */
public class HelpCommand extends Command {

    static {
        syntax = new Syntax[2];
        syntax[0] = new Syntax.Builder().verb().build();
        syntax[1] = new Syntax.Builder().verb().item().build();
    }
    
    @Override
    public void executeCommand() {
        String roomDescription = getCurrentLocation().getDescription();
        System.out.println(roomDescription);
    }

    @Override
    public void help() {
        System.out.println("example: help");
    }
    
}
