package com.example.geektrust.service;

public class Calculation {
    private static final int ONE_DEVICE_PRICE = 0;
    private static final int FOUR_DEVICE_PRICE = 50;
    private static final int TEN_DEVICE_PRICE = 100;

    private enum PlanPrice {
        FREE(0),
        PERSONAL(100),
        PREMIUM(250);

        private final int price;

        PlanPrice(int price) {
            this.price = price;
        }

        public int getPrice() {
            return price;
        }
    }

    private enum TopupPrice {
        ONE_DEVICE(ONE_DEVICE_PRICE),
        FOUR_DEVICE(FOUR_DEVICE_PRICE),
        TEN_DEVICE(TEN_DEVICE_PRICE);

        private final int price;

        TopupPrice(int price) {
            this.price = price;
        }

        public int getPrice() {
            return price;
        }
    }

    public Integer renewalAmount(Subscription subscribe) {
        int totalAmount = 0;

        totalAmount += PlanPrice.valueOf(subscribe.getMusicPlan()).getPrice();
        totalAmount += PlanPrice.valueOf(subscribe.getVideoPlan()).getPrice();
        totalAmount += PlanPrice.valueOf(subscribe.getPodcastPlan()).getPrice();

        Topup topup = subscribe.getTopup();
        totalAmount += TopupPrice.valueOf(topup.getTopupPlan()).getPrice() * topup.getMonths();

        return totalAmount;
    }
}
