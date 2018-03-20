package byui.cit260.oregontrailredux.view;

import byui.cit260.oregontrailredux.control.ViewController;

public final class CustomizeCompanionsMenu extends AbstractMenu implements ViewInterface {
    /**
     * The default constructor.
     */
    public CustomizeCompanionsMenu() {
        this.title = "Customize companions";
        
        this.addOption('L', "List companions", () -> {});
        this.addOption('A', "Add companion", () -> {});
        this.addOption('R', "Remove companion", () -> {});
        this.addOption('C', "Continue", () -> {
            ViewController.confirm("Finish customizing your team companions?",
                    () -> ViewController.changeTo(new GameMenu()),
                    () -> ViewController.changeTo(new CustomizeCompanionsMenu()));
        });
    }
}
