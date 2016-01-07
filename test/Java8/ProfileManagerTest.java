package Java8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.Optional.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ProfileManagerTest {

    @Test
    public void shouldFindAllProfilesWithFirstNamesJohn() throws Exception {
        Profile johnProfile = new Profile("John", "Awesome", empty());

        List<Profile> profiles = new ArrayList<>();
        profiles.add(new Profile("Stacey", "Awesome", empty()));
        profiles.add(johnProfile);
        profiles.add(new Profile("Stacey", "John", empty()));

        ProfileManager profileManager = new ProfileManager(profiles);
        assertThat(profileManager.getAllJohns().get(0), is(johnProfile));
    }

    @Test
    public void shouldSortProfilesByLastNames() throws Exception {

        List<Profile> profiles = new ArrayList<>();
        profiles.add(new Profile("Stacey", "Awesome", empty()));
        profiles.add(new Profile("John", "Apple", empty()));
        profiles.add(new Profile("Stacey", "John", empty()));

        ProfileManager profileManager = new ProfileManager(profiles);
        List<Profile> sortedProfiles = profileManager.sortByLastName();

        assertThat(sortedProfiles.get(0).getLastName(), is("Apple"));
        assertThat(sortedProfiles.get(1).getLastName(), is("Awesome"));
        assertThat(sortedProfiles.get(2).getLastName(), is("John"));
    }

    @Test
    public void shouldFindThatThereAreProfilesWithoutFavoriteFlavors() throws Exception {
        List<Profile> profiles = new ArrayList<>();
        profiles.add(new Profile("Stacey", "Awesome", empty()));
        profiles.add(new Profile("John", "Apple", Optional.of("Coconut")));
        profiles.add(new Profile("Stacey", "John", empty()));

        ProfileManager profileManager = new ProfileManager(profiles);

        assertThat(profileManager.doAllProfilesHaveFavoriteFlavors(), is(false));
    }

    @Test
    public void shouldFindThatThereAllProfilesHaveFavoriteFlavors() throws Exception {
        List<Profile> profiles = new ArrayList<>();
        profiles.add(new Profile("Stacey", "Awesome", Optional.of("Chocolate")));
        profiles.add(new Profile("John", "Apple", Optional.of("Coconut")));
        profiles.add(new Profile("Stacey", "John", Optional.of("Strawberry")));

        ProfileManager profileManager = new ProfileManager(profiles);

        assertThat(profileManager.doAllProfilesHaveFavoriteFlavors(), is(true));
    }
}
