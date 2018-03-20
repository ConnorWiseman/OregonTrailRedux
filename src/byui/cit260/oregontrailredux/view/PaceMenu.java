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
public final class PaceMenu extends AbstractMenu implements ViewInterface {

    /**
     * The default constructor.
     */
    public PaceMenu() {
        this.title = "Select pace";

        for (final Pace pace : Pace.values()) {
            this.addOption(pace.symbol, pace.descriptor, () -> {
                final Team team = new GameController().getResource().getTeam();
                team.setPace(pace);
                ViewController.quitCurrentView();
            });
        }
    }
}
