package byui.cit260.oregontrailredux.view;

import byui.cit260.oregontrailredux.control.ViewControl;

public final class HelpMenu extends Menu implements ViewInterface {

    public HelpMenu() {
        this.title = "Help";
        this.addOption('Q', "Quit", () -> ViewControl.quitCurrentView());
    }
}
