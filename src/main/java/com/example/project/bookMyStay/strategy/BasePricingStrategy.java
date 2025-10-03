package com.example.project.bookMyStay.strategy;

import java.math.BigDecimal;

import com.example.project.bookMyStay.entity.Inventory;

public class BasePricingStrategy implements PricingStrategy{
    @Override
    public BigDecimal calculatePrice(Inventory inventory) {
        return inventory.getRoom().getBasePrice();
    }
}
