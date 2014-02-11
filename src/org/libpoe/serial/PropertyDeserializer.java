package org.libpoe.serial;

import com.google.gson.*;
import org.libpoe.model.property.*;

import java.lang.reflect.Type;

/**
 * User: Johan
 * Date: 2013-12-02
 * Time: 09:17
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
            boolean augmented = base.get(1).getAsInt() != 0;

            if (val.contains("-")) { // Min/Max
                int minValue = Integer.valueOf(val.split("-")[0]);
                int maxValue = Integer.valueOf(val.split("-")[1]);
                return new MinMaxProperty(name, displayMode, augmented, minValue, maxValue);
            } else if (val.contains("%")) { // Percentage
                int value = Integer.valueOf(base.get(0).getAsString().replaceAll("[^\\d]", ""));
                return new PercentageProperty(name, displayMode, augmented, value);
            } else if (val.contains(".")) { // Fraction
                double value = base.get(0).getAsDouble();
                return new DecProperty(name, displayMode, augmented, value);
            } else { // Flat
                int value = base.get(0).getAsInt();
                return new IntProperty(name, displayMode, augmented, value);
            }
        } else {
            return new Property(name, displayMode, false);
        }
    }
}
