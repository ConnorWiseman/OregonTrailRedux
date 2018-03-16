package byui.cit260.oregontrailredux.control;

import byui.cit260.oregontrailredux.model.Player;

public final class PlayerControl {

    private PlayerControl() {
    }

    public static Player create(final String name) {
        Player player = new Player();
        player.setName(name);

        return player;
    }
}
