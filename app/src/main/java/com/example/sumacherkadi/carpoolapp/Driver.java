package com.example.sumacherkadi.carpoolapp;

public class Driver {

    private String name;
    private int dayCount;
    private boolean available;

    public Driver(String name, boolean available, int dayCount) {
        this.name = name;
        this.available = available;
        this.dayCount = dayCount;
    }

    public String getName() {
        return name;
    }

    public int getDayCount() {
        return dayCount;
    }

    public void incDayCount() {
        dayCount++;
    }

    public boolean getAvailable() {
        return available;
    }
}
