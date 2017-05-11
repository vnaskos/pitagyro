package com.vnaskos.pitagyro.command;

import com.vnaskos.pitagyro.player.Player;

/**
 *
 * @author Vasilis Naskos
 */
public class InventoryCommand extends Command {

    @Override
    protected void executeCommand() {
        Player player = getPlayer();
        for(String itemName : player.getInventoryContent()) {
            System.out.println("- " + itemName);
        }
    }

    @Override
    public void help() {
        System.out.println("items");
    }
    
}
