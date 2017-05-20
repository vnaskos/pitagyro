package com.vnaskos.pitagyro.command;

import com.vnaskos.pitagyro.GameWorld;
import com.vnaskos.pitagyro.location.Location;
import com.vnaskos.pitagyro.player.Enemy;
import com.vnaskos.pitagyro.player.Player;
import com.vnaskos.pitagyro.player.Actor;

/**
 *
 * @author Vasilis Naskos
 */
public class AttackCommand extends Command {

    @Override
    public void executeCommand() {
        GameWorld gw = GameWorld.INSTANCE;
        Player player = gw.getPlayer();
        Location currentLocation = player.getPosition();
        Actor actor = currentLocation.getLocationActor();
        
        if(!isValidActor(actor)) {
            return;
        }
        
        player.attackTo(actor);
        System.out.println("Enemy HP: " + actor.getHealthPoints());
    }

    @Override
    public void help() {
        System.out.println("example: attack");
    }

    @Override
    public boolean beforeExcecution() {
        return true;
    }
    
    private boolean isValidActor(Actor actor) {
        if (actor == null) {
            System.out.println("Noone to attack");
            return false;
        }

        if (!(actor instanceof Enemy)) {
            System.out.println("Not an enemy");
            return false;
        }

        if (actor.isDead()) {
            System.out.println("Character is Dead!");
            return false;
        }
        
        return true;
    }
    
}
