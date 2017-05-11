package com.vnaskos.pitagyro.gate;

import com.vnaskos.pitagyro.exception.LockedException;
import com.vnaskos.pitagyro.item.Item;
import com.vnaskos.pitagyro.item.property.Lockable;
import com.vnaskos.pitagyro.location.Location;
import java.io.Serializable;

/**
 *
 * @author Vasilis Naskos
 */
public class LockableGate extends GateAddon implements Lockable, Serializable {

    private static final long serialVersionUID = 731287898584502767L;

    protected boolean locked;
    protected Item key;
    
    public LockableGate(Gate gate, Item key, boolean locked) {
        super(gate);
        this.key = key;
        this.locked = locked;
    }
    
    public LockableGate(Gate gate, Item key) {
        this(gate, key, true);
    }
    
    @Override
    public Location getNextLocation(Location currentLocation)
            throws Exception {
        if(locked) {
            throw new LockedException("Gate is locked!");
        }
        
        return gate.getNextLocation(currentLocation);
    }

    @Override
    public boolean unlock(Item key) {
        if(locked) {
            locked = !this.key.equals(key);
        }
        
        return locked;
    }
}
