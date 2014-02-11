package org.libpoe.model.property;

/**
 * User: Johan
 * Date: 2013-12-02
 * Time: 09:59
 */
public class MinMaxProperty extends Property {

    private int minValue, maxValue;

    public MinMaxProperty(String name, int displayMode, boolean augmented, int minValue, int maxValue) {
        super(name, displayMode, augmented);
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    public int getMinValue() {
        return minValue;
    }

    public int getMaxValue() {
        return maxValue;
    }

    @Override
    public String toString() {
        return "MinMaxProperty{" +
                "name='" + getName() + "'" +
                ", minValue=" + minValue +
                ", maxValue=" + maxValue +
                "} ";
    }
}
