/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zoo;

import java.awt.event.ActionListener;
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
public class ZooInterfaceTest {
    
    public ZooInterfaceTest() {
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
     * Test of addListeners method, of class ZooInterface.
     */
    @Test
    public void testAddListeners() {
        System.out.println("addListeners");
        ActionListener Listeners = null;
        ZooInterface instance = new ZooInterface();
        instance.addListeners(Listeners);

    }

    @Test
    public void testCreateSearchWindow() {
        System.out.println("createSearchWindow");
        String list = "hello";
        ZooInterface instance = new ZooInterface();
        instance.createSearchWindow(list);

    }

    @Test
    public void testDisplayWarning() {
        System.out.println("DisplayWarning");
        ZooInterface instance = new ZooInterface();
        instance.DisplayWarning();

    }
    
}
