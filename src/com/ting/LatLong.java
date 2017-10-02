package com.ting;

import static java.lang.Math.abs;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class LatLong {

    private double latitude;
    private double longitude;

    public LatLong(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public double calculateDistanceTo(LatLong otherLocationLatLong) {

        // Calculate distance √((x2 - x1)^2 + (y2 - y1)^2), then take absolute number
        double distance = abs(sqrt(pow((latitude - otherLocationLatLong.getLatitude()), 2) + pow((longitude - otherLocationLatLong.getLongitude()), 2)));

        return distance;
    }

}
