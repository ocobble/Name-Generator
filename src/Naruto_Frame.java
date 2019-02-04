import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JList;

public class Naruto_Frame extends JFrame
{
    //JPanel questionsPanel = new JPanel(new GridLayout(4,1,5,20));

	JPanel questionsPanel;
    JPanel ninjafyPanel = new JPanel();
    JPanel namePanel = new JPanel();
    JPanel villagePanel = new JPanel();
    
    JTextField firstName = new JTextField(10);
    JTextField lastName = new JTextField(10);
    JTextField hogwartsHouse = new JTextField(10);
    JTextField ninjaName = new JTextField(20);
    
    JLabel firstLabel = new JLabel("Enter first name");
    JLabel lastLabel = new JLabel("Enter last name");
    JLabel hogwartsLabel = new JLabel("Select your hogwarts house");
    JLabel lessAwkward = new JLabel("You are:" );
    JLabel errorLabel = new JLabel();
    
    String[] houses = {"Gryffindor", "Ravenclaw", "Hufflepuff", "Slytherin", "idk man"};
    JComboBox<String> houseScroller = new JComboBox<String>(houses);
    
    JButton ninjafy = new JButton("Ninjafy!");
    
    ImageIcon leaf = new ImageIcon("src/konoha.jpg");
    ImageIcon cloud = new ImageIcon("src/Cloud Village.png-c200");
    ImageIcon sand = new ImageIcon("src/Sand village.png");
    ImageIcon mist = new ImageIcon("src/Mist Village.jpg");
    ImageIcon stone = new ImageIcon("src/Stone Village.jpg");
    
    public Naruto_Frame(String title)
    {
        super(title);
        setLayout(new GridLayout(3, 0));
        
        
        firstLabel.setHorizontalAlignment(JLabel.LEFT);
        lastLabel.setHorizontalAlignment(JLabel.LEFT);
        hogwartsLabel.setHorizontalAlignment(JLabel.LEFT);
        firstName.setHorizontalAlignment(JTextField.LEFT);
        lastName.setHorizontalAlignment(JTextField.LEFT);
        hogwartsHouse.setHorizontalAlignment(JTextField.LEFT);
        ninjaName.setHorizontalAlignment(JTextField.CENTER);
        lessAwkward.setHorizontalAlignment(JLabel.CENTER);
        ninjafy.setHorizontalAlignment(JButton.CENTER);
        
        
        GridBagLayout gridbag = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();

        questionsPanel = new JPanel(gridbag);
        //setFont(new Font("SansSerif", Font.PLAIN, 14));
        //setLayout(gridbag);

        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1;
        c.gridwidth = 1;                //reset to the default
        c.gridheight = 1;
        c.ipady = 0;
        
        
        gridbag.setConstraints(firstLabel, c);
        questionsPanel.add(firstLabel);
        
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.weightx = 1;
        //c.ipady = 2;
        
        gridbag.setConstraints(firstName, c);
        questionsPanel.add(firstName);
        
        c.gridwidth = 1;
        //c.ipady = 1;
        
        gridbag.setConstraints(lastLabel, c);
        questionsPanel.add(lastLabel);
        
        c.gridwidth = GridBagConstraints.REMAINDER;
        //c.ipady = 2;
        
        gridbag.setConstraints(lastName, c);
        questionsPanel.add(lastName);
        
        c.gridwidth = 1;
        //c.ipady = 1;
        
        gridbag.setConstraints(hogwartsLabel, c);
        questionsPanel.add(hogwartsLabel);
        
        c.gridwidth = GridBagConstraints.REMAINDER;
        //c.ipady = 2;
        
        gridbag.setConstraints(houseScroller, c);
        questionsPanel.add(houseScroller);
        
        //c.weightx = 500;
        c.ipadx = 50;
        c.fill = GridBagConstraints.NONE;
        c.gridheight = 3;
        
        gridbag.setConstraints(ninjafy, c);
        questionsPanel.add(ninjafy);
        
        //gridbag.setConstraints(errorLabel, c);
        //questionsPanel.add(errorLabel);
        //gridbag.setConstraints(firstName, c);
        //add(firstName);
        
        
        /*
        makebutton("Button3", gridbag, c);

        c.gridwidth = GridBagConstraints.REMAINDER; //end row
        makebutton("Button4", gridbag, c);

        c.weightx = 0.0;                //reset to the default
        makebutton("Button5", gridbag, c); //another row

        c.gridwidth = GridBagConstraints.RELATIVE; //next-to-last in row
        makebutton("Button6", gridbag, c);

        c.gridwidth = GridBagConstraints.REMAINDER; //end row
        makebutton("Button7", gridbag, c);

        c.gridwidth = 1;                //reset to the default
        c.gridheight = 2;
        c.weighty = 1.0;
        makebutton("Button8", gridbag, c);

        c.weighty = 0.0;                //reset to the default
        c.gridwidth = GridBagConstraints.REMAINDER; //end row
        c.gridheight = 1;               //reset to the default
        makebutton("Button9", gridbag, c);
        makebutton("Button10", gridbag, c);

        setSize(300, 100);
        */
        JLabel leafLabel = new JLabel(leaf);
        //villagePanel.add(leafLabel);
        JLabel cloudLabel = new JLabel(cloud);
        JLabel sandLabel = new JLabel(sand);
        JLabel mistLabel = new JLabel(mist);
        JLabel stoneLabel = new JLabel(stone);
        
        
        
        /*
        questionsPanel.add(firstLabel);
        questionsPanel.add(firstName);
        questionsPanel.add(lastLabel);
        questionsPanel.add(lastName);
        questionsPanel.add(hogwartsLabel);
        //questionsPanel.add(hogwartsHouse);
        questionsPanel.add(scroller);
        
        questionsPanel.add(ninjafy);
        */
        
        namePanel.add(lessAwkward);
        namePanel.add(ninjaName);
        
        villagePanel.add(errorLabel);
        
        this.add(questionsPanel);
        //this.add(ninjafyPanel);
        this.add(villagePanel);
        this.add(namePanel);
        pack();
        
        ninjafy.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String ninjaFirst;
                String ninjaLast;
                String ninjaVillage;
                Color fave = null;
                
                ninjaFirst = Name_Helper.ninjafy(firstName.getText());
                ninjaLast = Name_Helper.ninjafy(lastName.getText());
                ninjaVillage = Name_Helper.villageIdentifier((String) houseScroller.getSelectedItem());
                
                if (!ninjaVillage.equals("None"))
                {
                	ninjaName.setText(ninjaFirst + " " + ninjaLast + " of the " + ninjaVillage);
                }
                
                else {
                	errorLabel.setText("Please select a Hogwarts house");
                }
                
<<<<<<< HEAD
=======
                if (!ninjaVillage.equals("None"))
                {
                	ninjaName.setText(ninjaFirst + " " + ninjaLast + " of the " + ninjaVillage);
                }
                
>>>>>>> a494ac8a58f11ae5679d305c35f34bb57c614e34
                villagePanel.removeAll();
                
                switch(ninjaVillage)
                {
                    case("Leaf"):
                        villagePanel.add(leafLabel);
                        fave = Color.green;
                        break;
                    case("Cloud"):
                        villagePanel.add(cloudLabel);
                        fave = Color.YELLOW;
                         break;
                    case("Sand"):
                        villagePanel.add(sandLabel);
                        fave = Color.orange;
                        break;
                    case("Mist"):
                        villagePanel.add(mistLabel);
                        fave = Color.BLUE;
                        break;
                    case("Stone"):
                        villagePanel.add(stoneLabel);
                        fave = Color.ORANGE;
                        break;
                }
<<<<<<< HEAD
=======
                
                if (!ninjaVillage.equals("None"))
                {
                	questionsPanel.setBackground(fave);
                	villagePanel.setBackground(fave);
                	ninjafyPanel.setBackground(fave);
                	namePanel.setBackground(fave);
                	questionsPanel.setForeground(Color.BLACK);
                	villagePanel.updateUI();
                }
>>>>>>> a494ac8a58f11ae5679d305c35f34bb57c614e34
                
                if (!ninjaVillage.equals("None"))
                {
                	questionsPanel.setBackground(fave);
                	villagePanel.setBackground(fave);
                	ninjafyPanel.setBackground(fave);
                	namePanel.setBackground(fave);
                	questionsPanel.setForeground(Color.BLACK);
                	
                }
                else
                {
                	villagePanel.add(errorLabel);
                	errorLabel.setText("Please select a Hogwarts house");
                }
                
                villagePanel.updateUI();
            }
            
                });
        
        setSize(600,600);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        
        
    }
    
    public static void main(String[] args)
    {
        Naruto_Frame shinobi = new Naruto_Frame("Ninjafy your name!");
    }
}