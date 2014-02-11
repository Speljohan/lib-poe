package org.libpoe.model.mod;

import org.libpoe.model.property.Property;

/**
 * Created by Johan on 2014-02-11.
 */
public class ImplicitMod {

    private Property property;

    public ImplicitMod(Property property) {
        this.property = property;
    }

    @Override
    public String toString() {
        return "ImplicitMod{" +
                "property=" + property +
                '}';
    }
}
