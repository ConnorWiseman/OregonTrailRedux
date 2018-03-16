package byui.cit260.oregontrailredux.control;

import byui.cit260.oregontrailredux.model.Companions;
import byui.cit260.oregontrailredux.model.Person;
import java.util.ArrayList;
import java.util.Iterator;

public class CompanionsControl {
    public static void add(final String name, final int age) {
        int lower = PersonControl.skillBoundary(3);
        int upper = PersonControl.skillBoundary(5);
        Person companion = PersonControl.create(name, age, lower, upper);
        CompanionsControl.get().getMembers().add(companion);
    }
    
    public static Companions get() {
        return GameControl.getCurrentGame().getTeam().getCompanions();
    }
    
    public static void removeDead(Companions people) {
        ArrayList<Person> members = people.getMembers();
        Iterator<Person> iter = members.iterator();
        
        while (iter.hasNext()) {
            Person p = iter.next();
            if (!PersonControl.isAlive(p)) {
                members.remove(p);
            }
        }
    }
}
