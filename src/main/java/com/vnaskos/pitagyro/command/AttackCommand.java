package com.vnaskos.pitagyro.command;

import com.vnaskos.pitagyro.GameWorld;
import com.vnaskos.pitagyro.location.Location;
import com.vnaskos.pitagyro.player.Enemy;
import com.vnaskos.pitagyro.player.GameCharacter;
import com.vnaskos.pitagyro.player.Player;

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
        GameCharacter character = currentLocation.getLocationCharacter();
        
        if(character == null) {
            System.out.println("Noone to attack");
            return;
        }
        
        if(!(character instanceof Enemy)) {
            System.out.println("Not an enemy");
            return;
        }
        
        if(character.isDead()) {
            System.out.println("Character is Dead!");
            return;
        }
        
        player.attackTo(character);
        System.out.println("Enemy HP: " + character.getHealthPoints());
    }

    @Override
    public void help() {
        System.out.println("example: attack");
    }

    @Override
    public boolean beforeExcecution() {
        return true;
    }
    
}
