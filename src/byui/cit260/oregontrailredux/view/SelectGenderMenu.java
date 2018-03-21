package byui.cit260.oregontrailredux.view;

import byui.cit260.oregontrailredux.control.GameController;
import byui.cit260.oregontrailredux.control.ViewController;
import byui.cit260.oregontrailredux.model.Person;
import byui.cit260.oregontrailredux.model.enums.Gender;
import byui.cit260.oregontrailredux.view.io.Output;
import java.util.stream.Stream;

/**
 *
 * @author Connor
 */
public final class SelectGenderMenu extends AbstractMenu implements ViewInterface {

    /**
     * The default constructor.
     * 
     * @param person
     */
    public SelectGenderMenu(final Person person) {
        this.title = "Select gender";
        
        Stream.of(Gender.values()).skip(1).forEach((Gender gender) -> {
            this.addOption(gender.symbol, gender.descriptor, () -> {
                person.setGender(gender);
                Output.println("The " + person.getType().label + " is now "
                        + gender.descriptor.toLowerCase() + ".");
                ViewController.getInstance().quitCurrentView();
            });
        });
    }
}
