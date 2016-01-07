package Java8;

import java.util.List;
import java.util.stream.Collectors;

public class ProfileManager {
    private List<Profile> profiles;

    public ProfileManager(List<Profile> profiles) {
        this.profiles = profiles;
    }

    public List<Profile> getAllJohns() {
        return profiles.stream()
                .filter(profileWithOptional -> profileWithOptional.getFirstName().equals("John"))
                .collect(Collectors.<Profile>toList());
    }
}
