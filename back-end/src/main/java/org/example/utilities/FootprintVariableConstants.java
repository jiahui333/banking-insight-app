package org.example.utilities;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;
@Configuration
public class FootprintVariableConstants {
    public static final Long GROCERY = 802L;
    public static final Long ENERGY = 604L;
    public static final Long RESTAURANT = 802L;
    public static final Long CAFE= 802L;
    public static final Long CLOTHES = 1143L;
    public static final Long PHARMACY = 105L;
    public static final Long PUBLICTRANSPORT = 105L;

    @Bean
    public Map<String, Long> footprintVariableConstantsMap () {
        Map<String, Long> footprintVariables = new HashMap<>();
        footprintVariables.put("Income", 0L);
        footprintVariables.put("Gift", 0L);
        footprintVariables.put("Refund", 0L);
        footprintVariables.put("Grocery", GROCERY);
        footprintVariables.put("Energy", ENERGY);
        footprintVariables.put("Restaurant", RESTAURANT);
        footprintVariables.put("Cafe", CAFE);
        footprintVariables.put("Clothes", CLOTHES);
        footprintVariables.put("Pharmacy", PHARMACY);
        footprintVariables.put("Public transport", PUBLICTRANSPORT);
        return footprintVariables;
    }
}
