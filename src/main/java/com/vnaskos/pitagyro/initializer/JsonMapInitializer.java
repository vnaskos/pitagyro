package com.vnaskos.pitagyro.initializer;

import com.cedarsoftware.util.io.JsonReader;
import com.vnaskos.pitagyro.location.Location;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vasilis Naskos
 */
public class JsonMapInitializer extends MapInitializer {

    protected Location initialLocation;
    
    @Override
    public void initialize() {
        try {
            InputStream is = new FileInputStream("test_map.json");
            initialLocation = (Location) JsonReader.jsonToJava(is, null);
        } catch (IOException ex) {
            Logger.getLogger(JsonMapInitializer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Location getStartLocation() {
        return initialLocation;
    }
}
