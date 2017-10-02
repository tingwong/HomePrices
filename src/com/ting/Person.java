package com.ting;

public class Person {

    private String name;
    private LatLong latlong;

    public Person(String name, LatLong latLong) {
        this.name = name;
        this.latlong = latLong;
    }

    public LatLong getLatlong() {
        return latlong;
    }
}
