package byui.cit260.oregontrailredux.model;

import byui.cit260.oregontrailredux.model.enums.LocationType;
import java.io.Serializable;
import java.util.Objects;

public final class Location implements Serializable {

    private LocationType type;

    public Location() {
        this.type = LocationType.NOWHERE;
    }

    public LocationType getType() {
        return type;
    }

    public void setType(LocationType type) {
        this.type = type;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.type);
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
        return this.type == other.type;
    }

    @Override
    public String toString() {
        return "Location{" + "type=" + type + '}';
    }
}
