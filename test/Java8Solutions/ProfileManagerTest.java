package Java8Solutions;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.util.Optional.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ProfileManagerTest {

    @Test
    public void shouldFindAllProfilesWithFirstNameJohn() throws Exception {
        Profile johnProfile = new Profile("John", "Awesome", empty(), 20);

        List<Profile> profiles = new ArrayList<>();
        profiles.add(new Profile("Stacey", "Awesome", empty(), 20));
        profiles.add(johnProfile);
        profiles.add(new Profile("Stacey", "John", empty(), 20));

        ProfileManager profileManager = new ProfileManager(profiles);
        assertThat(profileManager.getAllJohns().get(0), is(johnProfile));
    }

    @Test
    public void shouldSortProfilesByLastName() throws Exception {

        List<Profile> profiles = new ArrayList<>();
        profiles.add(new Profile("Stacey", "Awesome", empty(), 20));
        profiles.add(new Profile("John", "Apple", empty(), 20));
        profiles.add(new Profile("Stacey", "John", empty(), 20));

        ProfileManager profileManager = new ProfileManager(profiles);
        List<Profile> sortedProfiles = profileManager.sortByLastName();

        assertThat(sortedProfiles.get(0).getLastName(), is("Apple"));
        assertThat(sortedProfiles.get(1).getLastName(), is("Awesome"));
        assertThat(sortedProfiles.get(2).getLastName(), is("John"));
    }

    @Test
    public void shouldFindThatThereAreProfilesWithoutFavoriteFlavors() throws Exception {
        List<Profile> profiles = new ArrayList<>();
        profiles.add(new Profile("Stacey", "Awesome", empty(), 20));
        profiles.add(new Profile("John", "Apple", Optional.of("Coconut"), 20));
        profiles.add(new Profile("Stacey", "John", empty(), 20));

        ProfileManager profileManager = new ProfileManager(profiles);

        assertThat(profileManager.doAllProfilesHaveFavoriteFlavors(), is(false));
    }

    @Test
    public void shouldFindThatAllProfilesHaveFavoriteFlavors() throws Exception {
        List<Profile> profiles = new ArrayList<>();
        profiles.add(new Profile("Stacey", "Awesome", Optional.of("Chocolate"), 20));
        profiles.add(new Profile("John", "Apple", Optional.of("Coconut"), 20));
        profiles.add(new Profile("Stacey", "John", Optional.of("Strawberry"), 20));

        ProfileManager profileManager = new ProfileManager(profiles);

        assertThat(profileManager.doAllProfilesHaveFavoriteFlavors(), is(true));
    }

    @Test
    public void shouldGetMapOfProfilesByAge() throws Exception {
        Profile stacey = new Profile("Stacey", "Awesome", Optional.of("Chocolate"), 15);
        Profile john = new Profile("John", "Apple", empty(), 20);
        Profile staceyJohn = new Profile("Stacey", "John", empty(), 15);

        List<Profile> profiles = new ArrayList<>();
        profiles.add(stacey);
        profiles.add(john);
        profiles.add(staceyJohn);

        ProfileManager profileManager = new ProfileManager(profiles);

        Map<Integer, List<Profile>> agesToProfiles = profileManager.getAgesToProfiles();
        assertThat(agesToProfiles.get(15).get(0), is(stacey));
        assertThat(agesToProfiles.get(15).get(1), is(staceyJohn));
        assertThat(agesToProfiles.get(20).get(0), is(john));
    }

    @Test
    public void shouldFindTheSumOfAllAgesIs50() throws Exception {

        List<Profile> profiles = new ArrayList<>();
        profiles.add(new Profile("Stacey", "Awesome", empty(), 15));
        profiles.add(new Profile("John", "Apple", empty(), 20));
        profiles.add(new Profile("Stacey", "John", empty(), 15));

        ProfileManager profileManager = new ProfileManager(profiles);

        assertThat(profileManager.getTotalAges(), is(50));
    }
}
