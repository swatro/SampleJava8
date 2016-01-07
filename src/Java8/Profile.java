package Java8;

import java.util.Optional;

public class Profile {
    private String firstName;
    private String lastName;
    private final Optional<Object> favoriteIceCreamFlavor;
    private final int age;

    public Profile(String firstName, String LastName, Optional<Object> favoriteIceCreamFlavor, int age) {

        this.firstName = firstName;
        lastName = LastName;
        this.favoriteIceCreamFlavor = favoriteIceCreamFlavor;
        this.age = age;
    }

    public String printFavoriteFlavor() {
        return null;
    }

    public String getLastName() {
        return null;
    }

    public String getFirstName() {
        return firstName;
    }

    public Optional<Object> getFavoriteIceCreamFlavor() {
        return favoriteIceCreamFlavor;
    }

    public int getAge() {
        return age;
    }
}
