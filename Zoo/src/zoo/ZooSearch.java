/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zoo;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;



public class ZooSearch extends JDialog{
    JTextArea JTA;
    JScrollPane ScrollAnimals;
    //string is passed in to display
    public ZooSearch(JFrame frame, String list){
    super(frame, "Help Window", true);
    setLayout(new FlowLayout());
    
    JTA = new JTextArea(list);
    JTA.setEditable(false);
    ScrollAnimals = new JScrollPane(JTA);
    ScrollAnimals.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    ScrollAnimals.setPreferredSize(new Dimension(250,350));
    ScrollAnimals.setMinimumSize(new Dimension(10,10));
    
    add(ScrollAnimals);
    }
}

