package org.libpoe.model.property;

/**
 * User: Johan
 * Date: 2013-12-02
 * Time: 09:12
 */
public class Property {

    private String name;
    private int displayMode;
    private boolean augmented;

    public Property(String name, int displayMode, boolean augmented) {
        this.name = name;
        this.displayMode = displayMode;
        this.augmented = augmented;
    }

    public String getName() {
        return name;
    }

    public int getDisplayMode() {
        return displayMode;
    }

    public boolean isAugmented() {
        return augmented;
    }

    @Override
    public String toString() {
        return "Property{" +
                "name='" + name + '\'' +
                ", displayMode=" + displayMode +
                ", augmented=" + augmented +
                '}';
    }
}
