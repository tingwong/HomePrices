package com.ting;

import java.util.ArrayList;
import java.util.List;

public class Main {

    // TW:  When does it make sense to instantiate things outside the static void main?

    public static void main(String[] args) {

        HomePrice homePrice = new HomePrice();

        // Making list of people
        List<Person> friendsInFarawayLands = new ArrayList<>();

        Person harryPotter = new Person("Harry", 57.077455, -2.775336);
        Person tuvanThroatSinger = new Person("Mr. Vibrato", 46.862496, 103.846656);
        Person doraTheExplorer = new Person("Dora", 31.539538, -110.756196);

        friendsInFarawayLands.add(harryPotter);
        friendsInFarawayLands.add(tuvanThroatSinger);
        friendsInFarawayLands.add(doraTheExplorer);

        // Making list of cities

        homePrice.addCity("Toronto", 1000000,43.653226, -79.383184);
        homePrice.addCity("Seattle", 700000,47.606209, -122.332071);
        homePrice.addCity("Kashmir", 130000,33.778175, 76.576171);

        double avgPrice = homePrice.calculateAvgHomePrice(friendsInFarawayLands);
        System.out.println(avgPrice);

    }
}
