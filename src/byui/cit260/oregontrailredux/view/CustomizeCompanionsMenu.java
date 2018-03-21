package byui.cit260.oregontrailredux.view;

import byui.cit260.oregontrailredux.control.ViewController;
import byui.cit260.oregontrailredux.model.Companions;
import byui.cit260.oregontrailredux.model.Person;
import byui.cit260.oregontrailredux.model.enums.PersonType;
import byui.cit260.oregontrailredux.view.io.Output;

public final class CustomizeCompanionsMenu extends AbstractMenu implements ViewInterface {

    /**
     * The default constructor.
     * @param companions
     */
    public CustomizeCompanionsMenu(final Companions companions) {
        this.title = "Customize companions";

        this.addOption('L', "List companions", () -> {
            Output.println(companions);
        });
        this.addOption('A', "Add companion", () -> {
            final Person companion = new Person();
            companion.setType(PersonType.COMPANION);
            ViewController.getInstance()
                    .changeTo(new CustomizePersonMenu(companion));
        });
        this.addOption('R', "Remove companion", () -> {
            if (companions.getMembers().isEmpty()) {
                Output.println("No companions to remove!");
            } else {
                ViewController.getInstance()
                        .changeTo(new RemoveCompanionMenu(companions));
            }
        });
        this.addOption('C', "Continue", () -> {
            ViewController.getInstance()
                    .confirm("Finish customizing your team companions?",
                            () -> ViewController.getInstance()
                                    .changeTo(new GameMenu()),
                            () -> ViewController.getInstance()
                                    .changeTo(new CustomizeCompanionsMenu(companions)));
        });
    }
}
