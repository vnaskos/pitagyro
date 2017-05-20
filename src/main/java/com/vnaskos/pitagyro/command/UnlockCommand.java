package com.vnaskos.pitagyro.command;

import com.vnaskos.pitagyro.grammar.Syntax;
import com.vnaskos.pitagyro.gate.Gate;
import com.vnaskos.pitagyro.item.Item;
import com.vnaskos.pitagyro.gate.LockableGate;
import com.vnaskos.pitagyro.location.Direction;
import com.vnaskos.pitagyro.location.Location;
import com.vnaskos.pitagyro.player.Player;

/**
 *
 * @author Vasilis Naskos
 */
public class UnlockCommand extends Command {
    
    @Override
    public void executeCommand() {
        Location currentLocation = getCurrentLocation();
        Gate g = currentLocation.getExit((Direction) args[0].getValue());
        
        if(!(g instanceof LockableGate)) {
            System.out.println("I porta den einai kleidomeni");
            return;
        }
        
        Player player = getPlayer();
        String itemName = (String) args[1].getValue();
        Item key = player.getItem(itemName);
                
        if(key == null) {
            System.out.println("Den vrethike " + itemName + " sto sako sou");
            return;
        }
        
        LockableGate lockedGate = (LockableGate) g;
        boolean isStillLocked = lockedGate.unlock(key);
        if(isStillLocked) {
            System.out.println("Lathos kleidi!");
        } else {
            System.out.println("I porta xekleidose");
        }
    }
    
    @Override
    protected Syntax[] getSyntax() {
        Syntax[] syntax = new Syntax[1];
        syntax[0] = new Syntax.Builder().verb().direction().item().build();
        return syntax;
    }

    @Override
    public void help() {
        System.out.println("example: unlock south door with key");
    }
}
