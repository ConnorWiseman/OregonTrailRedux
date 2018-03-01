package byui.cit260.oregontrailredux.model;

import java.io.Serializable;

import byui.cit260.oregontrailredux.enums.Pace;
import java.util.Objects;

public final class Team implements Serializable {
    private Pace  pace;
    private Oxen  oxen;
    private Wagon wagon;
    private int   money;
    
    public Team() {
        this.pace  = Pace.STOPPED;
        this.money = 0;
    }
    
    public Pace getPace() {
        return pace;
    }

    public void setPace(final Pace pace) {
        this.pace = pace;
    }

    public Oxen getOxen() {
        return oxen;
    }

    public void setOxen(final Oxen oxen) {
        this.oxen = oxen;
    }

    public Wagon getWagon() {
        return wagon;
    }

    public void setWagon(final Wagon wagon) {
        this.wagon = wagon;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.pace);
        hash = 53 * hash + Objects.hashCode(this.oxen);
        hash = 53 * hash + Objects.hashCode(this.wagon);
        hash = 53 * hash + this.money;
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
        final Team other = (Team) obj;
        if (this.money != other.money) {
            return false;
        }
        if (this.pace != other.pace) {
            return false;
        }
        if (!Objects.equals(this.oxen, other.oxen)) {
            return false;
        }
        if (!Objects.equals(this.wagon, other.wagon)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Team{" + "pace=" + pace + ", oxen=" + oxen + ", wagon=" + wagon + ", money=" + money + '}';
    }
}
