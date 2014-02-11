package org.libpoe;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import org.libpoe.model.mod.ExplicitMod;
import org.libpoe.model.mod.ImplicitMod;
import org.libpoe.model.property.Property;
import org.libpoe.model.StashTab;
import org.libpoe.model.socket.Sockets;
import org.libpoe.serial.ExplicitModDeserializer;
import org.libpoe.serial.ImplicitModDeserializer;
import org.libpoe.serial.PropertyDeserializer;
import org.libpoe.serial.SocketDeserializer;

import java.io.FileReader;

/**
 * User: Johan
 * Date: 2013-11-29
 * Time: 19:39
 * A simple test class for verifying functionality and ensuring that everything works, this is modified as new things require testing.
 */
public class Test {

    public static void main(String[] args) {
        Gson gson = new GsonBuilder()
                .enableComplexMapKeySerialization()
                .registerTypeAdapter(Property.class, new PropertyDeserializer())
                .registerTypeAdapter(Sockets.class, new SocketDeserializer())
                .registerTypeAdapter(ExplicitMod.class, new ExplicitModDeserializer())
                .registerTypeAdapter(ImplicitMod.class, new ImplicitModDeserializer()).create();

        try {
            StashTab tab = gson.fromJson(new JsonReader(new FileReader("test.json")), StashTab.class);
            System.out.println(tab.getItems()[3]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
