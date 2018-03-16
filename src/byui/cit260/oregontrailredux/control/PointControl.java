package byui.cit260.oregontrailredux.control;

import byui.cit260.oregontrailredux.model.Point;

public final class PointControl {

    private PointControl() {
    }

    public static double distanceBetween(final Point p1, final Point p2) {
        final int x1 = p1.getX();
        final int y1 = p1.getY();
        final int x2 = p2.getX();
        final int y2 = p2.getY();

        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }
}
