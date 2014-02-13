package org.libpoe.util;

/**
 * Created by Johan on 2014-02-13.
 */
public enum AugmentColour {

    WHITE(0),
    DEFAULT_AUGMENT(1), // TODO: Better name
    RED(4),
    BLUE(5),
    YELLOW(6);
    // TODO: Add potentially missing ones?

    private int id;

    AugmentColour(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static AugmentColour forId(int id) {
        for (AugmentColour colour : AugmentColour.values()) {
            if (colour.getId() == id) {
                return colour;
            }
        }
        return null;
    }

}
