package byui.cit260.oregontrailredux.view;

import byui.cit260.oregontrailredux.control.GameControl;
import byui.cit260.oregontrailredux.control.ViewControl;
import byui.cit260.oregontrailredux.model.enums.Difficulty;

public class DifficultyMenu extends Menu implements ViewInterface {

    public DifficultyMenu() {
        this.title = "Select difficulty";

        for (final Difficulty mode : Difficulty.values()) {
            this.addOption(mode.symbol, mode.descriptor,
                    () -> this.setDifficulty(mode));
        }
    }

    private void setDifficulty(final Difficulty mode) {
        GameControl.setDifficulty(mode);
        ViewControl.changeToView("GameMenu");
    }
}
