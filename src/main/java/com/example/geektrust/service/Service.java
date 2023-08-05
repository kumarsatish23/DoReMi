package com.example.geektrust.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Service {
    private Subscription data;
    private Renewaldate renewaldateCalculator;
    private Calculation renewalAmountCalculator;

    public Service() {
        this.data = new Subscription();
        this.renewaldateCalculator = new Renewaldate();
        this.renewalAmountCalculator = new Calculation();
    }

    public void DoReMi(List<String> inputs) {
        for (String i : inputs) {
            processInput(i);
        }
    }

    private void processInput(String input) {
        if (input.contains("START_SUBSCRIPTION")) {
            LocalDate startDate = parseDate(input.split(" ")[1]);
            if (startDate == null) {
                System.out.println("ADD_SUBSCRIPTION_FAILED INVALID_DATE");
                return;
            }
            data.setStartDate(startDate);
        } else if (input.contains("MUSIC")) {
            data.setMusicPlan(input.split(" ")[2]);
        } else if (input.contains("VIDEO")) {
            data.setVideoPlan(input.split(" ")[2]);
        } else if (input.contains("PODCAST")) {
            data.setPodcastPlan(input.split(" ")[2]);
        } else if (input.contains("TOPUP")) {
            Topup topup = new Topup(input.split(" ")[1], Integer.parseInt(input.split(" ")[2]));
            data.setTopup(topup);
        } else if (input.contains("PRINT_RENEWAL_DETAILS")) {
            printRenewalDetails(data, renewaldateCalculator, renewalAmountCalculator);
        }
    }

    private void printRenewalDetails(Subscription data, Renewaldate renewaldateCalculator, Calculation renewalAmountCalculator) {
        Integer renewalAmount = renewalAmountCalculator.renewalAmount(data);
        Renewaldate.RenewalDates renewalDates = renewaldateCalculator.calculateRenewalDates(data);

        StringBuilder output = new StringBuilder();

        if (renewalDates.getMusicRenewalDate() != null) {
            output.append("RENEWAL_REMINDER MUSIC ").append(renewalDates.getMusicRenewalDate()).append("\n");
        }

        if (renewalDates.getVideoRenewalDate() != null) {
            output.append("RENEWAL_REMINDER VIDEO ").append(renewalDates.getVideoRenewalDate()).append("\n");
        }

        if (renewalDates.getPodcastRenewalDate() != null) {
            output.append("RENEWAL_REMINDER PODCAST ").append(renewalDates.getPodcastRenewalDate()).append("\n");
        }

        if (renewalAmount != null) {
            output.append("RENEWAL_AMOUNT ").append(renewalAmount);
        }

        System.out.println(output.toString());
    }

    private static LocalDate parseDate(String dateString) {
        try {
            return LocalDate.parse(dateString, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        } catch (java.time.format.DateTimeParseException e) {
            return null;
        }
    }
}
