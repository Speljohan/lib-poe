package org.libpoe.model.property;

/**
 * User: Johan
 * Date: 2013-12-02
 * Time: 10:07
 */
public class PercentageProperty extends Property {

    private int value;

    public PercentageProperty(String name, int displayMode, boolean augmented, int value) {
        super(name, displayMode, augmented);
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "PercentageProperty{" +
                "name='" + getName() + "'" +
                ", value=" + value +
                "} ";
    }
}
