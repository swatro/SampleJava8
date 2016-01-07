package Java8;

import org.junit.Test;

import java.util.Optional;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ProfileTest {

    @Test
    public void shouldNotHaveAFavoriteFlavorOfIceCreamWithOptional() throws Exception {
        Profile profile = new Profile("Stacey", "Awesome", Optional.empty(), 20);

        assertThat(profile.printFavoriteFlavor(), is("I do not have a favorite ice cream flavor."));
    }

    @Test
    public void shouldHaveAFavoriteIceCreamFlavorWithOptional() throws Exception {
        Profile profile = new Profile("Stacey", "Awesome", Optional.of("Chunky Chocolate Pudding"), 20);

        assertThat(profile.printFavoriteFlavor(), is("Chunky Chocolate Pudding"));
    }

}
