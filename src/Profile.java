public class Profile {

    private String firstName;
    private String lastName;
    private String favoriteIceCreamFlavor;

    public Profile(String firstName, String lastName, String favoriteIceCreamFlavor) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.favoriteIceCreamFlavor = favoriteIceCreamFlavor;
    }

    public String printFavoriteFlavor(){
        if (favoriteIceCreamFlavor !=null){
            return favoriteIceCreamFlavor;
        }
        return "I do not have a favorite ice cream flavor.";
    }
}


