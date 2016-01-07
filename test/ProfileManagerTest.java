import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ProfileManagerTest {

    @Test
    public void shouldFindAllProfilesWithFirstNamesJohn() throws Exception {
        Profile johnProfile = new Profile("John", "Awesome", null);

        List<Profile> profiles = new ArrayList<>();
        profiles.add(new Profile("Stacey", "Awesome", null));
        profiles.add(johnProfile);
        profiles.add(new Profile("Stacey", "John", null));

        ProfileManager profileManager = new ProfileManager(profiles);
        assertThat(profileManager.getAllJohns().get(0), is(johnProfile));
    }

    @Test
    public void shouldFindAllProfilesWithFirstNamesJohnWithJava8() throws Exception {
        ProfileWithOptional johnProfile = new ProfileWithOptional("John", "Awesome", null);

        List<ProfileWithOptional> profiles = new ArrayList<>();
        profiles.add(new ProfileWithOptional("Stacey", "Awesome", null));
        profiles.add(johnProfile);
        profiles.add(new ProfileWithOptional("Stacey", "John", null));

        ProfileManagerWithJava8 profileManager = new ProfileManagerWithJava8(profiles);
        assertThat(profileManager.getAllJohns().get(0), is(johnProfile));
    }
}