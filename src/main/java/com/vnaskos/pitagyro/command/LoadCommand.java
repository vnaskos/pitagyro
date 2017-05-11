package com.vnaskos.pitagyro.command;

import com.vnaskos.pitagyro.GameWorld;
import com.vnaskos.pitagyro.location.Location;
import com.vnaskos.pitagyro.player.Player;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vasilis Naskos
 */
public class LoadCommand extends Command {

    @Override
    protected void executeCommand() {
        System.out.println("---Loading---");
        
        try(InputStream file = new FileInputStream("pitagyro.dat");
                InputStream buffer = new BufferedInputStream(file);
                ObjectInput input = new ObjectInputStream(buffer)) {
            Player player = (Player) input.readObject();
            GameWorld.INSTANCE.setPlayer(player);
        } catch (IOException ex) {
            Logger.getLogger(LoadCommand.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoadCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("All Done!");
        
        Location loc = GameWorld.INSTANCE.getPlayer().getPosition();
        System.out.println("-> Vriskese " + loc.getName());
    }

    @Override
    public void help() {
        System.out.println("load");
    }
    
}
