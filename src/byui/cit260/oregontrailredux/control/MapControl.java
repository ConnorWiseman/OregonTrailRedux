package byui.cit260.oregontrailredux.control;

import byui.cit260.oregontrailredux.model.enums.LocationType;
import byui.cit260.oregontrailredux.model.Location;
import byui.cit260.oregontrailredux.model.Map;
import java.util.ArrayList;

public abstract class MapControl {

    public static Map create() {
        Map map = new Map();

        ArrayList<Location> locations = map.getContents();

        for (LocationType type : LocationType.values()) {
            Location location
                    = new Location(type.name, type.description, type.distance);
            locations.add(location);
        }

        return map;
    }
}
