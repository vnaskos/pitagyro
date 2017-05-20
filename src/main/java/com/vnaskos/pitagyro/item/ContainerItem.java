package com.vnaskos.pitagyro.item;

import com.vnaskos.pitagyro.exception.ClosedException;
import com.vnaskos.pitagyro.item.property.Openable;
import com.vnaskos.pitagyro.item.property.Pickable;
import java.io.Serializable;

/**
 *
 * @author Vasilis Naskos
 */
public class ContainerItem implements Item, Openable, Pickable, Serializable {

    private static final long serialVersionUID = 6011936339223627704L;

    protected final String name;
    protected final String description;
    protected final Item containedItem;
    protected boolean open;
    protected boolean picked;

    public ContainerItem(String name, String description, Item containedItem) {
        this.name = name;
        this.description = description;
        this.containedItem = containedItem;
        this.open = false;
        this.picked = false;
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
    public boolean canOpen() {
        return true;
    }

    @Override
    public boolean isOpen() {
        return open;
    }

    @Override
    public void open() {
        if(canOpen()) {
            this.open = true;
        }
    }

    public Item getContainedItem() throws ClosedException {
        if(isOpen()) {
            picked = true;
            return containedItem;
        }
        
        throw new ClosedException("To antikeimeno einai kleisto, dokimase na to anoixeis");
    }

    @Override
    public boolean canPick() {
        return isOpen() && !picked;
    }
    
}
