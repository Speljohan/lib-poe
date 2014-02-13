package org.libpoe.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import com.google.gson.typeadapters.RuntimeTypeAdapterFactory;
import org.libpoe.model.StashTab;
import org.libpoe.model.item.*;
import org.libpoe.model.mod.ExplicitMod;
import org.libpoe.model.mod.ImplicitMod;
import org.libpoe.model.property.Property;
import org.libpoe.model.socket.Sockets;
import org.libpoe.net.AuthInfo;
import org.libpoe.net.DataReader;
import org.libpoe.serial.*;

import java.io.FileReader;

/**
 * Created by Johan on 2014-02-11.
 */
public class StashLoader {

    // TODO: Flesh out class.

    /**
     * Reads a stash tab from file
     *
     * @param fileName The file containing stash info
     * @return Requested stash tab
     * @throws Exception
     */
    public static StashTab fromFile(String fileName) throws Exception {

        RuntimeTypeAdapterFactory<Item> itemAdapter = RuntimeTypeAdapterFactory.of(Item.class, new ItemTypePredicate())
                .registerSubtype(Currency.class)
                .registerSubtype(Equipment.class)
                .registerSubtype(Gem.class)
                .registerSubtype(Map.class);

        Gson gson = new GsonBuilder()
                .enableComplexMapKeySerialization()
                .registerTypeAdapterFactory(itemAdapter)
                .registerTypeAdapter(Property.class, new PropertyDeserializer())
                .registerTypeAdapter(Sockets.class, new SocketDeserializer())
                .registerTypeAdapter(ExplicitMod.class, new ExplicitModDeserializer())
                .registerTypeAdapter(ImplicitMod.class, new ImplicitModDeserializer()).create();

        return gson.fromJson(new JsonReader(new FileReader(fileName)), StashTab.class);
    }

    /**
     * Retrieves a stash tab from desired account
     *
     * @param info   Authentication info
     * @param league Target league
     * @param tabId  Index of the stash tab to retrieve
     * @return Requested tab stash
     */
    public static StashTab fromAccount(AuthInfo info, League league, int tabId) {
        DataReader reader = new DataReader(info);
        if (reader.authenticate()) {
            try {
                return reader.getStashTab(league.getId(), tabId);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
