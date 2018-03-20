package byui.cit260.oregontrailredux.model;

import java.io.Serializable;
import java.util.Objects;

public final class Ox implements Serializable {

    private String name;
    private int strength;
    private int exhaustion;
    private boolean alive;

    public Ox() {
        this.name = "Unnamed Ox";
        this.strength = 0;
        this.exhaustion = 0;
        this.alive = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getExhaustion() {
        return exhaustion;
    }

    public void setExhaustion(int exhaustion) {
        this.exhaustion = exhaustion;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(final boolean alive) {
        this.alive = alive;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.name);
        hash = 37 * hash + this.strength;
        hash = 37 * hash + this.exhaustion;
        hash = 37 * hash + (this.alive ? 1 : 0);
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
        final Ox other = (Ox) obj;
        if (this.strength != other.strength) {
            return false;
        }
        if (this.exhaustion != other.exhaustion) {
            return false;
        }
        if (this.alive != other.alive) {
            return false;
        }
        return Objects.equals(this.name, other.name);
    }

    @Override
    public String toString() {
        return "Ox{" + "name=" + name + ", strength=" + strength + ", exhaustion=" + exhaustion + ", alive=" + alive + '}';
    }
}
