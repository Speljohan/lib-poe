package org.libpoe.util;

/**
 * Created by Johan on 2014-02-12.
 */
public enum League {
    STANDARD("Standard"),
    HARDCORE("Hardcore"),
    DOMINATION("Domination"),
    NEMESIS("Nemesis");

    private String id;

    League(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
