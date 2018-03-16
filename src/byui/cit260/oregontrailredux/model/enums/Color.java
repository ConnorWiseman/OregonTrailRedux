package byui.cit260.oregontrailredux.model.enums;

public enum Color {
    DEFAULT("\u001B[0m"),
    BLACK("\u001B[30m"),
    RED("\u001B[31m"),
    GREEN("\u001B[32m"),
    YELLOW("\u001B[33m"),
    BLUE("\u001B[34m"),
    PURPLE("\u001B[35m"),
    CYAN("\u001B[36m"),
    WHITE("\u001B[37m");
    
    final public String code;
    final public String reset;
    
    Color(final String code) {
        this.code = code;
        this.reset = "\u001B[0m";
    }
}