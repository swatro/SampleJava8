import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ProfileWithOptional {

    private String firstName;
    private String lastName;
    private Optional<List<String>> favoriteIceCreamFlavors;

    public ProfileWithOptional(String firstName, String lastName, Optional<List<String>> favoriteIceCreamFlavor) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.favoriteIceCreamFlavors = favoriteIceCreamFlavor;
    }

    public String printFavoriteFlavor() {
        if (!favoriteIceCreamFlavors.isPresent()) return "I do not have a favorite ice cream flavor.";

        return favoriteIceCreamFlavors.get().stream().collect(Collectors.joining(" "));
    }

    public String getFirstName() {
        return firstName;
    }
}
