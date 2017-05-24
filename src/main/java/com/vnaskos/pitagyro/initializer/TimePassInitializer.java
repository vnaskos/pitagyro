package com.vnaskos.pitagyro.initializer;

import com.vnaskos.pitagyro.GameWorld;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Vasilis Naskos
 */
public class TimePassInitializer implements Initializer {

    @Override
    public void initialize() throws Exception {
        ScheduledExecutorService executor
                = Executors.newSingleThreadScheduledExecutor();

        Runnable periodicTask = new Runnable() {
            @Override
            public void run() {
                GameWorld.INSTANCE.getPlayer().reduceHealthBy(10);
                System.out.println("Exases kialla kila, tora eisai: "
                        + GameWorld.INSTANCE.getPlayer().getHealthPoints());
            }
        };

        executor.scheduleAtFixedRate(periodicTask, 30, 30, TimeUnit.SECONDS);
    }
    
}
