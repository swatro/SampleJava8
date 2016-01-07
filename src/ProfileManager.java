import java.util.ArrayList;
import java.util.List;

public class ProfileManager {
    private List<Profile> profiles;

    public ProfileManager(List<Profile> profiles) {
        this.profiles = profiles;
    }

    public List<Profile> getAllJohns() {
        List<Profile> johns = new ArrayList<>();
        for (Profile profile : profiles){
            if (profile.getFirstName().equals("John")){
                johns.add(profile);
            }
        }
        return johns;
    }
}
