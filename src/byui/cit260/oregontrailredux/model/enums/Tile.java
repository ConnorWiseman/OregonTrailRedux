
package byui.cit260.oregontrailredux.model.enums;

public enum Tile {
    
    EMPTY('.', Color.DEFAULT, BackgroundColor.BLACK),
    CITY('^', Color.BLUE, BackgroundColor.WHITE);
    
    public final char symbol;
    public final Color color;
    public final BackgroundColor background;

    Tile(final char symbol, final Color color,
        final BackgroundColor background) {
        this.symbol = symbol;
        this.color = color;
        this.background = background;
    }
}
