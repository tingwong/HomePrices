package com.ting;

import java.util.*;

import static java.lang.Math.*;

//  HOMEWORK:   A city object contains an avg home price and longitude/latitude coordinates of the city.
//              Given a list of people with latitude and longitude of their homes, determine the avg home
//              price of the people in the list by finding their nearest city

public class HomePrice {

    // TW:  First time using HashSet -- is it a good choice for a data structure?
    //      My rationale is to keep the cities unique
    private HashSet<City> cityList = new HashSet<>();

    // TW:  In this instance, I'd actually like to have addCity be static, but then it can't keep
    //      track of what's currently in the list. But then, I have to instantiate HomePrice each
    //      time I call the class. Is that okay?
    public void addCity(String cityName, double avgHomePrice, LatLong latLong) {

        // Add new city
        City newCity = new City(cityName, avgHomePrice, latLong);

        // Add it to the HashSet to keep track of city
        cityList.add(newCity);

    }

    public City findNearestCity(LatLong latLong) {

        HashMap<City, Double> distanceToCity = new HashMap<>();

        // Iterate through all the cities, calculating the distance between home and city
        for (City currentCity : cityList) {

            double distanceBetweenCity = currentCity.getLatLong().calculateDistanceTo(latLong);

            distanceToCity.put(currentCity, distanceBetweenCity);
        }

        // Set the initial smallest distance and nearest city with the first city's values
        double smallestDistance = Double.MAX_VALUE;
        City nearestCity = null;

        for (Map.Entry<City, Double> currentEntry : distanceToCity.entrySet()) {

            if ((double) currentEntry.getValue() < smallestDistance) {

                smallestDistance = (double) currentEntry.getValue();
                nearestCity = (City) currentEntry.getKey();
            }
        }

        return nearestCity;

    }

    public double calculateAvgHomePrice(List<Person> people) {

        List<Double> cityPrices = new ArrayList<>();

        // Iterate through list of people, find nearest city and add that city's average home price
        // to an ArrayList
        for (int i = 0; i < people.size(); i++) {

            double cityAvgHomePrice = findNearestCity(people.get(i).getLatlong()).getAvgHomePrice();
            cityPrices.add(cityAvgHomePrice);
        }

        double sumTotalHomePrice = 0;

        // Calculate average home price
        for (int i =0; i < cityPrices.size(); i++) {
            sumTotalHomePrice += cityPrices.get(i);
        }

        double avgHomePrice = sumTotalHomePrice / cityPrices.size();

        return avgHomePrice;

    }

    public static void main(String[] args) {

        HomePrice homePrice = new HomePrice();

        // Making list of people
        List<Person> friendsInFarawayLands = new ArrayList<>();

        LatLong latLong1 = new LatLong(57.077455, -2.775336);
        LatLong latLong2 = new LatLong(46.862496, 103.846656);
        LatLong latLong3 = new LatLong(31.539538, -110.756196);

        System.out.println(latLong1.getLatitude());


        Person harryPotter = new Person("Harry",latLong1 );

        Person tuvanThroatSinger = new Person("Mr. Vibrato", latLong2);
        Person doraTheExplorer = new Person("Dora", latLong3 );

        friendsInFarawayLands.add(harryPotter);
        friendsInFarawayLands.add(tuvanThroatSinger);
        friendsInFarawayLands.add(doraTheExplorer);

        // Making list of cities

        LatLong torontoLatLong = new LatLong(43.653226, -79.383184);
        LatLong seattleLatLong = new LatLong(47.606209, -122.332071);
        LatLong kashmirLatLong = new LatLong(33.778175, 76.576171);

        homePrice.addCity("Toronto", 1000000,torontoLatLong);
        homePrice.addCity("Seattle", 700000,seattleLatLong);
        homePrice.addCity("Kashmir", 130000,kashmirLatLong);

        LatLong city1 = new LatLong(57, -2);
        LatLong city2 = new LatLong(46, 103);
        LatLong city3 = new LatLong(31, -110);

        homePrice.findNearestCity(city1);
        homePrice.findNearestCity(city2);
        homePrice.findNearestCity(city3);

        double avgPrice = homePrice.calculateAvgHomePrice(friendsInFarawayLands);
        System.out.println(avgPrice);

    }

}
