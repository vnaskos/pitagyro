package com.vnaskos.pitagyro.command;

import com.vnaskos.pitagyro.grammar.Syntax;
import com.vnaskos.pitagyro.item.Item;
import com.vnaskos.pitagyro.player.Player;

/**
 *
 * @author Vasilis Naskos
 */
public class MakeCommand extends Command {
    
    @Override
    public void executeCommand() {
        Player player = getPlayer();
        String pita = (String) args[0].getValue();
        String gyro = (String) args[1].getValue();
        
        if(!pita.equals("pita") || !gyro.equals("gyro")) {
            System.out.println("Poion pas na koroidepseis");
            return;
        }
        
        Item pitaItem = player.getItem(pita);
        Item gyroItem = player.getItem(gyro);
        
        if(pitaItem == null || gyroItem == null) {
            System.out.println("Pou pas re karamitro xoris ta vasika");
            return;
        }
        
        System.out.println("Ooooo my kod!!!");
        System.out.println("-> EPITELOUS GYRAKOS <-");
        System.exit(0);
    }
    
    @Override
    protected Syntax[] getSyntax() {
        Syntax[] syntax = new Syntax[1];
        syntax[0] = new Syntax.Builder().verb().item().item().build();
        return syntax;
    }

    @Override
    public void help() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
