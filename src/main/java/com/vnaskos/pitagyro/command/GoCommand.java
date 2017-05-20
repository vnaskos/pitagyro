package com.vnaskos.pitagyro.command;

import com.vnaskos.pitagyro.grammar.Syntax;
import com.vnaskos.pitagyro.gate.Gate;
import com.vnaskos.pitagyro.location.Direction;
import com.vnaskos.pitagyro.location.Location;

/**
 *
 * @author Vasilis Naskos
 */
public class GoCommand extends Command {
    
    @Override
    public void executeCommand() {
        Location currentLocation = getCurrentLocation();
        Gate g = currentLocation.getExit((Direction)args[0].getValue());
        
        try {
            if(g == null) {
                throw new Exception("Den uparxei porta ekei");
            }
            getPlayer().updatePosition(g.getNextLocation(currentLocation));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    protected Syntax[] getSyntax() {
        Syntax[] syntax = new Syntax[1];
        syntax[0] = new Syntax.Builder().verb().direction().build();
        return syntax;
    }

    @Override
    public void help() {
        System.out.println("example: go south");
    }
    
}
