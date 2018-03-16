package byui.cit260.oregontrailredux.model;

import byui.cit260.oregontrailredux.model.enums.OxPosition;

import java.io.Serializable;
import java.util.Arrays;

public final class Oxen implements Serializable {

    private final Ox[] oxen;

    public Oxen() {
        this.oxen = new Ox[]{new Ox(), new Ox()};
    }

    public Oxen(final Ox left, final Ox right) {
        this.oxen = new Ox[]{left, right};
    }

    public Ox get(final OxPosition type) {
        return this.oxen[type.position];
    }

    public Ox[] getOxen() {
        return this.oxen;
    }

    public void set(final OxPosition type, final Ox ox) {
        this.oxen[type.position] = ox;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Arrays.deepHashCode(this.oxen);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Oxen other = (Oxen) obj;
        return Arrays.deepEquals(this.oxen, other.oxen);
    }

    @Override
    public String toString() {
        return "Oxen{" + "oxen=" + Arrays.toString(oxen) + '}';
    }

}
