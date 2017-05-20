package com.vnaskos.pitagyro.command;

import com.vnaskos.pitagyro.grammar.Syntax;

/**
 *
 * @author Vasilis Naskos
 */
public class HelpCommand extends Command {
    
    @Override
    public void executeCommand() {
        String helpText;
        
        if(args.length == 0) {
            helpText = getCurrentLocation().getDescription();
            System.out.println(helpText);
        } else {
            Object arg1 = args[0].getValue();
            if(arg1 instanceof Command) {
                ((Command) arg1).help();
            }
        }
    }
    
    @Override
    protected Syntax[] getSyntax() {
        Syntax[] syntax = new Syntax[2];
        syntax[0] = new Syntax.Builder().verb().build();
        syntax[1] = new Syntax.Builder().verb().verb().build();
        return syntax;
    }

    @Override
    public void help() {
        System.out.println("example: help");
    }
    
}
