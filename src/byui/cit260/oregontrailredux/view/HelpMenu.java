package byui.cit260.oregontrailredux.view;

import byui.cit260.oregontrailredux.control.ViewControl;

import byui.cit260.oregontrailredux.model.Game;

public class HelpMenu extends Menu implements ViewInterface {
    public HelpMenu() {
        this.title = "Help";
        this.addEntry('Q', "Quit");
    }
    
    @Override
    public void doAction(char choice, Game game) {
        switch (choice) {
            case 'Q':
                Output.println("Quitting help menu...");
                ViewControl.quitCurrentView();
                break;
            default:
                Output.println(Menu.INVALID_CHOICE);
                break;
        }
    }
}
