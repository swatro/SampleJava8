package Java8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by swatro on 1/6/16.
 */
public class ProfileManagerTest {

    @Test
    public void shouldFindAllProfilesWithFirstNamesJohnWithJava8() throws Exception {
        Profile johnProfile = new Profile("John", "Awesome", null);

        List<Profile> profiles = new ArrayList<>();
        profiles.add(new Profile("Stacey", "Awesome", null));
        profiles.add(johnProfile);
        profiles.add(new Profile("Stacey", "John", null));

        ProfileManager profileManager = new ProfileManager(profiles);
        assertThat(profileManager.getAllJohns().get(0), is(johnProfile));
    }
}
