import java.util.Optional;

public class ProfileWithOptional {

    private String firstName;
    private String lastName;
    private Optional<String> favoriteIceCreamFlavor;

    public ProfileWithOptional(String firstName, String lastName, Optional<String> favoriteIceCreamFlavor) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.favoriteIceCreamFlavor = favoriteIceCreamFlavor;
    }

    public String printFavoriteFlavor() {
        return favoriteIceCreamFlavor.orElse("I do not have a favorite ice cream flavor.");
    }

}
