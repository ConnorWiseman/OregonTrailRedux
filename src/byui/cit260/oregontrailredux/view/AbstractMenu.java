package byui.cit260.oregontrailredux.view;

import byui.cit260.oregontrailredux.view.util.Runnable;
import byui.cit260.oregontrailredux.view.print.MenuPrinter;
import byui.cit260.oregontrailredux.view.io.Input;
import byui.cit260.oregontrailredux.view.io.Output;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * The base AbstractMenu class from which all other menus are derived.
 *
 * @author Connor
 * @private
 */
abstract class AbstractMenu implements ViewInterface {

    /**
     * An ordered map of AbstractMenu options, mapping a Character to an Option.
     */
    private final HashMap<Character, Option> options;

    /**
     * The title of the AbstractMenu.
     */
    protected String title;

    /**
     * The prompt displayed by the AbstractMenu.
     */
    protected String prompt;

    /**
     * Instantiates the LinkedHashMap of Character-to-Option entries. It's
     * important to use LinkedHashMap because insertion order is guaranteed;
     * therefore, Menu options will be displayed in the order in which they were
     * added.
     */
    public AbstractMenu() {
        this.options = new LinkedHashMap<>();
        this.prompt = "Select an option:";
    }

    /**
     * Adds the specified option to the AbstractMenu.
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
     * Displays this AbstractMenu using the MenuPrinter class.
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
            option.select();
        } else {
            Output.println("Invalid selection.");
        }
    }

    /**
     * Prompts the user for an Option from this AbstractMenu's menu options.
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
