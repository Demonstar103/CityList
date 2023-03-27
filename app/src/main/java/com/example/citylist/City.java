package com.example.citylist;

import java.util.Comparator;

public class City implements Comparable<City>{
    private String city;
    private String province;

    City(String city, String province){
        this.city = city;
        this.province = province;
    }

    String getCityName(){
        return this.city;
    }

    String getProvinceName(){
        return this.province;
    }

    @Override
    public int compareTo(City city) {
        return this.city.compareTo(city.getCityName());
    }

    //sort_by_province
    static class SortByprovince implements Comparator<City> {
        @Override
        public int compare(City a, City b)
        {
            return a.getProvinceName().compareTo(b.getProvinceName());
        }
    }

}