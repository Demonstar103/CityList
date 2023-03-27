package com.example.citylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This is a class that keeps track of a list of city objects
 */
public class CityList {
    private List<City> cities = new ArrayList<>();

    /**
     * This adds a city to the list if that city does not exist
     * @param city
     *      This is the city to add
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }

    /**
     * This deletes a city from the list if that city exists in the list
     * @param city
     *       This the city to delete
     */

    public void delete(City city) {
        if (!cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.remove(city);
    }

    /**
     *
     * @return The number of cities in city list
     */

    int count(){
        return cities.size();
    }

    /**
     * This returns a sorted list of cities
     * @param flag if flag = 0 the cities will be sorted according to city name
     *             if flag = 1 the cities will be sorted according to province name
     * @return
     *      Return the sorted list of cities
     */

    //sort_by_city
    public List<City> getCities(int flag) {
        List<City> cityList = cities;
        if(flag==0){
            Collections.sort(cityList);
        }else if(flag==1){
            Collections.sort(cityList, new City.SortByprovince());
        }
        return cityList;
    }
}

