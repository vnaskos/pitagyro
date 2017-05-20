package com.vnaskos.pitagyro.command;

import com.vnaskos.pitagyro.exception.InGameException;
import com.vnaskos.pitagyro.exception.NotFoundException;
import com.vnaskos.pitagyro.grammar.Syntax;
import com.vnaskos.pitagyro.item.ContainerItem;
import com.vnaskos.pitagyro.item.Item;
import com.vnaskos.pitagyro.item.property.Openable;
import com.vnaskos.pitagyro.location.Location;

/**
 *
 * @author Vasilis Naskos
 */
public class OpenCommand extends Command {
    
    @Override
    public void executeCommand() throws InGameException {
        String itemName = (String) args[0].getValue();
        
        Item item = searchLocationForItem(itemName);
        
        if(!(item instanceof Openable) || !((Openable) item).canOpen()) {
            throw new InGameException("den mporei na anoixei");
        }
        
        Openable openable = (Openable) item;
        
        if(openable.isOpen()) {
            throw new InGameException("einai idi anoixto");
        }
        
        openable.open();
        
        if(openable.isOpen()) {
            System.out.println(itemName + " anoixe");
        } else {
            System.out.println(itemName + " den anoixe");
        }
    }
    
    @Override
    protected Syntax[] getSyntax() {
        Syntax[] syntax = new Syntax[1];
        syntax[0] = new Syntax.Builder().verb().item().build();
        return syntax;
    }

    @Override
    public void help() {
        System.out.println("example: open box1");
    }
    
    protected Item searchLocationForItem(String itemName)
            throws NotFoundException {
        Location currentLocation = getCurrentLocation();
        
        if (!currentLocation.itemExists(itemName)) {
            throw new NotFoundException(
                    String.format("Den vrethike '%s' sto domatio", itemName));
        }
        
        return currentLocation.getItem(itemName);
    }
    
}
