package com.example.citylist;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.List;

public class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    private City mockCity() {
        return new City("Edmonton", "AB");
    }

    @Test
    public void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities(1).size());

        City city = new City("Regina", "SK");
        cityList.add(city);

        assertEquals(2, cityList.getCities(1).size());
        assertTrue(cityList.getCities(1).contains(city));
    }

    @Test
    public void testDelete(){
        CityList cityList = new CityList();

        City city = new City("Dhaka","Bangladesh");
        cityList.add(city);

        City city1 = new City("Delhi","India");
        cityList.add(city1);

        cityList.delete(city);
        assertEquals(1, cityList.getCities(1).size());
        assertTrue(cityList.getCities(1).contains(city1));

    }

    @Test
    public void testAddException() {
        CityList cityList = new CityList();
        City city = mockCity();
        cityList.add(city);

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    @Test
    public void testDeleteException() {
        CityList cityList = new CityList();
        City city = new City("Dhaka","Bangladesh");
        cityList.add(city);
        cityList.delete(city);

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(city);
        });
    }

    @Test
    public void testCount(){
        CityList cityList = new CityList();
        City city = new City("Dhaka","Bangladesh");
        cityList.add(city);

        assertEquals(1,cityList.count());

    }

    @Test
    public void testSort(){
        CityList citylist = new CityList();
        citylist.add(new City("Helsinki", "Finland"));
        citylist.add(new City("Tokyo", "Japan"));

        List<City> order_by_City=citylist.getCities(0);

        assertEquals("Helsinki", order_by_City.get(0).getCityName());
        assertEquals("Tokyo", order_by_City.get(1).getCityName());

        List<City> order_By_Province=citylist.getCities(1);
        assertEquals("Finland", order_By_Province.get(0).getProvinceName());
        assertEquals("Japan", order_By_Province.get(1).getProvinceName());
}

    @Test
    public void testGetCities() {
        CityList cityList = mockCityList();
        assertEquals(0, mockCity().compareTo(cityList.getCities(1).get(0)));

        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);

        assertEquals(0, city.compareTo(cityList.getCities(1).get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities(1).get(1)));
    }
}
