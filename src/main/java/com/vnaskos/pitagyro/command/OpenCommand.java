package com.vnaskos.pitagyro.command;

import com.vnaskos.pitagyro.grammar.Syntax;

/**
 *
 * @author Vasilis Naskos
 */
public class OpenCommand extends Command {

    static {
        syntax = new Syntax[1];
        syntax[0] = new Syntax.Builder().verb().direction().build();
    }
    
    @Override
    public void executeCommand() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void help() {
        System.out.println("example: open box1");
    }
    
}
