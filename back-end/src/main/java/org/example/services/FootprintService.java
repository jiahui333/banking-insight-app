package org.example.services;

import org.example.models.Category;
import org.example.models.Footprint;
import org.example.models.Transaction;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface FootprintService {
    BigDecimal saveAndReturnFootprintPerTrans(Transaction transaction);
    Map<String, BigDecimal> calculateCategoryFootprintMap();
}
