package byui.cit260.oregontrailredux.model;

import java.util.ArrayList;
import java.util.Objects;

public final class Companions {

    private ArrayList<Person> members;

    public Companions() {
        this.members = new ArrayList<>();
    }

    public ArrayList<Person> getMembers() {
        return members;
    }

    public void setMembers(ArrayList<Person> members) {
        this.members = members;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.members);
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
        final Companions other = (Companions) obj;
        return Objects.equals(this.members, other.members);
    }

    @Override
    public String toString() {
        return "Companions{" + "members=" + members + '}';
    }
}
