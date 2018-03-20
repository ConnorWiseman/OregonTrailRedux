package byui.cit260.oregontrailredux.control;

import byui.cit260.oregontrailredux.model.Player;

public final class PlayerController implements ControllerInterface {
    
    private final Player player;

    public PlayerController() {
        this.player = new Player();
    }
    
    public PlayerController(final Player player) {
        this.player = player;
    }

    @Override
    public Player create() {
        return new Player();
    }

    @Override
    public Player getResource() {
        return this.player;
    }

}
