package byui.cit260.oregontrailredux.model.enums;

/**
 *
 * @author Connor
 */
public enum Gender {

    NONE('N', "Unspecified"),
    FEMALE('F', "Female"),
    MALE('M', "Male");

    public final char symbol;
    public final String descriptor;

    Gender(final char symbol, final String descriptor) {
        this.symbol = symbol;
        this.descriptor = descriptor;
    }
}
