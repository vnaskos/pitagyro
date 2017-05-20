package com.vnaskos.pitagyro.command;

import com.vnaskos.pitagyro.grammar.Syntax;
import com.vnaskos.pitagyro.item.Item;
import com.vnaskos.pitagyro.location.Location;
import com.vnaskos.pitagyro.player.Player;

/**
 *
 * @author Vasilis Naskos
 */
public class PickCommand extends Command {

    @Override
    public void executeCommand() {
        Player player = getPlayer();
        Location currentLocation = player.getPosition();
        
        String itemName = (String) args[0].getValue();
        
        if(!currentLocation.itemExists(itemName)) {
            System.out.println("Den vrethike " + itemName + " sto domatio");
            return;
        }
        
        Item item = currentLocation.removeItem(itemName);
        player.storeItem(item);
        
        System.out.println(item.getName() + " | " + item.getDescription());
        System.out.println("-- Prostethike sto sako sou --");
    }

    @Override
    protected Syntax[] getSyntax() {
        Syntax[] syntax = new Syntax[1];
        syntax[0] = new Syntax.Builder().verb().item().build();
        return syntax;
    }

    @Override
    public void help() {
        System.out.println("Pick item");
    }
    
}
