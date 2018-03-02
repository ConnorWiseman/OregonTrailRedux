package byui.cit260.oregontrailredux.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

/**
 * An ArrayList of Locations.
 *
 * @author Connor
 */
public final class Map implements Serializable {

    private ArrayList<Location> contents;
    private int currentLocation;

    /**
     * The default constructor. Initializes the Map contents and the
     * currentLocation of the user.
     */
    public Map() {
        this.contents = new ArrayList<>();
        this.currentLocation = 0;
    }

    /**
     *
     * @return
     */
    public ArrayList<Location> getContents() {
        return contents;
    }

    /**
     *
     * @param contents
     */
    public void setContents(ArrayList<Location> contents) {
        this.contents = contents;
    }

    /**
     *
     * @return
     */
    public int getCurrentLocation() {
        return currentLocation;
    }

    /**
     *
     * @param currentLocation
     */
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
