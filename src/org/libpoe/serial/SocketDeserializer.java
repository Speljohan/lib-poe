package org.libpoe.serial;

import com.google.gson.*;
import org.libpoe.model.socket.Attribute;
import org.libpoe.model.socket.Socket;
import org.libpoe.model.socket.SocketGroup;
import org.libpoe.model.socket.Sockets;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Johan on 2014-02-11.
 */
public class SocketDeserializer implements JsonDeserializer<Sockets> {

    @Override
    public Sockets deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        if (jsonElement.isJsonArray()) {
            JsonArray sockets = jsonElement.getAsJsonArray();
            HashMap<Integer, SocketGroup> groups = new HashMap<Integer, SocketGroup>();
            for (JsonElement e : sockets) {
                JsonObject obj = e.getAsJsonObject();
                int group = obj.get("group").getAsInt();
                Attribute attribute = Attribute.forId(obj.get("attr").getAsString());
                Socket s = new Socket(group, attribute);
                if (groups.get(group) == null) {
                    groups.put(group, new SocketGroup());
                }
                groups.get(group).getSockets().add(s);
            }
            return new Sockets(new ArrayList<SocketGroup>(groups.values()));
        }
        return null;
    }
}
