package org.libpoe.serial;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import org.libpoe.model.mod.ExplicitMod;
import org.libpoe.model.mod.ImplicitMod;
import org.libpoe.model.property.DecProperty;
import org.libpoe.model.property.IntProperty;
import org.libpoe.model.property.MinMaxProperty;
import org.libpoe.model.property.PercentageProperty;
import org.libpoe.util.Constants;

import java.lang.reflect.Type;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * User: Johan
 * Date: 2013-12-02
 * Time: 10:24
 */
public class ImplicitModDeserializer implements JsonDeserializer<ImplicitMod> {

    @Override
    public ImplicitMod deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        for (String s : Constants.ESCAPED_MODS) {
            Pattern p = Pattern.compile(s);
            Matcher m = p.matcher(jsonElement.getAsString());
            while (m.find()) {
                if (m.groupCount() == 1) {
                    if (jsonElement.getAsString().contains("%")) {
                        return new ImplicitMod(new PercentageProperty(jsonElement.getAsString(), 1, true, Integer.parseInt(m.group(1))));
                    } else if (jsonElement.getAsString().contains(".")) {
                        return new ImplicitMod(new DecProperty(jsonElement.getAsString(), 1, true, Double.parseDouble(m.group(1))));
                    } else {
                        return new ImplicitMod(new IntProperty(jsonElement.getAsString(), 1, true, Integer.parseInt(m.group(1))));
                    }
                } else if (m.groupCount() == 2) {
                    return new ImplicitMod(new MinMaxProperty(jsonElement.getAsString(), 1, true, Integer.parseInt(m.group(1)), Integer.parseInt(m.group(2))));
                }
            }
        }
    return null;
    }
}
