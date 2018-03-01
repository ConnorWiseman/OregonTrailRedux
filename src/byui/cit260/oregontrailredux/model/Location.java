package byui.cit260.oregontrailredux.model;

import java.io.Serializable;
import java.util.Objects;

public final class Location implements Serializable {
    private String name;
    private String description;
    private int    distance;
    
    public Location() {
        this.name        = "Unnamed Location";
        this.description = "No description";
        this.distance    = 0;
    }
    
    public Location(final String name, final String description,
            final int distance) {
        this.name        = name;
        this.description = description;
        this.distance    = distance;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(final int distance) {
        this.distance = distance;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.name);
        hash = 71 * hash + Objects.hashCode(this.description);
        hash = 71 * hash + this.distance;
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
        final Location other = (Location) obj;
        if (this.distance != other.distance) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Location{" + "name=" + name + ", description=" + description + ", distance=" + distance + '}';
    }
    
    
}
