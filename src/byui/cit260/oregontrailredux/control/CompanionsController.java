package byui.cit260.oregontrailredux.control;

import byui.cit260.oregontrailredux.model.Companions;
import byui.cit260.oregontrailredux.model.Person;
import java.util.ArrayList;
import java.util.Iterator;

public class CompanionsController implements ControllerInterface {
    private final Companions companions;
    
    public CompanionsController() {
        this.companions = new Companions();
    }
    
    public CompanionsController(final Companions companions) {
        this.companions = companions;
    }
    
    public void add(final String name, final int age) {
        PersonController pc = new PersonController();
        pc.setHuntingSkill(3, 5);
        pc.setGatheringSkill(3, 5);

        Person companion = pc.getResource();
        companion.setName(name);
        companion.setAge(age);

        this.companions.getMembers().add(companion);
    }
    
    @Override
    public Object create() {
        return new Companions();
    }
    
    @Override
    public Companions getResource() {
        return this.companions;
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
