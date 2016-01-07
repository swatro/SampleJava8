package Java8Solutions;

import java.util.Optional;

public class Profile {

    private String firstName;
    private String lastName;
    private Optional<String> favoriteIceCreamFlavors;
    private int age;

    public Profile(String firstName, String lastName, Optional<String> favoriteIceCreamFlavor, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.favoriteIceCreamFlavors = favoriteIceCreamFlavor;
        this.age = age;
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

    public int getAge() {
        return age;
    }
}
