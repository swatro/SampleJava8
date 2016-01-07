package Java;

import java.util.*;

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

    public boolean doAllProfilesHaveFavoriteFlavors() {
        for(Profile profile : profiles){
            if (profile.getFavoriteIceCreamFlavor() == null){
                return false;
            }
        }

        return true;
    }

    public Map<Integer, List<Profile>> getAgesToProfiles() {
        Map<Integer, List<Profile>> map = new HashMap<>();
        for (Profile profile : profiles){
            int age = profile.getAge();
            if (map.containsKey(age)) {
                map.get(age).add(profile);
            }
            else {
                List<Profile> ageCommonProfiles = new ArrayList<>();
                ageCommonProfiles.add(profile);
                map.put(age, ageCommonProfiles);
            }
        }

        return map;
    }

    public int getTotalAges() {
        int total = 0;
        for (Profile profile : profiles){
            total += profile.getAge();
        }
        return total;
    }
}
