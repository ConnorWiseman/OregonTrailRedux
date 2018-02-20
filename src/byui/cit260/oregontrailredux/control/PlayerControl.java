package byui.cit260.oregontrailredux.control;

import byui.cit260.oregontrailredux.model.Player;

public abstract class PlayerControl {
    public static Player createNewPlayer(String name) {
        return new Player(name);
    }
}
