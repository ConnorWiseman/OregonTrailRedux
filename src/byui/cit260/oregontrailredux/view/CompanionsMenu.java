package byui.cit260.oregontrailredux.view;

import byui.cit260.oregontrailredux.control.CompanionsController;
import byui.cit260.oregontrailredux.control.GameController;
import byui.cit260.oregontrailredux.control.ViewController;
import byui.cit260.oregontrailredux.model.Companions;
import byui.cit260.oregontrailredux.view.io.Input;
import java.io.IOException;

public final class CompanionsMenu extends AbstractMenu implements ViewInterface {

    /**
     * The default constructor.
     */
    public CompanionsMenu() {
        this.title = "Choose companions";

        this.addOption('A', "Add companion", () -> this.addCompanion());
        this.addOption('C', "Continue", () ->
                ViewController.changeTo(new GameMenu()));
    }

    private void addCompanion() {
        try {
            String name = Input.getString("Enter companion's name:");
            int age = Input.getInt("Enter companion's age:");
            Companions companions = new GameController().getResource()
                    .getTeam().getCompanions();
            CompanionsController gc = new CompanionsController(companions);
            gc.add(name, age);
        } catch (IOException ex) {
            // Log the exception?
        }
    }
}
