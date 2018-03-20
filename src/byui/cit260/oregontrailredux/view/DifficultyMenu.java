package byui.cit260.oregontrailredux.view;

import byui.cit260.oregontrailredux.control.GameController;
import byui.cit260.oregontrailredux.control.ViewController;
import byui.cit260.oregontrailredux.model.enums.Difficulty;

/**
 * A menu used to select the difficulty level of a new game. Not intended to be
 * reused at any point after a new Game instance has been created; difficulty
 * cannot be changed mid-game.
 *
 * @author Connor
 */
public final class DifficultyMenu extends AbstractMenu implements ViewInterface {

    /**
     * The default constructor.
     */
    public DifficultyMenu() {
        this.title = "Select difficulty";

        for (final Difficulty mode : Difficulty.values()) {
            this.addOption(mode.symbol, mode.descriptor, () -> {
                new GameController().getResource().setDifficulty(mode);
                ViewController.changeTo(new CustomizeLeaderMenu());
            });
        }
    }
}
