package com.vnaskos.pitagyro.initializer;

import com.vnaskos.pitagyro.grammar.Syntax;
import com.vnaskos.pitagyro.grammar.DefaultDictionary;
import com.vnaskos.pitagyro.grammar.Dictionary;

/**
 *
 * @author Vasilis Naskos
 */
public class DefaultDictionaryInitializer implements Initializer {

    @Override
    public void initialize() throws Exception {
        Dictionary dictionary = DefaultDictionary.getInstance();
        dictionary.registerCommand("com.vnaskos.pitagyro.command.GoCommand",
                "pane", "trexa", "go");
        dictionary.registerCommand("com.vnaskos.pitagyro.command.UnlockCommand",
                "xekleidose", "unlock");
        dictionary.registerCommand("com.vnaskos.pitagyro.command.BetrayCommand",
                "ase");
        dictionary.registerCommand("com.vnaskos.pitagyro.command.HelpCommand",
                "voitheia", "help");
        dictionary.registerCommand("com.vnaskos.pitagyro.command.PickCommand",
                "pare", "take");
        dictionary.registerCommand("com.vnaskos.pitagyro.command.MakeCommand",
                "ftiakse", "ftiaxe", "make");
        dictionary.registerCommand("com.vnaskos.pitagyro.command.AttackCommand",
                "epithesi", "attack");
        dictionary.registerCommand("com.vnaskos.pitagyro.command.DropCommand",
                "rixe", "drop");
        dictionary.registerCommand("com.vnaskos.pitagyro.command.SaveCommand",
                "save");
        dictionary.registerCommand("com.vnaskos.pitagyro.command.LoadCommand",
                "load");
        dictionary.registerCommand("com.vnaskos.pitagyro.command.InventoryCommand",
                "sakos", "antikeimena", "items");
        dictionary.registerWord("pirouni", Syntax.Type.ITEM);
        dictionary.registerWord("pita", Syntax.Type.ITEM);
        dictionary.registerWord("gyro", Syntax.Type.ITEM);
    }
    
}
