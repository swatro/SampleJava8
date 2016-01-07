package Java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

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
    public void shouldSortProfilesByLastNames() throws Exception {

        List<Profile> profiles = new ArrayList<>();
        profiles.add(new Profile("Stacey", "Awesome", null));
        profiles.add(new Profile("John", "Apple", null));
        profiles.add(new Profile("Stacey", "John", null));

        ProfileManager profileManager = new ProfileManager(profiles);
        List<Profile> sortedProfiles = profileManager.sortByLastName();

        assertThat(sortedProfiles.get(0).getLastName(), is("Apple"));
        assertThat(sortedProfiles.get(1).getLastName(), is("Awesome"));
        assertThat(sortedProfiles.get(2).getLastName(), is("John"));
    }

    @Test
    public void shouldFindThatThereAreProfilesWithoutFavoriteFlavors() throws Exception {
        List<Profile> profiles = new ArrayList<>();
        profiles.add(new Profile("Stacey", "Awesome", null));
        profiles.add(new Profile("John", "Apple", "Coconut"));
        profiles.add(new Profile("Stacey", "John", null));

        ProfileManager profileManager = new ProfileManager(profiles);

        assertThat(profileManager.doAllProfilesHaveFavoriteFlavors(), is(false));
    }

    @Test
    public void shouldFindThatThereAreNoProfilesWithoutFavoriteFlavors() throws Exception {
        List<Profile> profiles = new ArrayList<>();
        profiles.add(new Profile("Stacey", "Awesome", "Chocolate"));
        profiles.add(new Profile("John", "Apple", "Coconut"));
        profiles.add(new Profile("Stacey", "John", "Vanilla"));

        ProfileManager profileManager = new ProfileManager(profiles);

        assertThat(profileManager.doAllProfilesHaveFavoriteFlavors(), is(true));
    }
}