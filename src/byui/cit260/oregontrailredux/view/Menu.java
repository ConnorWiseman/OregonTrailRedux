package byui.cit260.oregontrailredux.view;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.ArrayList;

public abstract class Menu implements ViewInterface {
    private static final int    MAX_WIDTH = 32;
    private static final char   H_SYMBOL  = '-';
    private static final char   V_SYMBOL  = '|';
    private static final String DIVIDER   = " - ";
    
    protected static String INVALID_CHOICE = "\nInvalid selection. Please try again.";
    
    protected final ArrayList<MenuItem> items;
    protected final ViewStack views;
    
    protected String title;
    
    public Menu(ViewStack views) {
        this.items = new ArrayList<>();
        this.views = views;
        }
    
    protected final void addItem(char symbol, String label) {
        this.items.add(new MenuItem(symbol, label));
    }
    
    protected final void goToView(String target) {
        try {
            Class c = Class.forName("byui.cit260.oregontrailredux.view." + target);
            Constructor ctor = c.getConstructor(ViewStack.class);
            ViewInterface view = (ViewInterface) ctor.newInstance(this.views);
            
            this.views.push(view);
        } catch (Exception e) {
            Output.error(e.toString());
        }
    }
    
    protected final void quit() {
        this.views.pop();
    }

    @Override
    public char getInput() {
        char input = 0;
        
        try {
            input = Character.toUpperCase(Input.getChar("Select an option: "));
        } catch (IOException e) {
            Output.error(e.toString());
        }
        
        return input;
    }
    
    @Override
    public void display() {
        int numItems   = this.items.size();
        String[] lines = new String[numItems];
        
        for (int i = 0; i < numItems; i++) {
            MenuItem current = this.items.get(i);
            lines[i] = current.symbol + Menu.DIVIDER + current.label;
        }
   
        Formatter.displayMenu(Menu.MAX_WIDTH, Menu.H_SYMBOL, Menu.V_SYMBOL, title, lines);
    }
}
