package com.vnaskos.pitagyro.command;

import com.vnaskos.pitagyro.grammar.Syntax;
import com.vnaskos.pitagyro.GameWorld;
import com.vnaskos.pitagyro.exception.InGameException;
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
        
        try {
            executeCommand();
        } catch (InGameException ex) {
            System.out.println(ex.getMessage());
            return;
        }
        
        afterExecution();
    }
    
    protected abstract void executeCommand() throws InGameException;
    public abstract void help();
    
    protected boolean beforeExecution() {
        return checkAliveEnemy();
    }
    
    public boolean isSyntaxValid(Syntax givenSyntax) {
        Syntax[] syntax = getSyntax();
        
        if(syntax == null) {
            return false;
        }
        
        for(Syntax s : syntax) {
            if(s.equals(givenSyntax)) {
                return true;
            }
        }
        
        return false;
    }
    
    protected Syntax[] getSyntax() {
        Syntax[] syntax = new Syntax[1];
        syntax[0] = new Syntax.Builder().verb().build();
        return syntax;
    }
    
    protected boolean checkAliveEnemy() {
        Location location = getCurrentLocation();
        Actor character = location.getLocationActor();
        
        return !(character != null
                && character instanceof Enemy
                && !character.isDead());
    }
    
    protected void afterExecution() {
        Location location = getCurrentLocation();
        Actor character = location.getLocationActor();
        
        if(character != null
                && character instanceof Enemy
                && !character.isDead()) {
            character.act();
        }
    }
}
