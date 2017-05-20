package com.vnaskos.pitagyro.command;

import com.vnaskos.pitagyro.grammar.Syntax;
import com.vnaskos.pitagyro.item.Item;
import com.vnaskos.pitagyro.location.Location;
import com.vnaskos.pitagyro.player.Player;

/**
 *
 * @author Vasilis Naskos
 */
public class DropCommand extends Command {

    @Override
    protected void executeCommand() {
        Player player = getPlayer();
        Location location = player.getPosition();
        
        String itemToBeDropped = (String) args[0].getValue();
        
        if(itemToBeDropped == null) {
            return;
        }
        
        Item item = player.dropItem(itemToBeDropped);
        location.addItem(item.getName(), item);
        System.out.println("PAEIII");
    }

    @Override
    protected Syntax[] getSyntax() {
        Syntax[] syntax = new Syntax[1];
        syntax[0] = new Syntax.Builder().verb().item().build();
        return syntax;
    }
    
    @Override
    public void help() {
        System.out.println("example: Rixe antikeimeno");
    }
    
}
