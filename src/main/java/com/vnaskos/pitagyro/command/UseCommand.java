package com.vnaskos.pitagyro.command;

import com.vnaskos.pitagyro.exception.InGameException;
import com.vnaskos.pitagyro.exception.NotFoundException;
import com.vnaskos.pitagyro.grammar.Syntax;
import com.vnaskos.pitagyro.item.Item;
import com.vnaskos.pitagyro.item.property.Usable;
import com.vnaskos.pitagyro.location.Location;
import com.vnaskos.pitagyro.player.Player;

/**
 *
 * @author Vasilis Naskos
 */
public class UseCommand extends Command {

    @Override
    protected void executeCommand() throws InGameException {
        Player player = getPlayer();
        
        String itemName = (String) args[0].getValue();
        
        Item item = player.dropItem(itemName);
        
        if(item == null) {
            throw new InGameException("To antikeimeno den vrethike sto sako sou");
        }
        
        if(!(item instanceof Usable) || !((Usable) item).canUse()) {
            player.storeItem(item);
            throw new InGameException("To antikeimeno den mporei na xrisimopoiithei");
        }
        
        Usable usable = (Usable) item;
        
        switch(usable.getUseCase()) {
            case ATTACK:
                player.changeAttackBy((Integer)usable.getValue());
                System.out.println("Attack changed by " + (Integer)usable.getValue());
                break;
            case DEFENCE:
                player.changeDefenceBy((Integer)usable.getValue());
                System.out.println("Defence changed by " + (Integer)usable.getValue());
                break;
            case HEALTH:
                player.changeHealthBy((Integer)usable.getValue());
                System.out.println("Health changed by " + (Integer)usable.getValue());
                break;
        }
    }

    @Override
    public void help() {
        System.out.println("Use an item, not every item is usable");
    }

    @Override
    protected Syntax[] getSyntax() {
        Syntax[] syntax = new Syntax[1];
        syntax[0] = new Syntax.Builder().verb().item().build();
        return syntax;
    }
}
