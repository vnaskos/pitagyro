package com.vnaskos.pitagyro.player;

import com.vnaskos.pitagyro.hooks.LocationHook;
import com.vnaskos.pitagyro.item.Inventory;
import com.vnaskos.pitagyro.item.Item;
import com.vnaskos.pitagyro.location.Location;
import java.io.Serializable;
import java.util.Set;

/**
 *
 * @author Vasilis Naskos
 */
public class Player implements Serializable {

    private static final long serialVersionUID = 7074074622932343214L;
    
    protected Location position;
    protected Inventory inventory;
    
    protected int healthPoints;
    protected int attackPoints;
    protected int defensePoints;
    
    public Player(Location initialPosition) {
        position = initialPosition;
        inventory = new Inventory();
        
        healthPoints  = 100;
        attackPoints  = 10;
        defensePoints = 1;
    }

    public Location getPosition() {
        return position;
    }

    public void updatePosition(Location position) {
        this.position = position;
        
        if(position instanceof LocationHook) {
            LocationHook hook = (LocationHook) position;
            hook.playerEntered();
        }
    }
    
    public void storeItem(Item item) {
        inventory.put(item.getName(), item);
    }
    
    public Item getItem(String itemName) {
        if(inventory.contains(itemName)) {
            return inventory.remove(itemName);
        }
        
        return null;
    }
    
    public Item dropItem(String itemName) {
        if(inventory.contains(itemName)) {
            return inventory.remove(itemName);
        }
        
        return null;
    }
    
    public void reduceHealthBy(int value) {
        healthPoints -= (value-defensePoints);
    }

    public int getHealthPoints() {
        return healthPoints;
    }
    
    public void attackTo(GameCharacter character) {
        character.reduceHealthBy(attackPoints);
    }

    public Set<String> getInventoryContent() {
        return inventory.getContent();
    }
}
