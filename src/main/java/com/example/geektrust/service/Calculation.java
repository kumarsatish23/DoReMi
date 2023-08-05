package com.example.geektrust.service;

/**
 * The Calculation class calculates the renewal amount for a subscription.
 */
public class Calculation {
    private static final int ONE_DEVICE_PRICE = 0;
    private static final int FOUR_DEVICE_PRICE = 50;
    private static final int TEN_DEVICE_PRICE = 100;

    /**
     * Enumeration of plan prices.
     */
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

    /**
     * Enumeration of top-up prices.
     */
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

    /**
     * Calculates the total renewal amount for a subscription.
     *
     * @param subscribe The subscription for which to calculate the renewal amount.
     * @return The total renewal amount.
     */
    public Integer renewalAmount(Subscription subscribe) {
        int totalAmount = 0;

        String musicPlan = subscribe.getMusicPlan();
        if (musicPlan != null) {
            totalAmount += PlanPrice.valueOf(musicPlan).getPrice();
        }

        String videoPlan = subscribe.getVideoPlan();
        if (videoPlan != null) {
            totalAmount += PlanPrice.valueOf(videoPlan).getPrice();
        }

        String podcastPlan = subscribe.getPodcastPlan();
        if (podcastPlan != null) {
            totalAmount += PlanPrice.valueOf(podcastPlan).getPrice();
        }

        Topup topup = subscribe.getTopup();
        if (topup != null) {
            String topupPlan = topup.getTopupPlan();
            if (topupPlan != null) {
                totalAmount += TopupPrice.valueOf(topupPlan).getPrice() * topup.getMonths();
            }
        }

        return totalAmount;
    }
}
