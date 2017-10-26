package zoo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class ZooKeeper {

    //ZooInterface object

    private final ZooInterface ZI;

    public ZooKeeper(ZooInterface ZI) {
        this.ZI = ZI;

        this.ZI.addListeners(new ZooListener());
    }

    //Button functionality

    class ZooListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            //Add animal button is pressed
            if (ae.getSource() == ZI.AddAnimalButton) {

                AddAnimal();
            } //Remove animal button is pressed
            else if (ae.getSource() == ZI.RemoveAnimalButton) {
                System.out.println("Remove");
                RemoveAnimal();
            } //Search animal button is pressed
            else if (ae.getSource() == ZI.SearchAnimalButton) {
                System.out.println("Search");
                displayAnimals();
            }
        }

    }

    public void AddAnimal() {
        //Try and make database connection
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "");
            //Insert command for database
            String insert = "INSERT INTO animals(name, type)" + "VALUES (?,?)";
            PreparedStatement PS = con.prepareStatement(insert);
            PS.setString(1, ZI.AddField.getText());
            PS.setString(2, ZI.S1.getSelectedItem().toString());
            //Performs the prepaired statement
            PS.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ZooKeeper.class.getName()).log(Level.SEVERE, null, ex);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ZooKeeper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void RemoveAnimal() {
        //flag for entering the database
        boolean flag = true;
        try {
            //attempts to make text field into an integer
            Integer.parseInt(ZI.RemoveField.getText());
        } //catches any non number
        catch (NumberFormatException e) {
            ZI.DisplayWarning();
            flag = false;
        }
        //When a number is input connect to the database
        if (flag == true) {
            try {
                //attempt to connect to database
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "");

                String delete = "DELETE FROM animals WHERE ID =" + ZI.RemoveField.getText() + "";
                PreparedStatement PS = con.prepareStatement(delete);

                //executes prepaired statement
                PS.execute();
            } catch (SQLException ex) {
                Logger.getLogger(ZooKeeper.class.getName()).log(Level.SEVERE, null, ex);

            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ZooKeeper.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void displayAnimals() {
        //prepairs a string for dispaly
        String display;
        try {
            //attempt to connect to database
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "");
            //When "all" is selected from the display drop down menu
            if (ZI.S2.getSelectedItem().toString() == "All") {
                display = "SELECT * FROM animals";
            } //Display all animanls from selected type
            else {
                display = "SELECT * FROM animals WHERE type = '" + ZI.S2.getSelectedItem().toString() + "'";
            }
            Statement PS = con.createStatement();
            //prepairs a result to display
            ResultSet rs = PS.executeQuery(display);
            String list = "";
            while (rs.next()) {
                //Creates string to display on the search window.
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String type = rs.getString("type");
                list = (list + id + ", " + name + ", " + type + "\n");
            }
            //create new window with the display results as a string
            ZI.createSearchWindow(list);
        } catch (SQLException ex) {
            Logger.getLogger(ZooKeeper.class.getName()).log(Level.SEVERE, null, ex);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ZooKeeper.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
