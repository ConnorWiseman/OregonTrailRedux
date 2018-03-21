package byui.cit260.oregontrailredux.view;

import byui.cit260.oregontrailredux.control.ViewController;

/**
 * A menu used to display help information.
 *
 * @author Connor
 */
public final class HelpMenu extends AbstractMenu implements ViewInterface {

    /**
     * The default constructor.
     */
    public HelpMenu() {
        this.title = "Help";
        this.addOption('Q', "Quit help", ()
                -> ViewController.getInstance().quitCurrentView());
    }
}
