package byui.cit260.oregontrailredux.view;

import byui.cit260.oregontrailredux.model.Game;

public class HelpMenu extends Menu implements ViewInterface {
    public HelpMenu(ViewStack views) {
        super(views);
        
        this.title = "Help";
        this.addItem('Q', "Quit");
    }
    
    @Override
    public void doAction(char choice, Game game) {
        switch (choice) {
            case 'Q':
                Output.println("Quitting help menu...");
                this.views.pop();
                break;
            default:
                Output.println(Menu.INVALID_CHOICE);
                break;
        }
    }
}
