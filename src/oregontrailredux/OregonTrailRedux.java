package oregontrailredux;

import byui.cit260.oregontrailredux.control.GameControl;

import byui.cit260.oregontrailredux.model.Game;

public class OregonTrailRedux {
    public static void main(String[] args) {
        Game current = GameControl.createNewGame("Player");
        GameControl.startGame(current);
    }
}
