package com.vnaskos.pitagyro.gate;

import com.vnaskos.pitagyro.location.Location;

/**
 *
 * @author Vasilis Naskos
 */
public interface Gate {

    public Location getNextLocation(Location currentLocation) throws Exception;
    
}
