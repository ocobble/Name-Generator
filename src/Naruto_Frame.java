import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JList;

public class Naruto_Frame extends JFrame
{
    JPanel questionsPanel = new JPanel(new FlowLayout());
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
    
    String[] houses = {"Gryffindor", "Ravenclaw", "Hufflepuff", "Slytherin", "idk man"};
    
    
    JList<String> hogwartsHouses = new JList<String>(houses);
    JScrollPane scroller = new JScrollPane(hogwartsHouses);
    //hogwartsHouses.add(scroller);
    
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
        
        JLabel leafLabel = new JLabel(leaf);
        //villagePanel.add(leafLabel);
        JLabel cloudLabel = new JLabel(cloud);
        JLabel sandLabel = new JLabel(sand);
        JLabel mistLabel = new JLabel(mist);
        JLabel stoneLabel = new JLabel(stone);
        
        
        
        questionsPanel.add(firstLabel);
        questionsPanel.add(firstName);
        questionsPanel.add(lastLabel);
        questionsPanel.add(lastName);
        questionsPanel.add(hogwartsLabel);
        //questionsPanel.add(hogwartsHouse);
        questionsPanel.add(hogwartsHouses);
        
        questionsPanel.add(ninjafy);
        
        namePanel.add(lessAwkward);
        namePanel.add(ninjaName);
        
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
                ninjaVillage = Name_Helper.villageIdentifier(hogwartsHouses.getSelectedValue());
                
                ninjaName.setText(ninjaFirst + " " + ninjaLast + " of the " + ninjaVillage);
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
                questionsPanel.setBackground(fave);
                villagePanel.setBackground(fave);
                ninjafyPanel.setBackground(fave);
                namePanel.setBackground(fave);
                questionsPanel.setForeground(Color.BLACK);
                villagePanel.updateUI();
                
            }
            
                });
        
        setSize(210,600);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        
        
    }
    
    public static void main(String[] args)
    {
        Naruto_Frame shinobi = new Naruto_Frame("Ninjafy your name!");
    }
}
