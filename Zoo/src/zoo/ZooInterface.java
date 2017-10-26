package zoo;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class ZooInterface extends JFrame {

    JComboBox S1, S2;
    JLabel AddRemoveLabel, AddSearchLabel;
    JButton AddAnimalButton, RemoveAnimalButton, SearchAnimalButton;
    JTextField SearchField, AddField, RemoveField;
    JFrame guiFrame;

    ZooInterface() {
        //make look and feel of the java GUIS reflect users platform
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Color GUIS 
        UIManager.put("Button.background", Color.GRAY);
        UIManager.put("Panel.background", Color.LIGHT_GRAY);
        UIManager.put("Frame.background", Color.LIGHT_GRAY);

        //String array for ADD drop down menu
        String[] Animals = {"Butterfly", "Camel", "Gorilla", "Horse", "Lion", "Monkey", "Penguin", "Seal", "Sloth", "Tiger", "Tortoise"};

        //Initilize array for DISPLAY drop down menu
        String[] AllAnimals = new String[Animals.length + 1];

        AllAnimals[0] = "All";
        for (int x = 1; x <= Animals.length; x++) {
            AllAnimals[x] = Animals[x - 1];
        }
        //Initilize ComboBoxes
        S1 = new JComboBox(Animals);
        S2 = new JComboBox(AllAnimals);

        //Initilize JLabels
        AddRemoveLabel = new JLabel("Insert ID to remove");
        AddSearchLabel = new JLabel("Search for Animal");

        //Initilize JButtons
        AddAnimalButton = new JButton("Add");
        RemoveAnimalButton = new JButton("Remove");
        SearchAnimalButton = new JButton("Display");

        //Initilize JTextFields
        SearchField = new JTextField("");
        AddField = new JTextField("name");
        RemoveField = new JTextField("");

        //set Limit for input text 
        AddField.setDocument(new JTextFieldLimit(100));

        //Grid layout format
        guiFrame = new JFrame("Grid Layout");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(525, 400);
        final JPanel Panel = new JPanel();
        GridLayout Lay = new GridLayout(3, 4, 10, 10);
        this.setLayout(Lay);
        this.setTitle("Detroit Zoo");

        //add components to the Panel for disiplay
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
        Panel.add(S2);
        Panel.add(SearchAnimalButton);
        //adds entire panel to the screen
        this.add(Panel);

    }

    //adds actionlisteners to all the buttons

    void addListeners(ActionListener Listeners) {

        AddAnimalButton.addActionListener(Listeners);
        RemoveAnimalButton.addActionListener(Listeners);
        SearchAnimalButton.addActionListener(Listeners);
    }

    //Creates window when search button is called

    public void createSearchWindow(String list) {
        ZooSearch SWO = new ZooSearch(ZooInterface.this, list);
        SWO.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        SWO.setSize(300, 400);
        SWO.setVisible(true);
        SWO.setTitle("Search");
    }

    //Warning if a number is not input for Remove function

    public void DisplayWarning() {
        JOptionPane.showMessageDialog(guiFrame, "Please insert a number");
    }
}
