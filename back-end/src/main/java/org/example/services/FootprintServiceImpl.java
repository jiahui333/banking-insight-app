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

    @Override
    public BigDecimal saveAndReturnFootprintPerTrans(Transaction transaction) {
        Map<String, Long> footprintVariables= FootprintVariableConstants.getFootprintVariableConstants();
        for (Map.Entry<String, Long> entry : footprintVariables.entrySet()) {
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
    public BigDecimal calculateFootprintPerCategory(Category category) {
        List<Footprint> footprints = footprintRepo.findAllByCategory(category);
        return footprints.stream()
                .map(Footprint::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
