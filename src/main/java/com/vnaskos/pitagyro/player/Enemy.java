package com.vnaskos.pitagyro.player;

import com.vnaskos.pitagyro.GameWorld;
import java.io.Serializable;

/**
 *
 * @author Vasilis Naskos
 */
public class Enemy implements Actor, Serializable {

    private static final long serialVersionUID = -5864513890233672262L;

    protected String name;
    protected int healthPoints;
    protected int attackPoints;
    protected int defensePoints;

    public Enemy(String name,
            int healthPoints, int attackPoints, int defensePoints) {
        this.name = name;
        this.healthPoints = healthPoints;
        this.attackPoints = attackPoints;
        this.defensePoints = defensePoints;
    }
    
    @Override
    public void act() {
        if(isDead()) {
            return;
        }
        
        GameWorld gw = GameWorld.INSTANCE;
        Player player = gw.getPlayer();
        System.out.println("Ha yaa");
        player.reduceHealthBy(attackPoints);
        System.out.println("Player HP: " + player.getHealthPoints());
    }
    
    @Override
    public boolean isDead() {
        return healthPoints <= 0;
    }

    @Override
    public void reduceHealthBy(int value) {
        if((value-defensePoints) > healthPoints) {
            healthPoints = 0;
        } else {
            healthPoints -= (value-defensePoints);
        }
        
        if(isDead()) {
            System.out.println("Enemy is DEAD!");
        }
    }
    
    @Override
    public int getHealthPoints() {
        return healthPoints;
    }
    
    @Override
    public String getName() {
        return name;
    }
}
