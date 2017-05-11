package com.vnaskos.pitagyro.command;

import com.vnaskos.pitagyro.GameWorld;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vasilis Naskos
 */
public class SaveCommand extends Command {

    @Override
    protected void executeCommand() {
        System.out.println("---Saving---");
        
        //use buffering
        try (FileOutputStream file = new FileOutputStream("pitagyro.dat");
                OutputStream buffer = new BufferedOutputStream(file);
                ObjectOutput output = new ObjectOutputStream(buffer)) {
            output.writeObject(GameWorld.INSTANCE.getPlayer());
        } catch (IOException ex) {
            Logger.getLogger(SaveCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("All Done!");
    }

    @Override
    public void help() {
        System.out.println("save");
    }
    
}
