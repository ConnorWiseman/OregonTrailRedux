package byui.cit260.oregontrailredux.control;

import byui.cit260.oregontrailredux.control.util.Random;
import byui.cit260.oregontrailredux.model.Person;
import byui.cit260.oregontrailredux.model.enums.Profession;

public final class PersonControl {

    private PersonControl() {
    }
    
    public static int skillBoundary(final int n) {
        return (int) GameControl.getCurrentGame().getDifficulty().modifier * n;
    }
    
    public static Person create(final String name, final int age) {
        int lower = PersonControl.skillBoundary(5);
        int upper = PersonControl.skillBoundary(8);
        return PersonControl.create(name, age, lower, upper);
    }
    
    public static Person create(final String name, final int age,
            final int lower, final int upper) {
        Person person = new Person();
        person.setName(name);
        person.setAge(age);
        person.setHuntingSkill(Random.range(lower, upper));
        person.setGatheringSkill(Random.range(lower, upper));
        return person;
    }

    public static boolean isAlive(Person person) {
        return person.getHealth() > 0;
    }
    
    public static void setProfession(Person person, Profession profession) {
        person.setProfession(profession);
    }
}
