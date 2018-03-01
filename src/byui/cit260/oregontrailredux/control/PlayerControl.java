package byui.cit260.oregontrailredux.control;

import byui.cit260.oregontrailredux.model.Player;

public abstract class PlayerControl {
    public static Player create(final String name) {
        Player player = new Player();
        player.setName(name);
        
        return player;
    }
}
