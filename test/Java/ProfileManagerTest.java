package Java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ProfileManagerTest {

    @Test
    public void shouldFindAllProfilesWithFirstNamesJohn() throws Exception {
        Profile johnProfile = new Profile("John", "Awesome", null, 20);

        List<Profile> profiles = new ArrayList<>();
        profiles.add(new Profile("Stacey", "Awesome", null, 20));
        profiles.add(johnProfile);
        profiles.add(new Profile("Stacey", "John", null, 20));

        ProfileManager profileManager = new ProfileManager(profiles);
        assertThat(profileManager.getAllJohns().get(0), is(johnProfile));
    }

    @Test
    public void shouldSortProfilesByLastNames() throws Exception {

        List<Profile> profiles = new ArrayList<>();
        profiles.add(new Profile("Stacey", "Awesome", null, 20));
        profiles.add(new Profile("John", "Apple", null, 20));
        profiles.add(new Profile("Stacey", "John", null, 20));

        ProfileManager profileManager = new ProfileManager(profiles);
        List<Profile> sortedProfiles = profileManager.sortByLastName();

        assertThat(sortedProfiles.get(0).getLastName(), is("Apple"));
        assertThat(sortedProfiles.get(1).getLastName(), is("Awesome"));
        assertThat(sortedProfiles.get(2).getLastName(), is("John"));
    }

    @Test
    public void shouldFindThatThereAreProfilesWithoutFavoriteFlavors() throws Exception {
        List<Profile> profiles = new ArrayList<>();
        profiles.add(new Profile("Stacey", "Awesome", null, 20));
        profiles.add(new Profile("John", "Apple", "Coconut", 20));
        profiles.add(new Profile("Stacey", "John", null, 20));

        ProfileManager profileManager = new ProfileManager(profiles);

        assertThat(profileManager.doAllProfilesHaveFavoriteFlavors(), is(false));
    }

    @Test
    public void shouldFindThatThereAreNoProfilesWithoutFavoriteFlavors() throws Exception {
        List<Profile> profiles = new ArrayList<>();
        profiles.add(new Profile("Stacey", "Awesome", "Chocolate", 20));
        profiles.add(new Profile("John", "Apple", "Coconut", 20));
        profiles.add(new Profile("Stacey", "John", "Vanilla", 20));

        ProfileManager profileManager = new ProfileManager(profiles);

        assertThat(profileManager.doAllProfilesHaveFavoriteFlavors(), is(true));
    }

    @Test
    public void shouldGetMapOfProfilesByAge() throws Exception {
        Profile stacey = new Profile("Stacey", "Awesome", "Chocolate", 15);
        Profile john = new Profile("John", "Apple", "Coconut", 20);
        Profile staceyJohn = new Profile("Stacey", "John", "Vanilla", 15);

        List<Profile> profiles = new ArrayList<>();
        profiles.add(stacey);
        profiles.add(john);
        profiles.add(staceyJohn);

        ProfileManager profileManager = new ProfileManager(profiles);

        assertThat(profileManager.getAgesToProfiles().get(15).get(0), is(stacey));
        assertThat(profileManager.getAgesToProfiles().get(15).get(1), is(staceyJohn));
        assertThat(profileManager.getAgesToProfiles().get(20).get(0), is(john));
    }
}