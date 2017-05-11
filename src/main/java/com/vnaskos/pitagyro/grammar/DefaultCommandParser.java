package com.vnaskos.pitagyro.grammar;

import com.vnaskos.pitagyro.command.Command;
import com.vnaskos.pitagyro.command.CommandArgument;
import com.vnaskos.pitagyro.exception.InvalidCommandException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Vasilis Naskos
 */
public class DefaultCommandParser implements Parser {

    @Override
    public Command constructCommand(String[] tokens) throws Exception {
        Dictionary dictionary = DefaultDictionary.getInstance();
        
        Command command = null;
        List<CommandArgument> args = new ArrayList<>();
        
        for(String token : tokens) {
            Syntax.Type tokenType = dictionary.recognizeToken(token);
           
            if(tokenType == null) {
                continue;
            }
            
            switch(tokenType) {
                case VERB:
                    command = dictionary.recognizeCommand(token);
                    break;
                case ITEM:
                    args.add(new CommandArgument(token));
                    break;
                case DIRECTION:
                    args.add(new CommandArgument(
                            dictionary.recognizeDirection(token)));
                    break;
            }
        }
        
        if(command == null) {
            throw new InvalidCommandException("Invalid command");
        }
        
        command.setArguments(args.toArray(new CommandArgument[]{}));
        
        return command;
    }
    
}
