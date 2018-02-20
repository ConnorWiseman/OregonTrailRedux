package byui.cit260.oregontrailredux.view;

import java.util.ArrayList;

/**
 * A wrapper class around an ArrayList of objects that implement the
 * ViewInterface. Provides some convenience methods with more conventional
 * names than Java's add/remove.
 * @author Connor
 */
public class ViewStack {
    private final ArrayList<ViewInterface> stack;
    
    /**
     * Initializes the underlying ArrayList.
     */
    public ViewStack() {
        this.stack = new ArrayList<>();
    }
    
    /**
     * Pushes a view onto the end of the underlying ArrayList.
     * @param view
     */
    public void push(ViewInterface view) {
        this.stack.add(view);
    }
    
    /**
     * Removes the last view in the underlying ArrayList.
     */
    public void pop() {
        this.stack.remove(this.size() - 1);
    }
    
    /**
     * Returns the size of the underlying ArrayList.
     * @return
     */
    public int size() {
        return this.stack.size();
    }
    
    /**
     * Returns a reference to the last view in the underlying ArrayList.
     * @return
     */
    public ViewInterface top() {
        return this.stack.get(this.size() - 1);
    }
}
