package byui.cit260.oregontrailredux.view;

import byui.cit260.oregontrailredux.control.GameController;
import byui.cit260.oregontrailredux.control.ViewController;
import byui.cit260.oregontrailredux.model.Companions;
import byui.cit260.oregontrailredux.model.Person;
import byui.cit260.oregontrailredux.model.enums.PersonType;
import byui.cit260.oregontrailredux.view.print.TextBoxPrinter;
import byui.cit260.oregontrailredux.view.io.Input;
import byui.cit260.oregontrailredux.view.io.Output;
import java.io.IOException;
import java.util.ArrayList;

public final class CustomizePersonMenu extends AbstractMenu implements ViewInterface {

    public CustomizePersonMenu(final Person companion) {
        this.title = "Customize " + companion.getType().label;
        this.addOption('D', "Details",
                () -> this.displayDetails(companion));
        this.addOption('N', "Set name", () -> this.setName(companion));
        this.addOption('A', "Set age", () -> this.setAge(companion));
        this.addOption('G', "Select gender",
                () -> ViewController.getInstance()
                        .display(new SelectGenderMenu(companion)));

        if (companion.getType() == PersonType.LEADER) {
            this.addOption('P', "Select profession",
                    () -> ViewController.getInstance()
                            .display(new SelectProfessionMenu(companion)));
        }

        this.addOption('C', "Continue", () -> {
            ViewController.getInstance()
                    .confirm("Finish customizing your "
                            + companion.getType().label + "?",
                            () -> this.next(companion),
                            () -> ViewController.getInstance()
                                    .changeTo(new CustomizePersonMenu(companion)));
        });
    }

    private void displayDetails(final Person companion) {
        ArrayList<String> details = new ArrayList<>();
        details.add("Name:       " + companion.getName());
        details.add("Age:        " + companion.getAge());
        details.add("Gender:     " + companion.getGender().descriptor);

        if (companion.getType() == PersonType.LEADER) {
            details.add("Profession: " + companion.getProfession().descriptor);
        }

        TextBoxPrinter.printWithoutSpacing(details.stream()
                .toArray(String[]::new));
    }

    private void next(final Person companion) {
       final Companions companions = GameController.getCurrentGame().getTeam()
                .getCompanions();
        
        if (companion.getType() == PersonType.COMPANION) {
            companions.getMembers().add(companion);
        }

        ViewController.getInstance()
                .changeTo(new CustomizeCompanionsMenu(companions));
    }

    private void setAge(final Person companion) {
        try {
            final String label = companion.getType().label;
            int age = Input.getInt("Enter the " + label + "'s age:");
            companion.setAge(age);
            Output.println("The " + label + " is now "
                    + companion.getAge() + " years old.");
        } catch (IOException ex) {
            // Log the exception?
        }
    }

    private void setName(final Person companion) {
        try {
            final String label = companion.getType().label;
            String name = Input.getString("Enter the " + label + "'s name:");
            companion.setName(name);
            Output.println("The " + label + " is now named "
                    + companion.getName() + ".");
        } catch (IOException ex) {
            // Log the exception?
        }
    }
}
