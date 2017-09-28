package com.ting;

import java.util.*;

import static java.lang.Math.*;

//  HOMEWORK:   A city object contains an avg home price and longitude/latitude coordinates of the city.
//              Given a list of people with latitude and longitude of their homes, determine the avg home
//              price of the people in the list by finding their nearest city

// TW:  Will you comment on my formatting as well? Would love to know (inclusive of how I'm commenting).
//      Te amo mucho <3

public class HomePrice {

    // TW:  First time using HashSet -- is it a good choice for a data structure?
    //      My rationale is to keep the cities unique
    private HashSet<City> cityList = new HashSet<>();

    // TW:  In this instance, I'd actually like to have addCity be static, but then it can't keep
    //      track of what's currently in the list. But then, I have to instantiate HomePrice each
    //      time I call the class. Is that okay?
    public void addCity(String cityName, double avgHomePrice, double latitude, double longitude) {

        // Add new city
        City newCity = new City(cityName, avgHomePrice, latitude, longitude);

        // Add it to the HashSet to keep track of city
        cityList.add(newCity);

    }

    public City findNearestCity(double latitude, double longitude) {

        Iterator<City> cityListIterator = cityList.iterator();

        HashMap<City, Double> distanceToCity = new HashMap<>();

        // Iterate through all the cities, calculating the distance between home and city
        while (cityListIterator.hasNext()) {
            City currentCity = cityListIterator.next();
            double currentCityLatitude = currentCity.getLatitude();
            double currentCityLongitude = currentCity.getLongitude();

            // Calculate distance √((x2 - x1)^2 + (y2 - y1)^2), then take absolute number
            double distance = abs(sqrt(pow((currentCityLatitude - latitude), 2) + pow((currentCityLongitude - longitude), 2)));

            distanceToCity.put(currentCity, distance);
        }

        Iterator distanceCityIterator = distanceToCity.entrySet().iterator();

        // TW:  I don't fully understand the code here but am referencing it from an article
        //      on how to iterate through a HashMap

        // Find first value of HashMap
        Map.Entry cityDistancePair = (Map.Entry) distanceCityIterator.next();

        // Set the initial smallest distance and nearest city with the first city's values
        double smallestDistance = (double) cityDistancePair.getValue();
        City nearestCity = (City) cityDistancePair.getKey();

        // Iterate through the HashMap and return the City with the smallest absolute number
        while (distanceCityIterator.hasNext()) {

            if ((double) cityDistancePair.getValue() < smallestDistance) {

                smallestDistance = (double) cityDistancePair.getValue();
                nearestCity = (City) cityDistancePair.getKey();

            }

            // Move onto the next element
            cityDistancePair = (Map.Entry) distanceCityIterator.next();

            // TW:  I'm reading that this avoids a ConcurrentModificationException
            distanceCityIterator.remove();
        }

        return nearestCity;

    }

    public double calculateAvgHomePrice(List<Person> people) {

        List<Double> cityPrices = new ArrayList<>();

        // Iterate through list of people, find nearest city and add that city's average home price
        // to an ArrayList
        for (int i = 0; i < people.size(); i++) {

            double personLatitude = people.get(i).getLatitude();
            double personLongitude = people.get(i).getLongitude();

            double cityAvgHomePrice = findNearestCity(personLatitude, personLongitude).getAvgHomePrice();
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

}
