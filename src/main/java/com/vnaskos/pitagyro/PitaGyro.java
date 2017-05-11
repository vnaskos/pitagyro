package com.vnaskos.pitagyro;

import com.cedarsoftware.util.io.JsonWriter;
import com.vnaskos.pitagyro.initializer.DefaultDictionaryInitializer;
import com.vnaskos.pitagyro.initializer.Initializer;
import com.vnaskos.pitagyro.initializer.MapInitializer;
import com.vnaskos.pitagyro.initializer.TestMapInitializer;
import com.vnaskos.pitagyro.location.Location;
import com.vnaskos.pitagyro.player.Player;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
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
        startGameThread();
        startTimeTrackingThread();
    }
    
    private static void startGameThread() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                MapInitializer mapInitializer = new TestMapInitializer();
//                MapInitializer mapInitializer = new JsonMapInitializer();

                Initializer[] gameInitializers = {
                    new DefaultDictionaryInitializer(),
                    mapInitializer
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
        }).start();
    }
    
    private static void startTimeTrackingThread() {
        ScheduledExecutorService executor
                = Executors.newSingleThreadScheduledExecutor();

        Runnable periodicTask = new Runnable() {
            @Override
            public void run() {
                GameWorld.INSTANCE.getPlayer().reduceHealthBy(10);
                System.out.println("Exases kialla kila, tora eisai: " + GameWorld.INSTANCE.getPlayer().getHealthPoints());
            }
        };

        executor.scheduleAtFixedRate(periodicTask, 30, 30, TimeUnit.SECONDS);
    }
    
    private static void exportMapToJSON(Location location) {
        HashMap<String, Object> jsonArgs = new HashMap<>();
        jsonArgs.put("PRETTY_PRINT", true);
        String json = JsonWriter.objectToJson(location, jsonArgs);
        
        try(PrintWriter out = new PrintWriter("test_map.json")) {
            out.print(json);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PitaGyro.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println(json);
    }
}
