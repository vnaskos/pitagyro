package com.vnaskos.pitagyro.gate;

import com.vnaskos.pitagyro.item.Item;
import com.vnaskos.pitagyro.location.Direction;
import com.vnaskos.pitagyro.location.Location;
import com.vnaskos.pitagyro.util.Pair;

/**
 *
 * @author Vasilis Naskos
 */
public class GateBuilder {

    protected Pair<Direction, Location> location1, location2;
    protected Item key;
    
    public GateBuilder(
            Pair<Direction, Location> location1,
            Pair<Direction, Location> location2) {
        this.location1 = location1;
        this.location2 = location2;
    }
    
    public GateBuilder key(Item key) {
        this.key = key;
        return this;
    }
    
    public Gate buildAndAttach() {
        Gate g;
        
        if(key == null) {
            g = new Door(location1, location2);
        } else {
            Door door = new Door(location1, location2);
            g = new LockableGate(door, key);
        }
        
        location1.getValue().addExit(location1.getKey(), g);
        location2.getValue().addExit(location2.getKey(), g);
        
        return g;
    }
    
}
