/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package BaseCode;

import ProjectCode.PlayerHand;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author arush
 */
public class PlayerTest {
    
    private Player testPlayer;
    
    public PlayerTest() {
        testPlayer = new Player("Ariel") {
            @Override
            public void play() {}};
    }
    
    @Before
    public void setUp() {
    }

    /**
     * Test of getName method, of class Player.
     */
    @Test
    public void testGetNameGOOD() {
        System.out.println("getNameGOOD returns player name");
        Player instance = new Player("Ariel") {
            @Override
            public void play() {}};
        String expResult = "Ariel";
        String result = instance.getName();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetNameBAD() {
        System.out.println("getNameBAD doesn't return player name");
        Player player = new Player("") {
            @Override
            public void play() {}};
        boolean result = false;
        if(player.getName().length() > 0) 
            result = true;           
        boolean expResult = false;
        assertEquals(expResult, result);
    }

    

    
    
}
