package oregontrailredux;

import byui.cit260.oregontrailredux.control.GameController;

/**
 * The project's main class.
 *
 * @author Connor
 */
public class OregonTrailRedux {

    /**
     * The program's entry point.
     *
     * @param args
     */
    public static void main(String[] args) {
        new GameController().startGame();
    }
}