package org.libpoe.model.property;

import org.libpoe.util.AugmentColour;

/**
 * User: Johan
 * Date: 2013-12-02
 * Time: 09:12
 */
public class Property {

    private String name;
    private int displayMode;
    private AugmentColour colour;

    public Property(String name, int displayMode, AugmentColour colour) {
        this.name = name;
        this.displayMode = displayMode;
        this.colour = colour;
    }

    public String getName() {
        return name;
    }

    public int getDisplayMode() {
        return displayMode;
    }

    public AugmentColour getAugmentColour() {
        return colour;
    }

    @Override
    public String toString() {
        return "Property{" +
                "name='" + name + '\'' +
                ", displayMode=" + displayMode +
                ", augmentColour=" + colour +
                '}';
    }
}
