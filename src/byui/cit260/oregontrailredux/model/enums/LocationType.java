package byui.cit260.oregontrailredux.model.enums;

/**
 * Definitions for every Location in the game.
 *
 * @author Connor
 */
public enum LocationType {

    NOWHERE("Nowhere", 0, 0, "", Tile.EMPTY),
    NAUVOO("Nauvoo", 19, 0, "The home of the Saints in Illinois.", Tile.CITY),
    SALT_LAKE_VALLEY("Salt Lake Valley", 0, 7, "The home of the Saints in the wilderness", Tile.CITY);

    public final String name;
    public final int x;
    public final int y;
    public final String description;
    public final Tile tile;

    LocationType(final String name, final int x, final int y,
            final String description, final Tile tile) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.description = description;
        this.tile = tile;
    }
}
