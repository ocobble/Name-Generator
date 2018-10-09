import java.util.Scanner;
//import org.apache.commons.lang3;

public class Name_Helper {
    private static String[] ninjaSounds = {"ka", "zu", "mi", "te", "ku", "lu", 
            "ji", "ri", "ki", "zus", "me", "ta", "rin", "to", "mo", "no", "ke", 
            "shi", "ari", "chi", "ha", "ru", "mei", "na", "fu", "zi"};
    /**
    private static void main(String[] args) {
        

        Scanner keyboard = new Scanner(System.in);
        String firstName = "";
        String ninjaFirst = "";
        String lastName = "";
        String ninjaLast = "";
        String house = "";
        String village = "";
        
        System.out.println("Enter your first name");
        firstName = keyboard.nextLine();
        ninjaFirst = ninjafy(firstName, ninjaSounds);
        
        System.out.println("Enter your last name");
        lastName = keyboard.nextLine();
        ninjaLast = ninjafy(lastName, ninjaSounds);
        
        System.out.println("What hogwarts house do you consider yourself to be in?");
        System.out.println("Gryffindor: brave");
        System.out.println("Ravenclaw: smart");
        System.out.println("Slytherin: evil");
        System.out.println("Hufflepuff: other");
        house = keyboard.nextLine();
        village = villageIdentifier(house);
                
        System.out.println("You are:");
        System.out.println(ninjaFirst + " " + ninjaLast + " of the " + village + " village.");
        
        keyboard.close();
    }
    **/
    public static String ninjafy(String name) {
        String ninjyName = "";
        int startingPlace = name.length() - 1;
        for (int i = startingPlace; i > (startingPlace - 3) && i > 0; --i) { // You can change this!
            char letter = name.charAt(i);
            letter = Character.toLowerCase(letter);
            int helpful = Character.getNumericValue(letter);
            helpful -= 10;
            ninjyName += ninjaSounds[helpful];
        }
        
        ninjyName = Character.toUpperCase(ninjyName.charAt(0)) + ninjyName.substring(1, ninjyName.length());
        
        return ninjyName;
    }
    public static String villageIdentifier(String hog) {
        if (hog.equalsIgnoreCase("Gryffindor")) {
            return "Leaf";
        }
        else if (hog.equalsIgnoreCase("Ravenclaw")) {
            return "Mist";
        }
        else if (hog.equalsIgnoreCase("Slytherin")) {
            return "Sand";
        }
        else if (hog.equalsIgnoreCase("Hufflepuff")) {
            return "Cloud";
        }
        else {
            return "Stone";
        }
    }
}
