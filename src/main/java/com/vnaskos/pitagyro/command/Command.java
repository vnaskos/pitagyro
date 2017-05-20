package com.vnaskos.pitagyro.command;

import com.vnaskos.pitagyro.grammar.Syntax;
import com.vnaskos.pitagyro.GameWorld;
import com.vnaskos.pitagyro.location.Location;
import com.vnaskos.pitagyro.player.Enemy;
import com.vnaskos.pitagyro.player.Player;
import com.vnaskos.pitagyro.player.Actor;

/**
 *
 * @author Vasilis Naskos
 */
public abstract class Command {
    
    protected CommandArgument[] args;
    protected static Syntax[] syntax;
    
    public void setArguments(CommandArgument[] args) {
        this.args = args;
    }
    
    protected Player getPlayer() {
        GameWorld gw = GameWorld.INSTANCE;
        return gw.getPlayer();
    }
    
    protected Location getCurrentLocation() {
        Player player = getPlayer();
        return player.getPosition();
    }
    
    public void execute() {
        boolean canExecute = beforeExecution();
        
        if(!canExecute) {
            System.out.println("Ts ts ts ts, den mporo na to kano auto tora");
            return;
        }
        
        executeCommand();
        afterExecution();
    }
    
    protected abstract void executeCommand();
    public abstract void help();
    
    public boolean beforeExecution() {
        Location location = getCurrentLocation();
        Actor character = location.getLocationActor();
        
        return !(character != null
                && character instanceof Enemy
                && !character.isDead());
    }
    
    public void afterExecution() {
        Location location = getCurrentLocation();
        Actor character = location.getLocationActor();
        
        if(character != null
                && character instanceof Enemy
                && !character.isDead()) {
            character.act();
        }
    }
}
