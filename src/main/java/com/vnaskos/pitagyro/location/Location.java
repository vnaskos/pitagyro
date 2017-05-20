package com.vnaskos.pitagyro.location;

import com.vnaskos.pitagyro.gate.Gate;
import com.vnaskos.pitagyro.item.Item;
import com.vnaskos.pitagyro.player.Actor;

/**
 *
 * @author Vasilis Naskos
 */
public interface Location {
    
    /**
     * The name of the location
     * example: Backyard
     * 
     * @return location name
     */
    String getName();
    
    /**
     * A Brief description of the location
     * example: A cold room with 2 doors
     * 
     * @return location description
     */
    String getDescription();
    
    /**
     * Get an item which is contained in the location
     * 
     * @param itemName
     * @return Item
     */
    Item getItem(String itemName);
    
    /**
     * Remove item from the location
     * Used mainly when player picks an item
     * 
     * @param itemName
     * @return The item to be removed
     */
    Item removeItem(String itemName);
    
    /**
     * Check if item exists in the location
     * 
     * @param itemName
     * @return boolean (true -> exists)
     */
    boolean itemExists(String itemName);
    
    /**
     * Place an item in the location
     * 
     * @param itemName
     * @param item 
     */
    void addItem(String itemName, Item item);
    
    /**
     * One of the possible gates in the location
     * on a given direction
     * 
     * @param dir direction of the exit
     * @return Gate
     */
    Gate getExit(Direction dir);
    
    /**
     * Place a Gate on a given direction within the location
     * 
     * @param direction
     * @param exit Gate
     */
    void addExit(Direction direction, Gate exit);
    
    /**
     * Get the actor of this location
     * example: Enemy
     * 
     * @return Actor
     */
    Actor getLocationActor();
}
