package byui.cit260.oregontrailredux.control;

import byui.cit260.oregontrailredux.model.Companions;
import byui.cit260.oregontrailredux.model.Person;
import java.util.ArrayList;
import java.util.Iterator;

public class CompanionsController {
    private final Companions companions;
    
    public CompanionsController(final Companions companions) {
        this.companions = companions;
    }
    
    public static Companions create() {
        return new Companions();
    }
    
    public void add(final String name, final int age) {
        Person companion = PersonController.create();
        
        PersonController pc = new PersonController(companion);
        pc.setHuntingSkill(3, 5);
        pc.setGatheringSkill(3, 5);

        companion.setName(name);
        companion.setAge(age);

        this.companions.getMembers().add(companion);
    }
    
    public void removeDead() {
        final ArrayList<Person> members = this.companions.getMembers();
        final Iterator<Person> iter = members.iterator();
        
        while (iter.hasNext()) {
            final Person p = iter.next();
            final PersonController pc = new PersonController(p);
            if (!pc.isAlive()) {
                members.remove(p);
            }
        }
    }
}
