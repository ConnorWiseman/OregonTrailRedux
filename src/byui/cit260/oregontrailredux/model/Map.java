package byui.cit260.oregontrailredux.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public final class Map implements Serializable {
    private ArrayList<Location> contents;
    private int                 currentLocation;
    
    public Map() {
        this.contents        = new ArrayList<>();
        this.currentLocation = 0;
    }
    
    public Map(final ArrayList<Location> contents, final int currentLocation) {
        this.contents        = contents;
        this.currentLocation = currentLocation;
    }

    public ArrayList<Location> getContents() {
        return contents;
    }

    public void setContents(final ArrayList<Location> contents) {
        this.contents = contents;
    }

    public int getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(final int currentLocation) {
        this.currentLocation = currentLocation;
    }

    @Override
    public String toString() {
        return "Map{" + "contents=" + contents + ", currentLocation=" + currentLocation + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.contents);
        hash = 83 * hash + this.currentLocation;
        return hash;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Map other = (Map) obj;
        if (this.currentLocation != other.currentLocation) {
            return false;
        }
        if (!Objects.equals(this.contents, other.contents)) {
            return false;
        }
        return true;
    }

}
