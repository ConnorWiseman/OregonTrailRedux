package byui.cit260.oregontrailredux.enums;

/**
 * Definitions for every Location in the game. Each Location definition includes
 * a name, a description, and the number of miles from the starting point. Note
 * that Salt Lake Valley must be ~1,300 miles away from Nauvoo for historical
 * and geographical accuracy.
 * @author Connor
 */
public enum LocationType {
    NAUVOO(
            "Nauvoo",
            "The home of the Saints in Illinois.",
            0
    ),
    SALT_LAKE_VALLEY(
            "Salt Lake Valley",
            "The home of the Saints in the wilderness",
            1300
    );

    public final String name;
    public final String description;
    public final int    distance;
    
    LocationType(final String name, final String description,
            final int distance) {
        this.name        = name;
        this.description = description;
        this.distance    = distance;
    }
}