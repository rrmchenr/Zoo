/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zoo;

/**
 *
 * @author Ryan
 */
public class Zoo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ZooInterface ZIO = new ZooInterface();
        ZooKeeper ZKO = new ZooKeeper(ZIO);
        
        ZIO.setVisible(true);
    }
    
}
