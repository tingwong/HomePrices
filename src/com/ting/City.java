package com.ting;

public class City {

    private String cityName;
    private double avgHomePrice;
    private LatLong latLong;

    City(String cityName, double avgHomePrice, LatLong latLong) {
        this.cityName = cityName;
        this.avgHomePrice = avgHomePrice;
        this.latLong = latLong;
    }

    public double getAvgHomePrice() {
        return avgHomePrice;
    }

    public LatLong getLatLong() {
        return latLong;
    }

    public String getCityName() {
        return cityName;
    }
}
