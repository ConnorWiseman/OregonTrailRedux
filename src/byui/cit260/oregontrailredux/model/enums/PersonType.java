package byui.cit260.oregontrailredux.model.enums;

public enum PersonType {
    NONE(""),
    LEADER("team leader"),
    COMPANION("companion");

    public final String label;

    PersonType(final String label) {
        this.label = label;
    }
}
