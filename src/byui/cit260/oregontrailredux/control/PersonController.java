package byui.cit260.oregontrailredux.control;

import byui.cit260.oregontrailredux.control.util.Random;
import byui.cit260.oregontrailredux.model.Person;

public final class PersonController {
    
    private final Person person;

    public PersonController(final Person person) {
        this.person = person;
    }
    
    public static Person create() {
        return new Person();
    }

    public boolean isAlive() {
        return this.person.getHealth() > 0;
    }
    
    /**
     *
     * @param lower
     * @param upper
     */
    public void setGatheringSkill(final int lower, final int upper) {
        final double modifier = GameController.getCurrentGame()
                .getDifficulty().modifier;
        final int l = (int) modifier * lower;
        final int u = (int) modifier * upper;
        
        this.person.setGatheringSkill(Random.range(l, u));
    }
    
    /**
     *
     * @param lower
     * @param upper
     */
    public void setHuntingSkill(final int lower, final int upper) {
        final double modifier = GameController.getCurrentGame()
                .getDifficulty().modifier;
        final int l = (int) modifier * lower;
        final int u = (int) modifier * upper;
        
        this.person.setHuntingSkill(Random.range(l, u));
    }
}
