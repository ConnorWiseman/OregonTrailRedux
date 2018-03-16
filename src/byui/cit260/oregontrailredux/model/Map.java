package byui.cit260.oregontrailredux.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Objects;

/**
 * An ArrayList of Locations.
 *
 * @author Connor
 */
public final class Map implements Serializable {

    private int numColumns;
    private int numRows;
    private HashMap<Point, Location> contents;
    private Point currentPosition;

    /**
     * The default constructor. Initializes the Map contents and the
     * currentPosition of the user.
     */
    public Map() {
        this.numColumns = 0;
        this.numRows = 0;
        this.contents = new LinkedHashMap<>();
        this.currentPosition = new Point();
    }

    public int getNumColumns() {
        return numColumns;
    }

    public void setNumColumns(int numColumns) {
        this.numColumns = numColumns;
    }

    public int getNumRows() {
        return numRows;
    }

    public void setNumRows(int numRows) {
        this.numRows = numRows;
    }

    /**
     *
     * @return
     */
    public HashMap<Point, Location> getContents() {
        return contents;
    }

    /**
     *
     * @param contents
     */
    public void setContents(final HashMap<Point, Location> contents) {
        this.contents = contents;
    }

    public Point getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(final Point currentPosition) {
        this.currentPosition = currentPosition;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + this.numColumns;
        hash = 71 * hash + this.numRows;
        hash = 71 * hash + Objects.hashCode(this.contents);
        hash = 71 * hash + Objects.hashCode(this.currentPosition);
        return hash;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Map other = (Map) obj;
        if (this.numColumns != other.numColumns) {
            return false;
        }
        if (this.numRows != other.numRows) {
            return false;
        }
        if (!Objects.equals(this.contents, other.contents)) {
            return false;
        }
        return Objects.equals(this.currentPosition, other.currentPosition);
    }

    @Override
    public String toString() {
        return "Map{" + "numColumns=" + numColumns + ", numRows=" + numRows + ", contents=" + contents + ", currentPosition=" + currentPosition + '}';
    }
}
