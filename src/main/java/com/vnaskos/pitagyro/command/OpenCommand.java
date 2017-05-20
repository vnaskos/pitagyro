package com.vnaskos.pitagyro.command;

import com.vnaskos.pitagyro.grammar.Syntax;

/**
 *
 * @author Vasilis Naskos
 */
public class OpenCommand extends Command {
    
    @Override
    public void executeCommand() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    protected Syntax[] getSyntax() {
        Syntax[] syntax = new Syntax[2];
        syntax[0] = new Syntax.Builder().verb().item().build();
        syntax[1] = new Syntax.Builder().verb().direction().build();
        return syntax;
    }

    @Override
    public void help() {
        System.out.println("example: open box1");
    }
    
}
