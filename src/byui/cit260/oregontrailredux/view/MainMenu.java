package byui.cit260.oregontrailredux.view;

import byui.cit260.oregontrailredux.model.Game;

public class MainMenu extends Menu implements ViewInterface {
    public MainMenu(ViewStack views) {
        super(views);
        
        this.title = "Main Menu";
        this.addItem('N', "New game");
        this.addItem('L', "Load game");
        this.addItem('H', "Help");
        this.addItem('Q', "Quit");
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
                this.goToView("HelpMenu");
                break;
            case 'Q':
                Output.println("Quitting the " + this.title + "...");
                this.quit();
                break;
            default:
                Output.println(Menu.INVALID_CHOICE);
                break;
        }
    }
}
