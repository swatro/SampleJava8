package Java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ProfileTest {

    @Test
    public void shouldNotHaveAFavoriteFlavorOfIceCream() throws Exception {
        Profile profile = new Profile("Stacey", "Awesome", null);

        assertThat(profile.printAllFavoriteIceCreamFlavors(), is("I do not have a favorite ice cream flavor."));
    }

    @Test
    public void shouldHaveAListOfFavoriteIceCreamFlavors() throws Exception {
        List<String> flavors = new ArrayList();
        flavors.add("Chocolate");
        flavors.add("Vanilla");
        Profile profile = new Profile("Stacey", "Awesome", flavors);

        assertThat(profile.printAllFavoriteIceCreamFlavors(), is("Chocolate Vanilla"));
    }
}