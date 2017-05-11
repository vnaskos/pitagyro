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
        dictionary.registerCommand("pane", "com.vnaskos.pitagyro.command.GoCommand");
        dictionary.registerCommand("xekleidose", "com.vnaskos.pitagyro.command.UnlockCommand");
        dictionary.registerCommand("ase", "com.vnaskos.pitagyro.command.BetrayCommand");
        dictionary.registerCommand("help", "com.vnaskos.pitagyro.command.HelpCommand");
        dictionary.registerCommand("pare", "com.vnaskos.pitagyro.command.PickCommand");
        dictionary.registerCommand("ftiakse", "com.vnaskos.pitagyro.command.MakeCommand");
        dictionary.registerCommand("ftiaxe", "com.vnaskos.pitagyro.command.MakeCommand");
        dictionary.registerCommand("attack", "com.vnaskos.pitagyro.command.AttackCommand");
        dictionary.registerCommand("rixe", "com.vnaskos.pitagyro.command.DropCommand");
        dictionary.registerCommand("save", "com.vnaskos.pitagyro.command.SaveCommand");
        dictionary.registerCommand("load", "com.vnaskos.pitagyro.command.LoadCommand");
        dictionary.registerCommand("items", "com.vnaskos.pitagyro.command.InventoryCommand");
        dictionary.registerWord("pirouni", Syntax.Type.ITEM);
        dictionary.registerWord("pita", Syntax.Type.ITEM);
        dictionary.registerWord("gyro", Syntax.Type.ITEM);
    }
    
}
