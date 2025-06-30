package com.jpmc.midascore.services;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Incentive {
    @JsonProperty("amount")
    private float amount;

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
} 