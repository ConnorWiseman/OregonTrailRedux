package byui.cit260.oregontrailredux.view;

import byui.cit260.oregontrailredux.control.GameController;
import byui.cit260.oregontrailredux.control.ViewController;
import byui.cit260.oregontrailredux.model.Team;
import byui.cit260.oregontrailredux.model.enums.Pace;

/**
 * A menu used to select the Pace a Team travels at.
 *
 * @author Connor
 */
public final class SelectPaceMenu extends AbstractMenu implements ViewInterface {

    /**
     * The default constructor.
     */
    public SelectPaceMenu() {
        this.title = "Select pace";

        for (final Pace pace : Pace.values()) {
            this.addOption(pace.symbol, pace.descriptor, () -> {
                final Team team = GameController.getCurrentGame().getTeam();
                team.setPace(pace);
                ViewController.getInstance().quitCurrentView();
            });
        }
    }
}
