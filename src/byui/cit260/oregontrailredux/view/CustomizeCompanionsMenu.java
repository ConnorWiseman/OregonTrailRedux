package byui.cit260.oregontrailredux.view;

import byui.cit260.oregontrailredux.control.ViewControl;

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
            ViewControl.confirm("Finish customizing your team companions?",
                    () -> ViewControl.changeTo("GameMenu"),
                    () -> ViewControl.changeTo("CustomizeCompanionsMenu"));
        });
    }
}
