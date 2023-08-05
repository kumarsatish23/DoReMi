package com.example.geektrust.service;

/**
 * The Topup class represents a subscription top-up with a specific plan and duration.
 */
public class Topup {
    private String topupPlan;
    private Integer months;

    /**
     * Default constructor initializes a Topup instance with default values.
     */
    public Topup() {
        this("null", 0);
    }

    /**
     * Parameterized constructor to create a Topup instance with given plan and months.
     *
     * @param topupPlan The plan of the top-up.
     * @param months    The duration of the top-up in months.
     */
    public Topup(String topupPlan, Integer months) {
        this.topupPlan = topupPlan;
        this.months = months;
    }

    /**
     * Get the top-up plan.
     *
     * @return The top-up plan.
     */
    public String getTopupPlan() {
        return topupPlan;
    }

    /**
     * Set the top-up plan.
     *
     * @param topupPlan The top-up plan to set.
     */
    public void setTopupPlan(String topupPlan) {
        this.topupPlan = topupPlan;
    }

    /**
     * Get the duration of the top-up in months.
     *
     * @return The duration of the top-up.
     */
    public Integer getMonths() {
        return months;
    }

    /**
     * Set the duration of the top-up in months.
     *
     * @param months The duration of the top-up to set.
     */
    public void setMonths(Integer months) {
        this.months = months;
    }

    /**
     * Get a string representation of the Topup instance.
     *
     * @return A string representation of the Topup instance.
     */
    @Override
    public String toString() {
        return "Topup [topupPlan=" + topupPlan + ", months=" + months + "]";
    }
}
