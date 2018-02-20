package byui.cit260.oregontrailredux.control;

import byui.cit260.oregontrailredux.model.Location;
import byui.cit260.oregontrailredux.model.Map;

import byui.cit260.oregontrailredux.enums.LocationDefinition;

public abstract class MapControl {
    public static Map createNewMap() {
        Map map = new Map();
        
        for (LocationDefinition dfn: LocationDefinition.values()) {
            Location location = new Location(dfn.name, dfn.description, dfn.distance);
            map.getContents().add(location);
        }
        
        return map;
    }
}
