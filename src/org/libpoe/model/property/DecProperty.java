package org.libpoe.model.property;

/**
 * User: Johan
 * Date: 2013-12-02
 * Time: 10:11
 */
public class DecProperty extends Property {

    private double value;

    public DecProperty(String name, int displayMode, boolean augmented, double value) {
        super(name, displayMode, augmented);
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "DecProperty{" +
                "name='" + getName() + "'" +
                ", value=" + value +
                "} ";
    }
}
