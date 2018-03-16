package byui.cit260.oregontrailredux.model;

import java.io.Serializable;

import byui.cit260.oregontrailredux.model.enums.Pace;
import java.util.Objects;

public final class Team implements Serializable {

    private Person leader;
    private Companions companions;
    private Pace pace;
    private Oxen oxen;
    private Wagon wagon;
    private int money;

    public Team() {
        this.leader = new Person();
        this.companions = new Companions();
        this.pace = Pace.STOPPED;
        this.money = 0;
    }

    public Person getLeader() {
        return leader;
    }

    public void setLeader(final Person leader) {
        this.leader = leader;
    }

    public Companions getCompanions() {
        return companions;
    }

    public void setCompanions(final Companions companions) {
        this.companions = companions;
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
        hash = 47 * hash + Objects.hashCode(this.leader);
        hash = 47 * hash + Objects.hashCode(this.companions);
        hash = 47 * hash + Objects.hashCode(this.pace);
        hash = 47 * hash + Objects.hashCode(this.oxen);
        hash = 47 * hash + Objects.hashCode(this.wagon);
        hash = 47 * hash + this.money;
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
        final Team other = (Team) obj;
        if (this.money != other.money) {
            return false;
        }
        if (!Objects.equals(this.leader, other.leader)) {
            return false;
        }
        if (!Objects.equals(this.companions, other.companions)) {
            return false;
        }
        if (this.pace != other.pace) {
            return false;
        }
        if (!Objects.equals(this.oxen, other.oxen)) {
            return false;
        }
        return Objects.equals(this.wagon, other.wagon);
    }

    @Override
    public String toString() {
        return "Team{leader=" + leader + ", companions=" + companions + ", pace=" + pace + ", oxen=" + oxen + ", wagon=" + wagon + ", money=" + money + '}';
    }

}
