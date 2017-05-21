package com.vnaskos.pitagyro.initializer;

import com.cedarsoftware.util.io.JsonWriter;
import com.vnaskos.pitagyro.PitaGyro;
import com.vnaskos.pitagyro.gate.GateBuilder;
import com.vnaskos.pitagyro.item.ContainerItem;
import com.vnaskos.pitagyro.item.Item;
import com.vnaskos.pitagyro.item.PassiveItem;
import com.vnaskos.pitagyro.item.UsableItem;
import com.vnaskos.pitagyro.item.property.Usable;
import com.vnaskos.pitagyro.location.Direction;
import com.vnaskos.pitagyro.location.Location;
import com.vnaskos.pitagyro.location.Room;
import com.vnaskos.pitagyro.player.Enemy;
import com.vnaskos.pitagyro.util.Pair;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vasilis Naskos
 */
public class TestMapInitializer extends MapInitializer {
    
    @Override
    public void initialize() {
        //Init rooms
        Room r1 = new Room("sto giradiko tou Vlasi", "Vlepo 3 portes kai 1 pirouni");
        Room r2 = new Room("stin toualeta", "Vlepo mia merida gyro");
        Room r3 = new Room("sta nisia Cayman (Opa opa! ela piso pou pas)", "Op sa na vlepo mia pita");
        Room r4 = new Room("sto ouzeri tou mpelami", "Hmmmm");
        
        startLocation = r1;
        
        //Init items
        Item key = new PassiveItem("pirouni", "Key to unlock door 1");
        Item pita = new PassiveItem("pita", "PITAAAA");
        Item gyros = new PassiveItem("gyro", "Gyroooos");
        Item apola = new PassiveItem("apola", "I perigrafi den einai diathesimi! To ap'ola orizete diaforetika se kathe poli");
        ContainerItem psigeio = new ContainerItem("psigeio", "ena aplo psigeio", apola);
        UsableItem<Integer> maxairi = new UsableItem<>("maxairi", Usable.UseCase.ATTACK, 10);
        UsableItem<Integer> patates = new UsableItem<>("patates", Usable.UseCase.HEALTH, 5);
        
        r1.addItem(key.getName(), key);
        r1.addItem(maxairi.getName(), maxairi);
        r3.addItem(pita.getName(), pita);
        r2.addItem(gyros.getName(), gyros);
        r4.addItem(psigeio.getName(), psigeio);
        r4.addItem(patates.getName(), patates);
        
        Enemy e3 = new Enemy("o kardiologos", 30, 5, 0);
        r3.setRoomCharacater(e3);
        
        //Locked Door r1 - r2 
        new GateBuilder(
                new Pair(Direction.KATO, r1),
                new Pair(Direction.PANO, r2))
                .key(key).buildAndAttach();
        
        //Door r1 r3
        new GateBuilder(
                new Pair(Direction.PANO, r1),
                new Pair(Direction.KATO, r3))
                .buildAndAttach();
        
        // Door r1 r3
        new GateBuilder(
                new Pair(Direction.DEXIA, r1),
                new Pair(Direction.ARISTERA, r4))
                .buildAndAttach();
        
        //exportMapToJSON(startLocation);
    }
    
    private static void exportMapToJSON(Location location) {
        HashMap<String, Object> jsonArgs = new HashMap<>();
        jsonArgs.put("PRETTY_PRINT", true);
        String json = JsonWriter.objectToJson(location, jsonArgs);

        try (PrintWriter out = new PrintWriter("test_map.json")) {
            out.print(json);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PitaGyro.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println(json);
    }
    
}
