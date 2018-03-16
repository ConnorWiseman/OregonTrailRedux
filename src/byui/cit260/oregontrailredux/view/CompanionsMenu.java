package byui.cit260.oregontrailredux.view;

import byui.cit260.oregontrailredux.control.CompanionsControl;
import byui.cit260.oregontrailredux.control.ViewControl;
import byui.cit260.oregontrailredux.view.io.Input;
import java.io.IOException;

public final class CompanionsMenu extends AbstractMenu implements ViewInterface {

    /**
     * The default constructor.
     */
    public CompanionsMenu() {
        this.title = "Choose companions";

        this.addOption('A', "Add companion", () -> this.addCompanion());
        this.addOption('C', "Continue", () -> ViewControl.changeTo("GameMenu"));
    }

    private void addCompanion() {
        try {
            String name = Input.getString("Enter companion's name:");
            int age = Input.getInt("Enter companion's age:");
            CompanionsControl.add(name, age);
        } catch (IOException ex) {
            // Log the exception?
        }
    }
}
