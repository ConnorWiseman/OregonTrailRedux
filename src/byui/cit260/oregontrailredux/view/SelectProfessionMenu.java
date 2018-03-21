package byui.cit260.oregontrailredux.view;

import byui.cit260.oregontrailredux.control.GameController;
import byui.cit260.oregontrailredux.control.TeamController;
import byui.cit260.oregontrailredux.control.ViewController;
import byui.cit260.oregontrailredux.model.Game;
import byui.cit260.oregontrailredux.model.Person;
import byui.cit260.oregontrailredux.model.Team;
import byui.cit260.oregontrailredux.model.enums.Profession;
import byui.cit260.oregontrailredux.view.io.Output;
import java.util.stream.Stream;

/**
 *
 * @author Connor
 */
public final class SelectProfessionMenu extends AbstractMenu implements ViewInterface {

    /**
     * The default constructor.
     * @param person
     */
    public SelectProfessionMenu(final Person person) {
        this.title = "Select profession";

        Stream.of(Profession.values()).skip(1).forEach((Profession profession) -> {
            this.addOption(profession.symbol, profession.descriptor, () -> {
                Game game = GameController.getCurrentGame();
                Team team = game.getTeam();
                person.setProfession(profession);
                new TeamController(team).setMoney(profession.initialMoney,
                        game.getDifficulty().modifier);
                Output.println("The " + person.getType().label + " is now a "
                        + profession.descriptor.toLowerCase() + ".");
                ViewController.getInstance().quitCurrentView();
            });
        });
    }
}
