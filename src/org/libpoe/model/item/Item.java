package org.libpoe.model.item;

import org.libpoe.model.socket.Sockets;
import org.libpoe.model.mod.ExplicitMod;
import org.libpoe.model.mod.ImplicitMod;
import org.libpoe.model.property.Property;

import java.util.Arrays;

/**
 * User: Johan
 * Date: 2013-11-29
 * Time: 19:40
 */
public class Item {
    private boolean verified, support, identified;
    private int w, h, x, y, frameType;
    private String icon, league, name, typeLine, inventoryId;
    private Property[] properties, requirements;
    private ExplicitMod[] explicitMods;
    private ImplicitMod[] implicitMods;
    private Sockets sockets;

    public boolean isVerified() {
        return verified;
    }

    public boolean isSupport() {
        return support;
    }

    public boolean isIdentified() {
        return identified;
    }

    public int getW() {
        return w;
    }

    public int getH() {
        return h;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getFrameType() {
        return frameType;
    }

    public String getIcon() {
        return icon;
    }

    public String getLeague() {
        return league;
    }

    public String getName() {
        return name;
    }

    public String getTypeLine() {
        return typeLine;
    }

    public String getInventoryId() {
        return inventoryId;
    }

    public Property[] getProperties() {
        return properties;
    }

    public Property[] getRequirements() {
        return requirements;
    }

    public ExplicitMod[] getExplicitMods() {
        return explicitMods;
    }

    public ImplicitMod[] getImplicitMods() { return implicitMods; }

    @Override
    public String toString() {
        return "Item{" +
                "verified=" + verified +
                ", support=" + support +
                ", identified=" + identified +
                ", w=" + w +
                ", h=" + h +
                ", x=" + x +
                ", y=" + y +
                ", frameType=" + frameType +
                ", icon='" + icon + '\'' +
                ", league='" + league + '\'' +
                ", sockets='" + sockets +
                ", name='" + name + '\'' +
                ", typeLine='" + typeLine + '\'' +
                ", inventoryId='" + inventoryId + '\'' +
                ", properties=" + Arrays.toString(properties) +
                ", requirements=" + Arrays.toString(requirements) +
                ", implicitMods=" + Arrays.toString(implicitMods) +
                ", explicitMods=" + Arrays.toString(explicitMods) +
                '}';
    }
}
