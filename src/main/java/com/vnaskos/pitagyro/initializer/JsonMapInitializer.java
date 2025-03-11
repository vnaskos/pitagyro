package com.vnaskos.pitagyro.initializer;

import com.cedarsoftware.io.JsonReader;
import com.vnaskos.pitagyro.location.Location;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
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
            InputStream is = Files.newInputStream(Paths.get("test_map.json"));
            JsonReader jsonReader = new JsonReader(is, null);
            initialLocation = jsonReader.readObject(Location.class);
        } catch (IOException ex) {
            Logger.getLogger(JsonMapInitializer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Location getStartLocation() {
        return initialLocation;
    }
}
