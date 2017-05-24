package com.vnaskos.pitagyro;

import com.vnaskos.pitagyro.initializer.DefaultDictionaryInitializer;
import com.vnaskos.pitagyro.initializer.Initializer;
import com.vnaskos.pitagyro.initializer.JsonMapInitializer;
import com.vnaskos.pitagyro.initializer.MapInitializer;
import com.vnaskos.pitagyro.initializer.TestMapInitializer;
import com.vnaskos.pitagyro.initializer.TimePassInitializer;
import com.vnaskos.pitagyro.player.Player;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vasilis Naskos
 */
public class PitaGyro {
    
    public static void main(String[] args) throws Exception {
        new Thread(new Runnable() {
            @Override
            public void run() {
                mainGameThread();
            }
        }).start();
    }
    
    private static void mainGameThread() {
        MapInitializer mapInitializer = new TestMapInitializer();
//        MapInitializer mapInitializer = new JsonMapInitializer();

        Initializer[] gameInitializers = {
            new DefaultDictionaryInitializer(),
            mapInitializer,
            new TimePassInitializer()
        };

        for (Initializer gameInitializer : gameInitializers) {
            try {
                gameInitializer.initialize();
            } catch (Exception ex) {
                Logger.getLogger(PitaGyro.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        Player p = new Player(mapInitializer.getStartLocation());

        GameWorld gw = GameWorld.INSTANCE;
        gw.setPlayer(p);
        gw.play();
    }
}
