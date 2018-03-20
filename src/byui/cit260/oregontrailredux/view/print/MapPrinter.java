package byui.cit260.oregontrailredux.view.print;

import byui.cit260.oregontrailredux.model.Location;
import byui.cit260.oregontrailredux.model.Map;
import byui.cit260.oregontrailredux.model.Point;
import byui.cit260.oregontrailredux.model.enums.LocationType;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class MapPrinter extends AbstractPrinter {

    private static final char H = '-';
    private static final char V = '|';

    private MapPrinter() {
    }

    private static String[] getPrintableRows(final Map map) {
        final List<String> tiles = map.getContents()
                .values()
                .stream()
                .map((final Location location) -> {
                    final LocationType type = location.getType();
                    return " " + String.valueOf(type.tile.background.code)
                            + type.tile.color.code
                            + type.tile.symbol
                            + type.tile.color.reset
                            + type.tile.background.reset;
                })
                .collect(Collectors.toList());

        final int numRows = map.getNumRows();
        final int numColumns = map.getNumColumns();

        final String[] rows = new String[numRows];
        final AtomicInteger offset = new AtomicInteger();

        IntStream.range(0, numRows).forEach((final int row) -> {
            final String s = String.valueOf(row);
            rows[row] = s + AbstractPrinter.padString(2 - s.length(), ' ')
                     + " " + String.join("  ",
                    tiles.subList(offset.get(), offset.addAndGet(numColumns)))
                    + "  ";
        });

        return rows;
    }

    private static void printCurrentLocation(final Map map, final int max) {
        final Point position = map.getCurrentPosition();
        final Location location = map.getContents().get(position);

        AbstractPrinter.printSeparator(max, H);
        AbstractPrinter.printLine("Current location: "
                + location.getType().name
                + " ("
                + position.getX()
                + ", "
                + position.getY()
                + ")", max, V);
        AbstractPrinter.printSeparator(max, H);
    }

    private static void printHeader(final Map map, final int max) {
        AbstractPrinter.printBlankLine();
        AbstractPrinter.printSeparator(max, H);
        AbstractPrinter.printLine("Game Map", max, V);
        AbstractPrinter.printSeparator(max, H);

        final String columns = IntStream.range(0, map.getNumColumns())
                .mapToObj(Integer::toString)
                .map((String s) -> {
                    return s + AbstractPrinter.padString(3 - s.length(), ' ');
                })
                .collect(Collectors.joining(" "));

        AbstractPrinter.printLine("    " + columns, max, V);
    }

    private static void printRows(final Map map, final int max) {
        final String[] rows = MapPrinter.getPrintableRows(map);

        for (final String row : rows) {
            AbstractPrinter.printLine(row, max, V);
        }
    }

    public static void print(final Map map) {
        final int max = (map.getNumColumns() * 4) + 3;

        MapPrinter.printHeader(map, max);
        MapPrinter.printRows(map, max);
        MapPrinter.printCurrentLocation(map, max);
    }
}
