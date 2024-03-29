package byui.cit260.oregontrailredux.model;

import java.io.Serializable;
import java.util.Objects;

public final class Player implements Serializable {

    private String name;

    public Player() {
        this.name = "Unnamed Player";
    }

    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.name);
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
        final Player other = (Player) obj;
        return Objects.equals(this.name, other.name);
    }

    @Override
    public String toString() {
        return "Player{" + "name=" + name + '}';
    }
}
