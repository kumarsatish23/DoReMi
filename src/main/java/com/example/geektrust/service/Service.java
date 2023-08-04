package com.example.geektrust.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Service {
    public void DoReMi(List<String> inputs) {
        Subscription data = new Subscription();
        Renewaldate renewaldateCalculator = new Renewaldate();
        Calculation renewalAmountCalculator = new Calculation();

        for (String i : inputs) {
            if (i.contains("START_SUBSCRIPTION")) {
                data.setStartDate(parseDate(i.split(" ")[1]));
            } else if (i.contains("MUSIC")) {
                data.setMusicPlan(i.split(" ")[2]);
            } else if (i.contains("VIDEO")) {
                data.setVideoPlan(i.split(" ")[2]);
            } else if (i.contains("PODCAST")) {
                data.setPodcastPlan(i.split(" ")[2]);
            } else if (i.contains("TOPUP")) {
                Topup topup = new Topup(i.split(" ")[1], Integer.parseInt(i.split(" ")[2]));
                data.setTopup(topup);
            } else if (i.contains("PRINT_RENEWAL_DETAILS")) {
                printRenewalDetails(data, renewaldateCalculator, renewalAmountCalculator);
            }
        }
    }

    private void printRenewalDetails(Subscription data, Renewaldate renewaldateCalculator, Calculation renewalAmountCalculator) {
        Integer renewalAmount = renewalAmountCalculator.renewalAmount(data);
        Renewaldate.RenewalDates renewalDates = renewaldateCalculator.calculateRenewalDates(data);
        System.out.println("RENEWAL_REMINDER MUSIC " + renewalDates.getMusicRenewalDate() +
                "\nRENEWAL_REMINDER VIDEO " + renewalDates.getVideoRenewalDate() +
                "\nRENEWAL_REMINDER PODCAST " + renewalDates.getPodcastRenewalDate() +
                "\nRENEWAL_AMOUNT " + renewalAmount);
    }

    public static LocalDate parseDate(String dateString) {
        try {
            return LocalDate.parse(dateString, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        } catch (java.time.format.DateTimeParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
