package org.libpoe.serial;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.typeadapters.RuntimeTypeAdapterPredicate;

/**
 * Created by Johan on 2014-02-13.
 */
public class ItemTypePredicate extends RuntimeTypeAdapterPredicate {

    @Override
    public String process(JsonElement element) {
        JsonObject obj = element.getAsJsonObject();
        int frameType = obj.get("frameType").getAsInt();

        switch(frameType) {
            case 4: return "Gem";
            case 5: return "Currency";
        }
        if (obj.get("typeLine").getAsString().contains("Map")
                && obj.get("descrText").getAsString() != null
                && obj.get("descrText").getAsString().contains("Travel to this Map")) {
            return "Map";
        }

        return "Equipment";
    }
}
