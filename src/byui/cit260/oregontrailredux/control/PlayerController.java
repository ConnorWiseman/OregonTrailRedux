package byui.cit260.oregontrailredux.control;

import byui.cit260.oregontrailredux.model.Player;

public final class PlayerController {
    
    private final Player player;

    
    public PlayerController(final Player player) {
        this.player = player;
    }

    public static Player create() {
        return new Player();
    }

}
