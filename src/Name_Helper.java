public class Name_Helper {
    private static String[] ninjaSounds = {"ka", "zu", "mi", "te", "ku", "lu", 
            "ji", "ri", "ki", "zus", "me", "ta", "rin", "to", "mo", "no", "ke", 
            "shi", "ari", "chi", "ha", "ru", "mei", "na", "fu", "zi"};

    public static String ninjafy(String name) {
        String ninjyName = "";
        
        if (name.length() == 0)
        {
        	return ninjyName;
        }
        
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
    	
    	if (hog == null)
    	{
    		return "None";
    	}
    	
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
