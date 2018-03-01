package byui.cit260.oregontrailredux.control;

import byui.cit260.oregontrailredux.model.Location;
import byui.cit260.oregontrailredux.model.Map;

import byui.cit260.oregontrailredux.enums.LocationType;

public abstract class MapControl {
    public static Map create() {
        Map map = new Map();
        
        for (LocationType type: LocationType.values()) {
            Location location = new Location(type.name, type.description, type.distance);
            map.getContents().add(location);
        }
        
        return map;
    }
}
