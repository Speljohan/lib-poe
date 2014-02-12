package org.libpoe.model.socket;

import java.util.ArrayList;

/**
 * User: Johan
 * Date: 2013-12-02
 * Time: 10:40
 */
public class Sockets {

    private ArrayList<SocketGroup> groups;

    public Sockets(ArrayList<SocketGroup> groups) {
        this.groups = groups;
    }

    public ArrayList<SocketGroup> getGroups() {
        return groups;
    }

    public int getSocketCount() {
        int out = 0;
        for (SocketGroup g : groups) {
            out += g.getLinkCount();
        }
        return out;
    }

    @Override
    public String toString() {
        return "Sockets{" +
                "count=" + getSocketCount() +
                '}';
    }
}
