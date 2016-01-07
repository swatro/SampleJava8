package Java8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ProfileTest {

    @Test
    public void shouldNotHaveAFavoriteFlavorOfIceCreamWithOptional() throws Exception {
        Profile profile = new Profile("Stacey", "Awesome", Optional.empty());

        assertThat(profile.printFavoriteFlavor(), is("I do not have a favorite ice cream flavor."));
    }

    @Test
    public void shouldHaveAFavoriteIceCreamFlavorWithOptional() throws Exception {
        List<String> flavors = new ArrayList<>();
        flavors.add("Chocolate");
        flavors.add("Vanilla");
        Optional<List<String>> favoriteIceCreamFlavor = Optional.of(flavors);
        Profile profile = new Profile("Stacey", "Awesome", favoriteIceCreamFlavor);

        assertThat(profile.printFavoriteFlavor(), is("Chocolate Vanilla"));
    }

}
