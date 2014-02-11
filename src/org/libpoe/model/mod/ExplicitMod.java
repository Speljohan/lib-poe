package org.libpoe.model.mod;

import org.libpoe.model.property.Property;

/**
 * User: Johan
 * Date: 2013-12-02
 * Time: 09:16
 */
public class ExplicitMod {

    private Property property;

    public ExplicitMod(Property property) {
        this.property = property;
    }

    @Override
    public String toString() {
        return "ExplicitMod{" +
                "property=" + property +
                '}';
    }
}
