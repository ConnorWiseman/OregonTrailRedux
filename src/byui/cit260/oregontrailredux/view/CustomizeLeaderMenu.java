package byui.cit260.oregontrailredux.view;

import byui.cit260.oregontrailredux.control.GameControl;
import byui.cit260.oregontrailredux.control.ViewControl;
import byui.cit260.oregontrailredux.model.Person;
import byui.cit260.oregontrailredux.view.print.TextBoxPrinter;
import byui.cit260.oregontrailredux.view.io.Input;
import byui.cit260.oregontrailredux.view.io.Output;
import java.io.IOException;

public final class CustomizeLeaderMenu extends AbstractMenu implements ViewInterface {

    public CustomizeLeaderMenu() {
        this.title = "Customize team leader";
        this.addOption('D', "Leader details",
                () -> CustomizeLeaderMenu.displayDetails());
        this.addOption('N', "Set name", () -> CustomizeLeaderMenu.setName());
        this.addOption('A', "Set age", () -> CustomizeLeaderMenu.setAge());
        this.addOption('G', "Select gender",
                () -> ViewControl.display("SelectLeaderGenderMenu"));
        this.addOption('P', "Select profession",
                () -> ViewControl.display("SelectLeaderProfessionMenu"));

        this.addOption('C', "Continue", () -> {
            ViewControl.confirm("Finish customizing your team leader?",
                    () -> CustomizeLeaderMenu.next(),
                    () -> ViewControl.changeTo("CustomizeLeaderMenu"));
        });
    }

    private static void displayDetails() {
        Person leader = GameControl.getCurrentGame().getTeam().getLeader();
        TextBoxPrinter.printWithoutSpacing("Name:       " + leader.getName(),
                "Age:        " + leader.getAge(),
                "Gender:     " + leader.getGender().descriptor,
                "Profession: " + leader.getProfession().descriptor);
    }

    private static void next() {
        // set team leader's hunting/gathering skills
        ViewControl.changeTo("CustomizeCompanionsMenu");
    }

    private static void setAge() {
        try {
            int age = Input.getInt("Enter the team leader's age:");
            Person leader = GameControl.getCurrentGame().getTeam().getLeader();
            leader.setAge(age);
            Output.println("The team leader is now " + leader.getAge()
                    + " years old.");
        } catch (IOException ex) {
            // Log the exception?
        }
    }

    private static void setName() {
        try {
            String name = Input.getString("Enter the team leader's name:");
            Person leader = GameControl.getCurrentGame().getTeam().getLeader();
            leader.setName(name);
            Output.println("The team leader is now named " + leader.getName()
                    + ".");
        } catch (IOException ex) {
            // Log the exception?
        }
    }
}
