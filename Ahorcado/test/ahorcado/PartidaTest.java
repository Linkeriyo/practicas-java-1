/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ahorcado;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author linke
 */
public class PartidaTest {
    
    public PartidaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of printHanged method, of class Partida.
     */
    @Test
    public void testPrintHanged() {
        System.out.println("printHanged");
        int num = 0;
        Partida instance = new Partida();
        instance.printHanged(num);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of wordContains method, of class Partida.
     */
    @Test
    public void testWordContains() {
        System.out.println("wordContains");
        char caracter = ' ';
        Partida instance = new Partida();
        boolean expResult = false;
        boolean result = instance.wordContains(caracter);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of win method, of class Partida.
     */
    @Test
    public void testWin() {
        System.out.println("win");
        char[] jugador = null;
        char[] palabraDiv = null;
        Partida instance = new Partida();
        boolean expResult = false;
        boolean result = instance.win(jugador, palabraDiv);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of play method, of class Partida.
     */
    @Test
    public void testPlay() {
        System.out.println("play");
        Partida instance = new Partida();
        instance.play();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
