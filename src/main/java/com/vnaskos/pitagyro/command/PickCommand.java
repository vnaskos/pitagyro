package com.vnaskos.pitagyro.command;

import com.vnaskos.pitagyro.exception.InGameException;
import com.vnaskos.pitagyro.exception.NotFoundException;
import com.vnaskos.pitagyro.grammar.Syntax;
import com.vnaskos.pitagyro.item.ContainerItem;
import com.vnaskos.pitagyro.item.Item;
import com.vnaskos.pitagyro.item.property.Pickable;
import com.vnaskos.pitagyro.location.Location;
import com.vnaskos.pitagyro.player.Player;

/**
 *
 * @author Vasilis Naskos
 */
public class PickCommand extends Command {

    protected Location currentLocation;
    
    @Override
    public void executeCommand() throws InGameException {
        currentLocation = getCurrentLocation();
        
        if(args.length == 2) {
            pickItemFromContainer();
        } else if(args.length == 1) {
            pickItemFromLocation();
        }
        
        clear();
    }
    
    protected void pickItemFromContainer() throws InGameException {
        String containerItemName = (String) args[0].getValue();
        Item container = searchLocationForItem(containerItemName);
        
        if(!(container instanceof ContainerItem)) {
            throw new InGameException(String.format(
                    "To antikeimeno '%s' den mporei na exei periexomeno",
                    containerItemName));
        }
        
        ContainerItem containerItem = (ContainerItem) container;
        
        if(!containerItem.canPick()) {
            throw new InGameException(
                    "Den mporeis na pareis to periexomeno eite to antikeimeno"
                            + " den einai anoixto i to exeis idi parei");
        }
        
        Item item = ((ContainerItem) container).getContainedItem();
        
        pickItem(item);
    }
    
    protected void pickItemFromLocation() throws InGameException {
        String itemName = (String) args[0].getValue();
        Item item = searchLocationForItem(itemName);
        pickItem(item);
        currentLocation.removeItem(itemName);
    }
    
    protected void pickItem(Item item) throws InGameException {
        if(!(item instanceof Pickable) || !((Pickable)item).canPick()) {
            throw new InGameException(
                    "Den mporeis na pareis auto to antikeimeno");
        }
        
        Player player = getPlayer();
        player.storeItem(item);
        
        System.out.println(item.getName() + " | " + item.getDescription());
        System.out.println("-- Prostethike sto sako sou --");
    }
    
    protected Item searchLocationForItem(String itemName)
            throws NotFoundException {
        if (!currentLocation.itemExists(itemName)) {
            throw new NotFoundException(
                    String.format("Den vrethike '%s' sto domatio", itemName));
        }
        
        return currentLocation.getItem(itemName);
    }

    @Override
    protected Syntax[] getSyntax() {
        Syntax[] syntax = new Syntax[2];
        syntax[0] = new Syntax.Builder().verb().item().build();
        syntax[1] = new Syntax.Builder().verb().item().item().build();
        return syntax;
    }

    @Override
    public void help() {
        System.out.println("Verb Item or Verb Container Item");
    }
    
    protected void clear() {
        currentLocation = null;
    }
    
}
