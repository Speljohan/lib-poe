package org.libpoe.model.property;

/**
 * User: Johan
 * Date: 2013-12-02
 * Time: 10:05
 */
public class IntProperty extends Property {

    private int value;

    public IntProperty(String name, int displayMode, boolean augmented, int value) {
        super(name, displayMode, augmented);
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "IntProperty{" +
                "name='" + getName() + "'" +
                ", value=" + value +
                "} ";
    }
}
