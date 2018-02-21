package byui.cit260.oregontrailredux.view;

import java.io.IOException;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Map.Entry;

/**
 * The base class from which all Menus are derived.
 * @author Connor
 */
public abstract class Menu implements ViewInterface {
    // Class constants. Used for formatting the appearance of all menus.
    private static final int    MAX_WIDTH = 32;
    private static final char   H_SYMBOL  = '-';
    private static final char   V_SYMBOL  = '|';
    private static final String DIVIDER   = " - ";
    
    // The message dislayed when users select an invalid menu option.
    protected static String INVALID_CHOICE = "\nInvalid selection.";

    // Class members.
    protected final ArrayList<Entry<Character, String>> entries;
    protected       String                              title;
    
    /**
     * Instantiates the ArrayList of menu entries.
     */
    public Menu() {
        this.entries = new ArrayList<>();
    }
    
    /**
     * Adds a menu entry to this Menu.
     * @param symbol
     * @param label
     */
    protected final void addEntry(char symbol, String label) {
        this.entries.add(new SimpleEntry<>(symbol, label));
    }

    /**
     * Prompts the user for an option from this Menu's menu entries.
     * @return 
     */
    @Override
    public char getInput() {
        char input = 0;
        
        try {
            input = Character.toUpperCase(Input.getChar("Select an option: "));
        } catch (IOException e) {
            Output.printError(e.toString());
        }
        
        return input;
    }

    /**
     * Displays this Menu using the Formatter class.
     */
    @Override
    public void display() {
        String[] menuEntries = this.entries.stream()
                .map(e -> e.getKey() + Menu.DIVIDER + e.getValue())
                .toArray(String[]::new);

        Formatter.displayMenu(Menu.MAX_WIDTH, Menu.H_SYMBOL, Menu.V_SYMBOL,
                title, menuEntries);
    }
}
