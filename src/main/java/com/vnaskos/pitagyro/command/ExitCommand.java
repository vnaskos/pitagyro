package com.vnaskos.pitagyro.command;

/**
 *
 * @author Vasilis Naskos
 */
public class ExitCommand extends Command {

    @Override
    protected void executeCommand() {
        System.exit(0);
    }

    @Override
    public void help() {
        System.out.println("Exit");
    }
    
}
