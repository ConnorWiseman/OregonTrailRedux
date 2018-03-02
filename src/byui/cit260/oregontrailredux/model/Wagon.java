package byui.cit260.oregontrailredux.model;

import java.io.Serializable;
import java.util.Objects;

public final class Wagon implements Serializable {

    private Inventory cargo;
    private int ownWeight;
    private int maxWeight;

    public Wagon() {
        this.ownWeight = 0;
        this.maxWeight = 0;
    }

    public Inventory getCargo() {
        return cargo;
    }

    public void setCargo(final Inventory cargo) {
        this.cargo = cargo;
    }

    public int getOwnWeight() {
        return ownWeight;
    }

    public void setOwnWeight(final int ownWeight) {
        this.ownWeight = ownWeight;
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(final int maxWeight) {
        this.maxWeight = maxWeight;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.cargo);
        hash = 23 * hash + this.ownWeight;
        hash = 23 * hash + this.maxWeight;
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
        final Wagon other = (Wagon) obj;
        if (this.ownWeight != other.ownWeight) {
            return false;
        }
        if (this.maxWeight != other.maxWeight) {
            return false;
        }
        if (!Objects.equals(this.cargo, other.cargo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Wagon{" + "cargo=" + cargo + ", ownWeight=" + ownWeight + ", maxWeight=" + maxWeight + '}';
    }
}
