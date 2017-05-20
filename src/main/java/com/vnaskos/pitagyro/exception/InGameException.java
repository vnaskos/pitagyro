package com.vnaskos.pitagyro.exception;

/**
 *
 * @author Vasilis Naskos
 */
public class InGameException extends Exception {
    
    private final String message;
    
    public InGameException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
    
}
