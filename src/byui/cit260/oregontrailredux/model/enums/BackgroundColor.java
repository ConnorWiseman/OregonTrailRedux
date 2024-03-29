package byui.cit260.oregontrailredux.model.enums;

public enum BackgroundColor {
    DEFAULT("\u001B[0m"),
    BLACK("\u001B[40m"),
    RED("\u001B[41m"),
    GREEN("\u001B[42m"),
    YELLOW("\u001B[43m"),
    BLUE("\u001B[44m"),
    PURPLE("\u001B[45m"),
    CYAN("\u001B[46m"),
    WHITE("\u001B[47m");
    
    final public String code;
    final public String reset;
    
    BackgroundColor(final String code) {
        this.code = code;
        this.reset = "\u001B[0m";
    }
}