package byui.cit260.oregontrailredux.view;

import byui.cit260.oregontrailredux.view.util.Runnable;

/**
 * A special variant of a menu used to confirm a sensitive in-game action.
 *
 * @author Connor
 */
public final class ConfirmMenu extends AbstractMenu implements ViewInterface {

    /**
     * The custom constructor.
     *
     * @param prompt
     * @param y
     * @param n
     */
    public ConfirmMenu(final String prompt, final Runnable y,
            final Runnable n) {
        this.prompt = prompt;
        this.title = "Confirm";
        this.addOption('Y', "Yes", y);
        this.addOption('N', "No", n);
    }
}
