package com.google.gson.typeadapters;

import com.google.gson.JsonElement;

/**
 * Created by Johan on 2014-02-13.
 */
public abstract class RuntimeTypeAdapterPredicate {

    public abstract String process(JsonElement element);

}
