package org.example.services;

import org.example.models.Category;
import org.example.models.Footprint;
import org.example.models.FootprintVariableConstants;
import org.example.models.Transaction;
import org.example.repositories.FootprintRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class FootprintServiceImpl implements FootprintService {

   Long footprintVariable;

   @Autowired
   private FootprintRepo footprintRepo;

   @Autowired
   private Map<String, Long> footprintVariableConstantsMap;

    @Override
    public BigDecimal saveAndReturnFootprintPerTrans(Transaction transaction) {
        for (Map.Entry<String, Long> entry : footprintVariableConstantsMap.entrySet()) {
            if (Objects.equals(entry.getKey(), transaction.getCategory().getName())) {
                footprintVariable = entry.getValue();
            }
        }
        BigDecimal footprintAmount = transaction.getAmount().multiply(BigDecimal.valueOf(footprintVariable));
        Footprint footprint = new Footprint();
        footprint.setAmount(footprintAmount);
        footprint.setCategory(transaction.getCategory());
        footprintRepo.save(footprint);
        return footprintAmount;
    }

    @Override
    public Map<String, BigDecimal> calculateCategoryFootprintMap() {
        List<Footprint> footprintList = footprintRepo.findAll();
        Map<String, BigDecimal> categoryAmountMap = new HashMap<>();

        for (Footprint footprint : footprintList) {
            String categoryName = footprint.getCategory().getName();
            BigDecimal amount = footprint.getAmount();

            if (categoryAmountMap.containsKey(categoryName)) {
                categoryAmountMap.put(categoryName, categoryAmountMap.get(categoryName).add(amount));
            } else {
                categoryAmountMap.put(categoryName, amount);
            }
        }

        return categoryAmountMap;
    }
}
