/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zoo;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ryan
 */
public class ZooKeeperTest {
    
    public ZooKeeperTest() {
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
     * Test of AddAnimal method, of class ZooKeeper.
     */
    @Test
    public void testAddAnimal() {
        System.out.println("AddAnimal");
        ZooKeeper instance = null;
        instance.AddAnimal();

    }

    /**
     * Test of RemoveAnimal method, of class ZooKeeper.
     */
    @Test
    public void testRemoveAnimal() {
        System.out.println("RemoveAnimal");
        ZooKeeper instance = null;
        instance.RemoveAnimal();

    }

    /**
     * Test of displayAnimals method, of class ZooKeeper.
     */
    @Test
    public void testDisplayAnimals() {
        System.out.println("displayAnimals");
        ZooKeeper instance = null;
        instance.displayAnimals();

    }
    
}
