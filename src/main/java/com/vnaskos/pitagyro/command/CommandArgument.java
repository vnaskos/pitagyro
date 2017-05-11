package com.vnaskos.pitagyro.command;

/**
 *
 * @author Vasilis Naskos
 * @param <T> type of the value
 */
public class CommandArgument<T> {
    
    private T value;

    public CommandArgument() {
    }
    
    public CommandArgument(T value) {
        this.value = value;
    }
    
    public T getValue() {
        return value;
    }

    public CommandArgument setValue(T argument) {
        this.value = argument;
        return this;
    }
    
}
