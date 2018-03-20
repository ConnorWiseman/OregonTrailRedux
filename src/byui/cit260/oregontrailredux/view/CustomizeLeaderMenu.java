package byui.cit260.oregontrailredux.view;

import byui.cit260.oregontrailredux.control.GameController;
import byui.cit260.oregontrailredux.control.ViewController;
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
                () -> ViewController.display(new SelectLeaderGenderMenu()));
        this.addOption('P', "Select profession",
                () -> ViewController.display(new SelectLeaderProfessionMenu()));

        this.addOption('C', "Continue", () -> {
            ViewController.confirm("Finish customizing your team leader?",
                    () -> CustomizeLeaderMenu.next(),
                    () -> ViewController.changeTo(new CustomizeLeaderMenu()));
        });
    }

    private static void displayDetails() {
        Person leader = new GameController().getResource().getTeam()
                .getLeader();
        TextBoxPrinter.printWithoutSpacing("Name:       " + leader.getName(),
                "Age:        " + leader.getAge(),
                "Gender:     " + leader.getGender().descriptor,
                "Profession: " + leader.getProfession().descriptor);
    }

    private static void next() {
        // set team leader's hunting/gathering skills
        ViewController.changeTo(new CustomizeCompanionsMenu());
    }

    private static void setAge() {
        try {
            int age = Input.getInt("Enter the team leader's age:");
            Person leader = new GameController().getResource().getTeam()
                    .getLeader();
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
            Person leader = new GameController().getResource().getTeam()
                    .getLeader();
            leader.setName(name);
            Output.println("The team leader is now named " + leader.getName()
                    + ".");
        } catch (IOException ex) {
            // Log the exception?
        }
    }
}
