import org.junit.Test;

import java.util.Optional;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ProfileTest {

    @Test
    public void shouldNotHaveAFavoriteFlavorOfIceCream() throws Exception {
        Profile profile = new Profile("Stacey", "Awesome", null);

        assertThat(profile.printFavoriteFlavor(), is("I do not have a favorite ice cream flavor."));
    }

    @Test
    public void shouldHaveAFavoriteIceCreamFlavor() throws Exception {
        Profile profile = new Profile("Stacey", "Awesome", "Chunky Chocolate Pudding");

        assertThat(profile.printFavoriteFlavor(), is("Chunky Chocolate Pudding"));
    }

    @Test
    public void shouldNotHaveAFavoriteFlavorOfIceCreamWithOptional() throws Exception {
        ProfileWithOptional profile = new ProfileWithOptional("Stacey", "Awesome", Optional.empty());

        assertThat(profile.printFavoriteFlavor(), is("I do not have a favorite ice cream flavor."));
    }

    @Test
    public void shouldHaveAFavoriteIceCreamFlavorWithOptional() throws Exception {
        ProfileWithOptional profile = new ProfileWithOptional("Stacey", "Awesome", Optional.of("Chunky Chocolate Pudding"));

        assertThat(profile.printFavoriteFlavor(), is("Chunky Chocolate Pudding"));
    }


}