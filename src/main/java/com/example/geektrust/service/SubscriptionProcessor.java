package com.example.geektrust.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubscriptionProcessor {
    public void processSubscriptions(List<String> inputs) {
        List<String> subscription = new ArrayList<>();
        Service subscriptionService = new Service();
        boolean startSubscriptionEncountered = false;

        for (String str : inputs) {
            if (str.contains("START_SUBSCRIPTION")) {
                processSubscription(subscriptionService, subscription, startSubscriptionEncountered);
                subscription.clear();
                startSubscriptionEncountered = true;
            }
            subscription.add(str);
        }

        processSubscription(subscriptionService, subscription, startSubscriptionEncountered);
    }

    private void processSubscription(Service subscriptionService, List<String> subscription, boolean startSubscriptionEncountered) {
        if (!subscription.isEmpty()) {
            if (!hasDuplicates(subscription)) {
                if (startSubscriptionEncountered || !containsPrintRenewalDetails(subscription)) {
                    if (!hasMultipleTopups(subscription)) {
                        subscriptionService.DoReMi(subscription);
                    } else {
                        System.out.println("ADD_TOPUP_FAILED DUPLICATE_TOPUP");
                    }
                } else {
                    System.out.println("SUBSCRIPTIONS_NOT_FOUND");
                }
            } else {
                System.out.println("ADD_SUBSCRIPTION_FAILED DUPLICATE_CATEGORY");
            }
        }
    }

    private boolean containsPrintRenewalDetails(List<String> subscription) {
        for (String str : subscription) {
            if (str.contains("PRINT_RENEWAL_DETAILS")) {
                return true;
            }
        }
        return false;
    }

    private boolean hasMultipleTopups(List<String> subscription) {
        int topupCount = 0;

        for (String str : subscription) {
            if (str.contains("ADD_TOPUP")) {
                topupCount++;
                if (topupCount > 1) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean hasDuplicates(List<String> subscription) {
        Map<String, Integer> planCount = new HashMap<>();

        for (String str : subscription) {
            if (str.contains("ADD_SUBSCRIPTION")) {
                String planType = str.split(" ")[1];
                String planName = str.split(" ")[2];

                String key = planType + ":" + planName;
                planCount.put(key, planCount.getOrDefault(key, 0) + 1);
                if (planCount.get(key) > 1) {
                    return true;
                }
            }
        }

        return false;
    }
}