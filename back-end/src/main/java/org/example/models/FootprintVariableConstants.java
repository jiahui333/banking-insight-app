package org.example.models;

import java.util.HashMap;
import java.util.Map;

public class FootprintVariableConstants {
    public static final Long GROCERY = 802L;
    public static final Long ENERGY = 604L;
    public static final Long RESTAURANT = 802L;

    public static Map<String, Long> getFootprintVariableConstants () {
        Map<String, Long> footprintVariables = new HashMap<>();
        footprintVariables.put("Grocery", GROCERY);
        footprintVariables.put("Energy", ENERGY);
        footprintVariables.put("Restaurant", RESTAURANT);
        return footprintVariables;
    }
}
