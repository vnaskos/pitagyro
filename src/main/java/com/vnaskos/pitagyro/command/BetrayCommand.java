package com.vnaskos.pitagyro.command;

/**
 *
 * @author Vasilis Naskos
 */
public class BetrayCommand extends Command {

    @Override
    public void executeCommand() {
        System.out.println("PRODOTI POS TOLMAS!!!");
        System.out.println("-> Eiste nekros (prosexe ta logia sou)");
        System.exit(0);
    }

    @Override
    public void help() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
