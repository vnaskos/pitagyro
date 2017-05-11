package com.vnaskos.pitagyro.gate;

import java.io.Serializable;

/**
 *
 * @author Vasilis Naskos
 */
public abstract class GateAddon implements Gate, Serializable {
    
    protected Gate gate;

    public GateAddon(Gate gate) {
        this.gate = gate;
    }
}
