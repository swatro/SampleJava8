package Java;

public class Profile {

    private String firstName;
    private String lastName;
    private String favoriteIceCreamFlavor;
    private int age;

    public Profile(String firstName, String lastName, String favoriteIceCreamFlavor, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.favoriteIceCreamFlavor = favoriteIceCreamFlavor;
        this.age = age;
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

    public int getAge() {
        return age;
    }
}


