package com.example.geektrust.service;

import java.time.LocalDate;

public class Subscription {
    private LocalDate startDate;
    private String musicPlan;
    private String videoPlan;
    private String podcastPlan;
    private Topup topup;

    public Subscription() {
        this(LocalDate.of(1998, 3, 20), "FREE", "FREE", "FREE", new Topup());
    }

    public Subscription(LocalDate startDate, String musicPlan, String videoPlan, String podcastPlan, Topup topup) {
        this.startDate = startDate;
        this.musicPlan = musicPlan;
        this.videoPlan = videoPlan;
        this.podcastPlan = podcastPlan;
        this.topup = topup;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public String getMusicPlan() {
        return musicPlan;
    }

    public void setMusicPlan(String musicPlan) {
        this.musicPlan = musicPlan;
    }

    public String getVideoPlan() {
        return videoPlan;
    }

    public void setVideoPlan(String videoPlan) {
        this.videoPlan = videoPlan;
    }

    public String getPodcastPlan() {
        return podcastPlan;
    }

    public void setPodcastPlan(String podcastPlan) {
        this.podcastPlan = podcastPlan;
    }

    public Topup getTopup() {
        return topup;
    }

    public void setTopup(Topup topup) {
        this.topup = topup;
    }

    @Override
    public String toString() {
        return "Subscription [startDate=" + startDate + ", MusicPlan=" + musicPlan + ", VideoPlan=" + videoPlan
                + ", PodcastPlan=" + podcastPlan + ", Topup=" + topup + "]";
    }
}
