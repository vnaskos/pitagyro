package com.vnaskos.pitagyro.exception;

/**
 *
 * @author Vasilis Naskos
 */
public class InvalidCommandException extends Exception {
    
    private final String message;
    
    public InvalidCommandException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
    
}
