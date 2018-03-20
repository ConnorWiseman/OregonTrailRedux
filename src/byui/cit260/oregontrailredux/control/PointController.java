package byui.cit260.oregontrailredux.control;

import byui.cit260.oregontrailredux.model.Point;

public final class PointController implements ControllerInterface {
    
    private final Point point;

    public PointController() {
        this.point = new Point();
    }
    
    public PointController(final Point point) {
        this.point = point;
    }

    public static double distanceBetween(final Point p1, final Point p2) {
        final int x1 = p1.getX();
        final int y1 = p1.getY();
        final int x2 = p2.getX();
        final int y2 = p2.getY();

        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }
    
    @Override
    public Point create() {
        return new Point();
    }
    
    public double distanceTo(final Point p2) {
        return PointController.distanceBetween(this.point, p2);
    }
    
    @Override
    public Point getResource() {
        return this.point;
    }
}
