package byui.cit260.oregontrailredux.view;

import byui.cit260.oregontrailredux.view.io.Output;
import byui.cit260.oregontrailredux.control.GameControl;
import byui.cit260.oregontrailredux.control.ViewControl;

public final class GameMenu extends Menu implements ViewInterface {

    public GameMenu() {
        this.title = "Play";
        this.addOption('D', "Debug info", () -> this.displayDebugInfo());
        this.addOption('S', "Save game", () -> this.saveGame());
        this.addOption('Q', "Quit", ()
                -> ViewControl.changeToView("ConfirmQuitGameMenu"));
    }

    private void displayDebugInfo() {
        Output.println(GameControl.getCurrentGame().getPlayer().getName());
        Output.println(GameControl.getCurrentGame().getDifficulty());
        Output.println(GameControl.getCurrentGame().getTeam());
    }
    
    private void saveGame() {
        GameControl.saveGame();
        Output.println("The game was saved successfully!");
    }
}
