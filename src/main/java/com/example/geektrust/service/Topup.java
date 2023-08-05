package com.example.geektrust.service;

public class Topup {
    private String topupPlan;
    private Integer months;

    public Topup() {
        this("null", 0);
    }

    public Topup(String topupPlan, Integer months) {
        this.topupPlan = topupPlan;
        this.months = months;
    }

    public String getTopupPlan() {
        return topupPlan;
    }

    public void setTopupPlan(String topupPlan) {
        this.topupPlan = topupPlan;
    }

    public Integer getMonths() {
        return months;
    }

    public void setMonths(Integer months) {
        this.months = months;
    }

    @Override
    public String toString() {
        return "Topup [topupPlan=" + topupPlan + ", months=" + months + "]";
    }
}
