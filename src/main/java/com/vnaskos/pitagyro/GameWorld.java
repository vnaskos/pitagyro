package com.vnaskos.pitagyro;

import com.vnaskos.pitagyro.command.Command;
import com.vnaskos.pitagyro.grammar.DefaultCommandParser;
import com.vnaskos.pitagyro.grammar.DefaultCommandTokenizer;
import com.vnaskos.pitagyro.grammar.Parser;
import com.vnaskos.pitagyro.grammar.Tokenizer;
import com.vnaskos.pitagyro.player.Player;
import java.util.Scanner;

/**
 *
 * @author Vasilis Naskos
 */
public enum GameWorld {

    INSTANCE;
    
    protected Player player;

    public void setPlayer(Player player) {
        this.player = player;
    }
    
    public Player getPlayer() {
        return player;
    }
    
    public void play() {
        Scanner scan = new Scanner(System.in);
        Tokenizer tokenizer = new DefaultCommandTokenizer();
        Parser commandParser = new DefaultCommandParser();
        
        printWelcomeMessage();
        System.out.println("-> Vriskese " + player.getPosition().getName());
        
        while(true) {
            try {
                String[] tokens = tokenizer.tokenize(scan.nextLine());
                Command command = commandParser.constructCommand(tokens);
                command.execute();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    
    private void printWelcomeMessage() {
        System.out.println("Welcome to PitaGyro");
        System.out.println("----------------------------------------------------------------------");
        System.out.println("Geia sou eimai o Vlasis o agapimenos sou souvlatzis!\n"
                + "Prin apo 3 meres epathes emfragma pano apo 2 laxtarista\n"
                + "pitogyra me ap'ola, xoris kremmidi!!! Eutuxos tin skapoulares atimoutsiko\n"
                + "Tora pou eisai kai pali kala tha ithela na se keraso alla 2\n"
                + "alla exo stegnosei ntip apo ilika...\n"
                + "PROSEXE kala kathe lepto pou pernaei, makrua apo ta theika mou paraskeuasmata,\n"
                + "xaneis apo 1 kilo. Gi'auto prepei na viasteis prin xaseis\n"
                + "to sosiviaki sou uperoxe xontrouli mou!");
        System.out.println("----------------------------------------------------------------------\n");
    }
}
