package com.vnaskos.pitagyro.item.property;

/**
 *
 * @author Vasilis Naskos
 * @param <T> depends on type of use
 */
public interface Usable<T> {
    
    public static enum UseCase {
        HEALTH, ATTACK, DEFENCE
    }
    
    boolean canUse();
    UseCase getUseCase();
    T getValue();
    
}
