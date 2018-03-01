package byui.cit260.oregontrailredux.view;

import byui.cit260.oregontrailredux.control.GameControl;
import byui.cit260.oregontrailredux.control.ViewControl;

public final class MenuGame extends Menu implements ViewInterface {
    public MenuGame() {
        this.title = "Play";
        this.addOption('P', "Player info", () -> this.displayPlayerInfo());
        this.addOption('Q', "Quit",        () -> ViewControl.quitCurrentView());
    }
    
    private void displayPlayerInfo() {
        Output.println(GameControl.getCurrentGame().getPlayer().getName());
    }
}
