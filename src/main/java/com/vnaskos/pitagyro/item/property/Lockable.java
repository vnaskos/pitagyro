package com.vnaskos.pitagyro.item.property;

import com.vnaskos.pitagyro.item.Item;

/**
 *
 * @author Vasilis Naskos
 */
public interface Lockable {
    
    boolean unlock(Item key);
    
}
