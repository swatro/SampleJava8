import java.util.List;
import java.util.stream.Collectors;

public class ProfileManagerWithJava8 {
    private List<ProfileWithOptional> profiles;

    public ProfileManagerWithJava8(List<ProfileWithOptional> profiles) {
        this.profiles = profiles;
    }

    public List<ProfileWithOptional> getAllJohns() {
        return profiles.stream()
                .filter(profileWithOptional -> profileWithOptional.getFirstName().equals("John"))
                .collect(Collectors.<ProfileWithOptional>toList());
    }
}
