package Java;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ProfileTest {

    @Test
    public void shouldNotHaveAFavoriteFlavorOfIceCream() throws Exception {
        Profile profile = new Profile("Stacey", "Awesome", null, 20);

        assertThat(profile.printAllFavoriteIceCreamFlavors(), is("I do not have a favorite ice cream flavor."));
    }

    @Test
    public void shouldHaveAListOfFavoriteIceCreamFlavors() throws Exception {
        Profile profile = new Profile("Stacey", "Awesome", "Chunky Chocolate Pudding", 20);

        assertThat(profile.printAllFavoriteIceCreamFlavors(), is("Chunky Chocolate Pudding"));
    }
}