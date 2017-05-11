package com.vnaskos.pitagyro.command;

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
    public void help() {
        System.out.println("example: Rixe antikeimeno");
    }
    
}
