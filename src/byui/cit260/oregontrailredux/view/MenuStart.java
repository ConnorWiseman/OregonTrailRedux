package byui.cit260.oregontrailredux.view;

import byui.cit260.oregontrailredux.control.GameControl;
import byui.cit260.oregontrailredux.control.ViewControl;
import java.io.IOException;

public final class MenuStart extends Menu implements ViewInterface {
    public MenuStart() {     
        this.title = "Oregon Trail Redux";
        this.addOption('N', "New game",  () -> this.startNewGame());
        this.addOption('L', "Load game", () -> Output.println("Load game!"));
        this.addOption('A', "About",     () -> this.displayAbout());
        this.addOption('H', "Help",      () -> ViewControl.goToView("MenuHelp"));
        this.addOption('Q', "Quit",      () -> ViewControl.quitCurrentView());
    }
    
    private void displayAbout() {
        Formatter.displayText("About this game");
    }
    
    private void startNewGame() {
        try {
            String name = Input.getString("Enter your name: ");
            GameControl.create(name);
            ViewControl.goToView("MenuGame");
        } catch (IOException e) {
            // Log the exception?
        }
    }
}
