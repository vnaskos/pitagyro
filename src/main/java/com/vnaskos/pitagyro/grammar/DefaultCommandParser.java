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
        List<Syntax.Type> syntaxTypes = new ArrayList<>();
        
        for(String token : tokens) {
            Syntax.Type tokenType = dictionary.recognizeToken(token);
           
            if(tokenType == null) {
                continue;
            }
            
            syntaxTypes.add(tokenType);
            
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
        
        Syntax givenSyntax = new Syntax(syntaxTypes.toArray(new Syntax.Type[0]));
        if(command.checkSyntax(givenSyntax)) {
             throw new InvalidCommandException("Wrong syntax");
        }
        
        command.setArguments(args.toArray(new CommandArgument[]{}));
        
        return command;
    }
    
}
