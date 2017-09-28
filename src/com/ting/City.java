package com.ting;

public class City {

    private String cityName;
    private double avgHomePrice;
    private double latitude;
    private double longitude;

    City(String cityName, double avgHomePrice, double latitude, double longitude) {
        this.cityName = cityName;
        this.avgHomePrice = avgHomePrice;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getAvgHomePrice() {
        return avgHomePrice;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
}
