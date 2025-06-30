package com.jpmc.midascore.services;

import com.jpmc.midascore.foundation.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class IncentiveService {
    private final RestTemplate restTemplate;
    private final String incentiveApiUrl = "http://localhost:8080/incentive";

    @Autowired
    public IncentiveService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public float getIncentive(Transaction transaction) {
        try {
            Incentive incentive = restTemplate.postForObject(incentiveApiUrl, transaction, Incentive.class);
            return incentive != null ? incentive.getAmount() : 0;
        } catch (Exception e) {
            // Log the exception and return 0
            return 0;
        }
    }
} 