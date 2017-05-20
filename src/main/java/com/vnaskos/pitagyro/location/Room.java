package com.vnaskos.pitagyro.location;

import com.vnaskos.pitagyro.gate.Gate;
import com.vnaskos.pitagyro.hooks.LocationHook;
import com.vnaskos.pitagyro.item.Item;
import com.vnaskos.pitagyro.player.GameCharacter;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Vasilis Naskos
 */
public class Room implements Location, LocationHook, Serializable {

    private static final long serialVersionUID = 7692168259351604499L;

    protected String name;
    protected String description;
    protected Map<Direction, Gate> exits;
    
    protected Map<String, Item> items;
    protected GameCharacter roomCharacater;
    
    public Room() {
        exits = new HashMap<>();
        items = new HashMap<>();
    }

    public Room(String name, String description) {
        this();
        this.name = name;
        this.description = description;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public String getName() {
        return name;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public Item getItem(String itemName) {
        return items.get(itemName);
    }

    @Override
    public Item removeItem(String itemName) {
        return items.remove(itemName);
    }
    
    @Override
    public void addItem(String itemName, Item item) {
        items.put(itemName, item);
    }
    
    @Override
    public boolean itemExists(String itemName) {
        return getItem(itemName) != null;
    }
    
    @Override
    public Gate getExit(Direction dir) {
        return exits.get(dir);
    }
    
    @Override
    public void addExit(Direction direction, Gate exit) {
        exits.put(direction, exit);
    }

    @Override
    public GameCharacter getLocationCharacter() {
        return roomCharacater;
    }

    public void setRoomCharacater(GameCharacter roomCharacater) {
        this.roomCharacater = roomCharacater;
    }

    @Override
    public void playerEntered() {
        System.out.println("-> Vriskese " + getName());
        GameCharacter character = getLocationCharacter();
        if(character != null && !character.isDead()) {
            System.out.println("Ox maga mou, edo einai " + character.getName());
        }
    }
}
