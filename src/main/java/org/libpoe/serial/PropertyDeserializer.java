package org.libpoe.serial;

import com.google.gson.*;
import org.libpoe.model.property.*;
import org.libpoe.util.AugmentColour;

import java.lang.reflect.Type;

/**
 * User: Johan
 * Date: 2013-12-02
 * Time: 09:17
 * TODO: Refactor this class
 */
public class PropertyDeserializer implements JsonDeserializer<Property> {

    @Override
    public Property deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject o = jsonElement.getAsJsonObject();

        String name = o.get("name").getAsString();
        int displayMode = o.get("displayMode").getAsInt();

        JsonArray values = o.getAsJsonArray("values");

        if (values.size() == 1) {
            JsonArray base = values.get(0).getAsJsonArray();

            String val = base.get(0).getAsString();
            int augmentColour = base.get(1).getAsInt();

            if (val.contains("-")) { // Min/Max
                int minValue = Integer.valueOf(val.split("-")[0]);
                int maxValue = Integer.valueOf(val.split("-")[1]);
                return new MinMaxProperty(name, displayMode, AugmentColour.forId(augmentColour), minValue, maxValue);
            } else if (val.contains("%")) { // Percentage
                int value = Integer.valueOf(base.get(0).getAsString().replaceAll("[^\\d]", ""));
                return new PercentageProperty(name, displayMode, AugmentColour.forId(augmentColour), value);
            } else if (val.contains(".")) { // Fraction
                double value = base.get(0).getAsDouble(); // TODO: Does not work on gems. Rewrite of this entire awful class recommended.
                return new DecProperty(name, displayMode, AugmentColour.forId(augmentColour), value);
            } else { // Flat
                int value = base.get(0).getAsInt();
                return new IntProperty(name, displayMode, AugmentColour.forId(augmentColour), value);
            }
        } else {
            return new Property(name, displayMode, AugmentColour.WHITE);
        }
    }
}
