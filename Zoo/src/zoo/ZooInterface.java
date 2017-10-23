/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zoo;

import java.awt.ComponentOrientation;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
/**
 *
 * @author Ryan
 */
public class ZooInterface extends JFrame{
    JComboBox S1;
    JLabel AddRemoveLabel,AddSearchLabel;
    JButton AddAnimalButton, RemoveAnimalButton,SearchAnimalButton;
    JTextField SearchField, AddField, RemoveField;
    
    ZooInterface(){
        String[] Animals = {"Butterfly", "Camel", "Gorilla", "Horse", "Lions",  "Monkey", "Penguin", "Seal", "Sloth", "Tiger", "Tortoise"};
        S1 = new JComboBox(Animals);

                
        
        AddRemoveLabel = new JLabel("Insert ID to remove");
        AddSearchLabel = new JLabel("Search for Animal");
        
        AddAnimalButton = new JButton("Add");
        RemoveAnimalButton = new JButton("Remove");
        SearchAnimalButton = new JButton("Search");
        
        SearchField = new JTextField("");
        AddField = new JTextField("name");
        RemoveField = new JTextField("");
        
        JFrame guiFrame = new JFrame("Grid Layout");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(525, 400);
        final JPanel Panel = new JPanel();
        GridLayout Lay = new GridLayout(3,4,10,10);

        this.setLayout(Lay);
        
        
        this.setTitle("Detroit Zoo");
        
        this.setResizable(false);
        
        Panel.setLayout(Lay);
        Panel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        Panel.add(AddField);
        Panel.add(S1);
        Panel.add(AddAnimalButton);
        Panel.add(AddRemoveLabel);
        Panel.add(AddRemoveLabel);
        Panel.add(RemoveField);
        Panel.add(RemoveAnimalButton);
        Panel.add(AddSearchLabel);
        Panel.add(SearchField);
        Panel.add(SearchAnimalButton);
        
        
        
        
        this.add(Panel);
        
    }
        void addListeners(ActionListener Listeners) {
        
        AddAnimalButton.addActionListener(Listeners);
        RemoveAnimalButton.addActionListener(Listeners);
        SearchAnimalButton.addActionListener(Listeners);
    }
}
