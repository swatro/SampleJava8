package Java;

public class Profile {

    private String firstName;
    private String lastName;
    private String favoriteIceCreamFlavor;

    public Profile(String firstName, String lastName, String favoriteIceCreamFlavor) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.favoriteIceCreamFlavor = favoriteIceCreamFlavor;
    }

    public String printAllFavoriteIceCreamFlavors(){
        if (favoriteIceCreamFlavor !=null){
            return favoriteIceCreamFlavor;
        }
        return "I do not have a favorite ice cream flavor.";
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFavoriteIceCreamFlavor() {
        return favoriteIceCreamFlavor;
    }
}


