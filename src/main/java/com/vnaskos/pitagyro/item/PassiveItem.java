package com.vnaskos.pitagyro.item;

import java.io.Serializable;

/**
 *
 * @author Vasilis Naskos
 */
public class PassiveItem implements Item, Serializable {

    private static final long serialVersionUID = -7908094854560373594L;

    protected final String name;
    protected final String description;
    
    public PassiveItem(String name, String description) {
        this.name = name;
        this.description = description;
    }
    
    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        
        return this.hashCode() == obj.hashCode();
    }
    
}
