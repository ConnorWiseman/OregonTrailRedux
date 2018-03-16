package byui.cit260.oregontrailredux.view;

import byui.cit260.oregontrailredux.control.GameControl;
import byui.cit260.oregontrailredux.control.TeamControl;
import byui.cit260.oregontrailredux.control.ViewControl;
import byui.cit260.oregontrailredux.model.Game;
import byui.cit260.oregontrailredux.model.Team;
import byui.cit260.oregontrailredux.model.enums.Profession;
import byui.cit260.oregontrailredux.view.io.Output;
import java.util.stream.Stream;

/**
 *
 * @author Connor
 */
public final class SelectLeaderProfessionMenu extends AbstractMenu implements ViewInterface {

    /**
     * The default constructor.
     */
    public SelectLeaderProfessionMenu() {
        this.title = "Select profession";

        Stream.of(Profession.values()).skip(1).forEach((Profession profession) -> {
            this.addOption(profession.symbol, profession.descriptor, () -> {
                Game game = GameControl.getCurrentGame();
                Team team = game.getTeam();
                team.getLeader().setProfession(profession);
                TeamControl.setMoney(team, profession.initialMoney,
                        game.getDifficulty().modifier);
                Output.println("The team leader is now a "
                        + profession.descriptor.toLowerCase() + ".");
                ViewControl.quitCurrentView();
            });
        });
    }
}
