package Java8;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

public class ProfileManager {
    private List<Profile> profiles;

    public ProfileManager(List<Profile> profiles) {
        this.profiles = profiles;
    }

    public List<Profile> getAllJohns() {
        return profiles
                .stream()
                .filter(profileWithOptional -> profileWithOptional.getFirstName().equals("John"))
                .collect(Collectors.<Profile>toList());
    }

    public List<Profile> sortByLastName() {
        return profiles
                .stream()
                .sorted((p1, p2) -> p1.getLastName().compareToIgnoreCase(p2.getLastName()))
                .collect(toList());
    }

    public boolean doAllProfilesHaveFavoriteFlavors() {
        return profiles
                .stream()
                .allMatch(profile -> profile.getFavoriteIceCreamFlavors().isPresent());
    }

    public Map<Integer, List<Profile>> getAgesToProfiles() {
        return profiles
                .stream()
                .collect(groupingBy(Profile::getAge));
    }
}
