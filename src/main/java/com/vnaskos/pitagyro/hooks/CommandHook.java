package com.vnaskos.pitagyro.hooks;

/**
 *
 * @author Vasilis Naskos
 */
public interface CommandHook {
    
    boolean beforeExcecution();
    void afterExcecution();
    
}
