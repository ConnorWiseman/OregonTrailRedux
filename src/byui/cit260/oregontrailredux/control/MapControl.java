package byui.cit260.oregontrailredux.control;

import byui.cit260.oregontrailredux.model.Location;
import byui.cit260.oregontrailredux.model.Map;
import byui.cit260.oregontrailredux.model.Point;
import byui.cit260.oregontrailredux.model.enums.LocationType;
import java.util.HashMap;
import java.util.stream.IntStream;

public final class MapControl {

    private MapControl() {
    }

    private static void fill(final Map map) {
        HashMap<Point, Location> locations = map.getContents();

        IntStream.range(0, map.getNumRows()).forEach((final int y) -> {
            IntStream.range(0, map.getNumColumns()).forEach((final int x) -> {
                locations.put(new Point(x, y), new Location());
            });
        });
    }

    private static void populate(final Map map) {
        HashMap<Point, Location> locations = map.getContents();

        for (final LocationType type : LocationType.values()) {
            locations.get(new Point(type.x, type.y)).setType(type);
        }
    }

    public static Map create() {
        Map map = new Map();

        map.setCurrentPosition(new Point(19, 0));
        map.setNumColumns(20);
        map.setNumRows(10);
        MapControl.fill(map);
        MapControl.populate(map);

        return map;
    }

    public static boolean isValidPoint(final Map map, final Point point) {
        return (map.getContents().get(point) != null);
    }

}
