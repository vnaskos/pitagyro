package com.vnaskos.pitagyro.player;

/**
 *
 * @author Vasilis Naskos
 */
public interface Actor {
    
    void act();
    boolean isDead();
    void reduceHealthBy(int value);
    int getHealthPoints();
    String getName();
}
