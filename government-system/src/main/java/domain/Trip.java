package domain;

import java.util.HashSet;

public class Trip {
    private HashSet<Location> locations;

    public Trip(HashSet<Location> locations) {
        this.locations = locations;
    }

    public HashSet<Location> getLocations() {
        return locations;
    }

    public void setLocations(HashSet<Location> locations) {
        this.locations = locations;
    }
}
