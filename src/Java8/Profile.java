package Java8;

import java.util.Optional;

public class Profile {

    private String firstName;
    private String lastName;
    private Optional<String> favoriteIceCreamFlavors;

    public Profile(String firstName, String lastName, Optional<String> favoriteIceCreamFlavor) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.favoriteIceCreamFlavors = favoriteIceCreamFlavor;
    }

    public String printFavoriteFlavor() {
        return favoriteIceCreamFlavors.orElseGet(() -> "I do not have a favorite ice cream flavor.");
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Optional<String> getFavoriteIceCreamFlavors() {
        return favoriteIceCreamFlavors;
    }
}
