package org.libpoe.model.socket;

/**
 * Created by Johan on 2014-02-11.
 */
public class Socket {
    private int group;
    private Attribute attribute;

    public Socket(int group, Attribute attribute) {
        this.group = group;
        this.attribute = attribute;
    }

    public int getGroup() {
        return group;
    }

    public Attribute getAttribute() {
        return attribute;
    }

}
