package byui.cit260.oregontrailredux.view;

import byui.cit260.oregontrailredux.view.format.MenuPrinter;
import byui.cit260.oregontrailredux.view.io.Input;
import byui.cit260.oregontrailredux.view.io.Output;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * The base Menu class from which all other menus are derived.
 *
 * @author Connor
 * @private
 */
abstract class Menu implements ViewInterface {

    /**
     * An ordered map of Menu options, mapping a Character to an Option.
     */
    private final HashMap<Character, Option> options;

    /**
     * The title of the Menu.
     */
    protected String title;
    
    protected String prompt;

    /**
     * Instantiates the LinkedHashMap of Character-to-Option entries. It's
     * important to use LinkedHashMap because insertion order is guaranteed;
     * therefore, Menu options will be displayed in the order in which they
     * were added.
     */
    public Menu() {
        this.options = new LinkedHashMap<>();
        this.prompt = "Select an option:";
    }

    /**
     * Adds the specified option to the Menu.
     *
     * @param symbol
     * @param label
     * @param lambda
     */
    protected final void addOption(final char symbol, final String label,
            final Runnable lambda) {
        this.options.put(symbol, new Option(label, lambda));
    }

    /**
     * Displays this Menu using the MenuPrinter class.
     */
    @Override
    public void display() {
        String[] menuOptions = this.options.entrySet()
                .stream()
                .map(e -> e.getKey() + " - " + e.getValue().label)
                .toArray(String[]::new);

        MenuPrinter.print(this.title, menuOptions);
    }

    /**
     * Performs the action specified by the user.
     *
     * @param choice
     */
    @Override
    public void doAction(final char choice) {
        Option option = this.options.get(choice);

        if (option != null) {
            option.run();
        } else {
            Output.println("\nInvalid selection.");
        }
    }

    /**
     * Prompts the user for an Option from this Menu's menu options.
     *
     * @return
     */
    @Override
    public char getInput() {
        char input = 0;

        try {
            input = Character.toUpperCase(Input.getChar(this.prompt));
        } catch (IOException e) {
            // Log the exception?
        }

        return input;
    }
}
