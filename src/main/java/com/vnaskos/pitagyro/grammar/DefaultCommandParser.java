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

    private final Dictionary dictionary;
    private final List<CommandArgument> args;
    private final Syntax.Builder syntaxBuilder;
    private Command command;

    public DefaultCommandParser() {
        this.dictionary = DefaultDictionary.getInstance();
        this.args = new ArrayList<>();
        this.syntaxBuilder = new Syntax.Builder();
    }
    
    private void clearLastCommand() {
        command = null;
        args.clear();
        syntaxBuilder.clear();
    }
    
    @Override
    public Command constructCommand(String[] tokens) throws Exception {
        clearLastCommand();
        
        for(String token : tokens) {
            Syntax.Type tokenType = dictionary.recognizeToken(token);
           
            if(tokenType != null) {
                processToken(tokenType, token);
            }
        }
        
        validateCommand();
        
        return command;
    }

    private void processToken(Syntax.Type tokenType, String token)
            throws Exception {
        syntaxBuilder.add(tokenType);
        
        switch(tokenType) {
            case VERB:
                processVerbToken(token);
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
    
    private void processVerbToken(String verb) {
        Command tmpCommand = dictionary.recognizeCommand(verb);
        
        if (command == null) {
            command = tmpCommand;
        } else {
            args.add(new CommandArgument(tmpCommand));
        }
    }
    
    private void validateCommand() throws InvalidCommandException {
        if(command == null) {
            throw new InvalidCommandException("Invalid command");
        }
        
        command.setArguments(args.toArray(new CommandArgument[0]));
        
        Syntax givenSyntax = syntaxBuilder.build();
        if(!command.isSyntaxValid(givenSyntax)) {
            throw new InvalidCommandException("Wrong syntax");
        }
    }
    
}
