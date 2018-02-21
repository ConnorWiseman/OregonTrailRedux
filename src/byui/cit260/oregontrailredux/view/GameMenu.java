package byui.cit260.oregontrailredux.view;

import byui.cit260.oregontrailredux.control.ViewControl;

import byui.cit260.oregontrailredux.model.Game;

public class GameMenu extends Menu implements ViewInterface {
    public GameMenu() {     
        this.title = "Game Menu";
        this.addEntry('N', "New game");
        this.addEntry('L', "Load game");
        this.addEntry('H', "Help");
        this.addEntry('Q', "Quit");
    }
    
    @Override
    public void doAction(char choice, Game game) {
        switch (choice) {
            case 'N':
                Output.println("New game!");
                break;
            case 'L':
                Output.println("Load game!");
                break;
            case 'H':
                Output.println("Help!");
                ViewControl.goToView("HelpMenu");
                break;
            case 'Q':
                Output.println("Quitting the " + this.title + "...");
                ViewControl.quitCurrentView();
                break;
            default:
                Output.println(Menu.INVALID_CHOICE);
                break;
        }
    }
}
