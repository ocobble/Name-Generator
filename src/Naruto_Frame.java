import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Naruto_Frame extends JFrame
{
	JPanel questionsPanel;
    JPanel ninjafyPanel = new JPanel();
    JPanel namePanel = new JPanel();
    JPanel villagePanel = new JPanel();
    
    JTextField firstNameField = new JTextField(10);
    JTextField lastNameField = new JTextField(10);
    JTextField hogwartsHouseField = new JTextField(10);
    JTextField ninjaNameField = new JTextField(20);
    
    JLabel firstLabel = new JLabel("Enter first name");
    JLabel lastLabel = new JLabel("Enter last name");
    JLabel hogwartsLabel = new JLabel("Select your hogwarts house");
    JLabel resultLabel = new JLabel("You are:" );
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
        
        /* Set alignments of all elements */
        firstLabel.setHorizontalAlignment(JLabel.LEFT);
        lastLabel.setHorizontalAlignment(JLabel.LEFT);
        hogwartsLabel.setHorizontalAlignment(JLabel.LEFT);
        firstNameField.setHorizontalAlignment(JTextField.LEFT);
        lastNameField.setHorizontalAlignment(JTextField.LEFT);
        hogwartsHouseField.setHorizontalAlignment(JTextField.LEFT);
        ninjaNameField.setHorizontalAlignment(JTextField.CENTER);
        resultLabel.setHorizontalAlignment(JLabel.CENTER);
        ninjafy.setHorizontalAlignment(JButton.CENTER);
        
        /*
         * Questions panel is a gridbag layout, so
         * set constraints of each element and add them
         */
        
        GridBagLayout gridbag = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();

        questionsPanel = new JPanel(gridbag);

        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.ipady = 0;
        
        
        gridbag.setConstraints(firstLabel, c);
        questionsPanel.add(firstLabel);
        
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.weightx = 1;
        
        gridbag.setConstraints(firstNameField, c);
        questionsPanel.add(firstNameField);
        
        c.gridwidth = 1;
        
        gridbag.setConstraints(lastLabel, c);
        questionsPanel.add(lastLabel);
        
        c.gridwidth = GridBagConstraints.REMAINDER;
        
        gridbag.setConstraints(lastNameField, c);
        questionsPanel.add(lastNameField);
        
        c.gridwidth = 1;
        
        gridbag.setConstraints(hogwartsLabel, c);
        questionsPanel.add(hogwartsLabel);
        
        c.gridwidth = GridBagConstraints.REMAINDER;
        
        gridbag.setConstraints(houseScroller, c);
        questionsPanel.add(houseScroller);
        
        c.ipadx = 50;
        c.fill = GridBagConstraints.NONE;
        c.gridheight = 3;
        
        gridbag.setConstraints(ninjafy, c);
        questionsPanel.add(ninjafy);

        JLabel leafLabel = new JLabel(leaf);
        JLabel cloudLabel = new JLabel(cloud);
        JLabel sandLabel = new JLabel(sand);
        JLabel mistLabel = new JLabel(mist);
        JLabel stoneLabel = new JLabel(stone);
        
        namePanel.add(resultLabel);
        namePanel.add(ninjaNameField);
        
        villagePanel.add(errorLabel);
        
        this.add(questionsPanel);
        this.add(villagePanel);
        this.add(namePanel);
        pack();
        
        /* Button action listener */
        ninjafy.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String ninjaFirst;
                String ninjaLast;
                String ninjaVillage;
                Color fave = null;
                
                ninjaFirst = Name_Helper.ninjafy(firstNameField.getText());
                ninjaLast = Name_Helper.ninjafy(lastNameField.getText());
                ninjaVillage = Name_Helper.villageIdentifier((String) houseScroller.getSelectedItem());
                
                villagePanel.removeAll();
                
                if (!ninjaFirst.isEmpty() || !ninjaLast.isEmpty())
                {
                	ninjaNameField.setText(ninjaFirst + " " + ninjaLast + " of the " + ninjaVillage);
                	
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
                    
                    questionsPanel.setBackground(fave);
                	villagePanel.setBackground(fave);
                	ninjafyPanel.setBackground(fave);
                	namePanel.setBackground(fave);
                	questionsPanel.setForeground(Color.BLACK);
                }
                
                // No name provided
                else {
                	errorLabel.setText("Please enter a first or last name");
                	villagePanel.add(errorLabel);
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