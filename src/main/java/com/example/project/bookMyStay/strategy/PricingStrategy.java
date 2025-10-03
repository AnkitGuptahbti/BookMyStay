package com.example.project.bookMyStay.strategy;

import java.math.BigDecimal;

import com.example.project.bookMyStay.entity.Inventory;
public interface PricingStrategy {

    BigDecimal calculatePrice(Inventory inventory);
}
