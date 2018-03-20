package byui.cit260.oregontrailredux.control;

import byui.cit260.oregontrailredux.model.Location;
import byui.cit260.oregontrailredux.model.Map;
import byui.cit260.oregontrailredux.model.Point;
import byui.cit260.oregontrailredux.model.enums.LocationType;
import java.util.HashMap;
import java.util.stream.IntStream;

public final class MapController implements ControllerInterface {

    private final Map map;

    public MapController() {
        this.map = new Map();
    }

    public MapController(final Map map) {
        this.map = map;
    }

    @Override
    public Map create() {
        final Map newMap = new Map();

        newMap.setCurrentPosition(new Point(19, 0));
        newMap.setNumColumns(20);
        newMap.setNumRows(11);
        this.fill(newMap);
        this.populate(newMap);

        return newMap;
    }

    private void fill(final Map map) {
        HashMap<Point, Location> locations = map.getContents();

        IntStream.range(0, map.getNumRows()).forEach((final int y) -> {
            IntStream.range(0, map.getNumColumns()).forEach((final int x) -> {
                locations.put(new Point(x, y), new Location());
            });
        });
    }

    @Override
    public Map getResource() {
        return this.map;
    }

    public boolean isValidPoint(final Point point) {
        return (this.map.getContents().get(point) != null);
    }

    private void populate(final Map map) {
        HashMap<Point, Location> locations = map.getContents();

        for (final LocationType type : LocationType.values()) {
            locations.get(new Point(type.x, type.y)).setType(type);
        }
    }

}
