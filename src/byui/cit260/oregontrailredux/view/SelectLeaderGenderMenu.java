package byui.cit260.oregontrailredux.view;

import byui.cit260.oregontrailredux.control.GameController;
import byui.cit260.oregontrailredux.control.ViewController;
import byui.cit260.oregontrailredux.model.enums.Gender;
import byui.cit260.oregontrailredux.view.io.Output;
import java.util.stream.Stream;

/**
 *
 * @author Connor
 */
public final class SelectLeaderGenderMenu extends AbstractMenu implements ViewInterface {

    /**
     * The default constructor.
     */
    public SelectLeaderGenderMenu() {
        this.title = "Select gender";
        
        Stream.of(Gender.values()).skip(1).forEach((Gender gender) -> {
            this.addOption(gender.symbol, gender.descriptor, () -> {
                new GameController().getResource().getTeam().getLeader()
                        .setGender(gender);
                Output.println("The team leader is now "
                        + gender.descriptor.toLowerCase() + ".");
                ViewController.quitCurrentView();
            });
        });
    }
}
