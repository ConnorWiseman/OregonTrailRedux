package byui.cit260.oregontrailredux.view;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * The base class from which all Menus are derived.
 * @author Connor
 */
public abstract class Menu implements ViewInterface {

    /**
     * An ordered map of Menu options, mapping a Character to an Option.
     */
    protected final HashMap<Character, Option> options;

    /**
     * The title of the Menu.
     */
    protected String title;
    
    /**
     * Instantiates the LinkedHashMap of Character-to-Option entries. It's
     * important to use LinkedHashMap because insertion order is guaranteed;
     * therefore, Menu options will be displayed in the order in which they
     * were added.
     */
    public Menu() {
        this.options = new LinkedHashMap<>();
    }
    
    /**
     * Adds the specified option to the Menu.
     * @param symbol
     * @param label
     * @param lambda
     */
    protected final void addOption(final char symbol, final String label,
            final Runnable lambda) {
        this.options.put(symbol, new Option(label, lambda));
    }
    
    /**
     * Displays this Menu using the Formatter class.
     */
    @Override
    public void display() {
        String[] menuOptions = this.options.entrySet()
                .stream()
                .map(e -> e.getKey() + " - " + e.getValue().label)
                .toArray(String[]::new);

        Formatter.displayMenu(32, '-', '|', this.title, menuOptions);
    }
    
    /**
     * Performs the action specified by the user.
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
     * Prompts the user for an option from this Menu's menu options.
     * @return 
     */
    @Override
    public char getInput() {
        char input = 0;
        
        try {
            input = Character.toUpperCase(Input.getChar("Select an option: "));
        } catch (IOException e) {
            // Log the exception?
        }
        
        return input;
    }
}
