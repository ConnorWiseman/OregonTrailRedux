package byui.cit260.oregontrailredux.view;

import byui.cit260.oregontrailredux.control.ViewControl;

public final class MenuHelp extends Menu implements ViewInterface {
    public MenuHelp() {
        this.title = "Help";
        this.addOption('Q', "Quit", () -> ViewControl.quitCurrentView());
    }
}
