package org.libpoe.model.socket;

/**
 * Created by Johan on 2014-02-11.
 */
public enum Attribute {
    STRENGTH("S"),
    DEXTERITY("D"),
    INTELLIGENCE("I");

    String id;

    Attribute(String id) {
        this.id = id;
    }

    public static Attribute forId(String id) {
        for (Attribute a : Attribute.values()) {
            if (a.id.equals(id)) {
                return a;
            }
        }
        return null;
    }
}
