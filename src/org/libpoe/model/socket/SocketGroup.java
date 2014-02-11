package org.libpoe.model.socket;

import java.util.ArrayList;

/**
 * Created by Johan on 2014-02-11.
 */
public class SocketGroup {
    private ArrayList<Socket> sockets;
    private int group;

    public SocketGroup() {
        this.sockets = new ArrayList<Socket>();
    }

    public int getGroup() {
        return group;
    }

    public int getLinkCount() {
        return sockets.size();
    }

    public ArrayList<Socket> getSockets() {
        return sockets;
    }
}
