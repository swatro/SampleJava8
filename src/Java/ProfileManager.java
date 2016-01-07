package Java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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

    public List<Profile> sortByLastName() {
        List<Profile> sortProfiles = profiles;

        Collections.sort(sortProfiles, new Comparator<Profile>() {
            @Override
            public int compare(Profile firstProfile, Profile secondProfile) {
                return firstProfile.getLastName().compareToIgnoreCase(secondProfile.getLastName());
            }
        });

        return sortProfiles;
    }
}
