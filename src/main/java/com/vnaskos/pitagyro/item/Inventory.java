package com.vnaskos.pitagyro.item;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Vasilis Naskos
 */
public class Inventory implements Serializable {

    private static final long serialVersionUID = 4549466274771118057L;
    
    private final Map<String, Item> items;

    public Inventory() {
        items = new HashMap<>();
    }
    
    public boolean contains(String itemName) {
        return items.get(itemName) != null;
    }
    
    public void put(String itemName, Item item) {
        items.put(itemName, item);
    }
    
    public Item remove(String itemName) {
        return items.remove(itemName);
    }
    
    public Set<String> getContent() {
        return items.keySet();
    }
}
