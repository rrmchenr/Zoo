package zoo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;

public class ZooKeeper {
        private final ZooInterface ZI;
    
    public ZooKeeper(ZooInterface ZI){
    this.ZI = ZI;
    
    this.ZI.addListeners(new ZooListener());
    }
    
    class ZooListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            if(ae.getSource()==ZI.AddAnimalButton){
                AddAnimal();
            System.out.println(ZI.AddField.getText());
            }
            
            else if(ae.getSource()==ZI.RemoveAnimalButton){
            System.out.println("Remove");
            RemoveAnimal();
            }
            else if(ae.getSource()==ZI.SearchAnimalButton){
            System.out.println("Search");
            }
        }
    
    }
    public void AddAnimal(){
     try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "");
            System.out.println("Connected!");
             String insert = "INSERT INTO animals(name, type)" + "VALUES (?,?)";
            PreparedStatement PS = con.prepareStatement(insert);
             PS.setString(1, ZI.AddField.getText());
             PS.setString(2, ZI.S1.getSelectedItem().toString());
             
             PS.execute();
                    } catch (SQLException ex) {
            Logger.getLogger(ZooKeeper.class.getName()).log(Level.SEVERE, null, ex);
            
        }   catch (ClassNotFoundException ex) {
                Logger.getLogger(ZooKeeper.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    public void RemoveAnimal(){
         try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "");

             String delete = "DELETE FROM animals WHERE ID ="+ZI.RemoveField.getText()+"";
            PreparedStatement PS = con.prepareStatement(delete);

             
             PS.execute();
                    } catch (SQLException ex) {
            Logger.getLogger(ZooKeeper.class.getName()).log(Level.SEVERE, null, ex);
            
        }   catch (ClassNotFoundException ex) {
                Logger.getLogger(ZooKeeper.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    }


