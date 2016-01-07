package Java;

import java.util.List;

public class Profile {

    private String firstName;
    private String lastName;
    private List<String> favoriteIceCreamFlavor;

    public Profile(String firstName, String lastName, List<String> favoriteIceCreamFlavor) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.favoriteIceCreamFlavor = favoriteIceCreamFlavor;
    }

    public String printAllFavoriteIceCreamFlavors(){
        if (favoriteIceCreamFlavor !=null && favoriteIceCreamFlavor.size() > 0){
            String flavors = "";
            for (String flavor : favoriteIceCreamFlavor){
                flavors+= flavor + " ";
            }
            return flavors.trim();
        }
        return "I do not have a favorite ice cream flavor.";
    }

    public String getFirstName() {
        return firstName;
    }
}


