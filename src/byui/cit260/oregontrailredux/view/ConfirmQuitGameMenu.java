package byui.cit260.oregontrailredux.view;

import byui.cit260.oregontrailredux.control.ViewControl;

/**
 * A Menu used to confirm the user's choice to quit the game.
 * @author Connor
 */
public class ConfirmQuitGameMenu extends Menu implements ViewInterface {

    /**
     * The default constructor.
     */
    public ConfirmQuitGameMenu() {
        this.prompt = "Do you really want to quit?";
        this.title = "Confirm";
        this.addOption('Y', "Yes", () -> ViewControl.quitCurrentView());
        this.addOption('N', "No", () -> ViewControl.changeToView("GameMenu"));
    }
}
