package com.vnaskos.pitagyro.command;

/**
 * Exit in a more violent way
 * 
 * @author Vasilis Naskos
 */
public class BetrayCommand extends ExitCommand {

    @Override
    public void executeCommand() {
        System.out.println("PRODOTI POS TOLMAS!!!");
        System.out.println("-> Eiste nekros (prosexe ta logia sou)");
        
        super.executeCommand();
    }
    
}
