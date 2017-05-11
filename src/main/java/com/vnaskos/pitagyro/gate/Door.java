package com.vnaskos.pitagyro.gate;

import com.vnaskos.pitagyro.location.Direction;
import com.vnaskos.pitagyro.location.Location;
import com.vnaskos.pitagyro.util.Pair;
import java.io.Serializable;

/**
 *
 * @author Vasilis Naskos
 */
public class Door implements Gate, Serializable {

    private static final long serialVersionUID = -8759811553664352033L;
    
    protected Location location1;
    protected Location location2;
    
    public Door(
            Location location1,
            Location location2) {
        this.location1 = location1;
        this.location2 = location2;
    }
    
    public Door(
            Pair<Direction, Location> location1,
            Pair<Direction, Location> location2) {
        this.location1 = location1.getValue();
        this.location2 = location2.getValue();
    }

    @Override
    public Location getNextLocation(Location currentLocation) {
        return currentLocation == location1
                ? location2
                : location1;
    }
}
