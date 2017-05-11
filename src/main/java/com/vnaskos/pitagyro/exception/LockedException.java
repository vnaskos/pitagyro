package com.vnaskos.pitagyro.exception;

/**
 *
 * @author Vasilis Naskos
 */
public class LockedException extends Exception {

    private final String message;
    
    public LockedException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
    
}
