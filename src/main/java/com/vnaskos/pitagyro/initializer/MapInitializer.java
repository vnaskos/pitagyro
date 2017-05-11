package com.vnaskos.pitagyro.initializer;

import com.vnaskos.pitagyro.location.Location;

/**
 *
 * @author Vasilis Naskos
 */
public abstract class MapInitializer implements Initializer {
    
    protected Location startLocation;
    
    public Location getStartLocation() {
        return startLocation;
    }
    
}
