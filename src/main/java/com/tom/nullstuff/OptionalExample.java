package com.tom.nullstuff;

import lombok.Data;

import java.util.Map;
import java.util.Optional;

public class OptionalExample {

    private static final String CITY_INVALID = "";

    Map<String, City> cityRepository;

    public static class City {
        public City(String cityCode) {}
        public void setIsUsed() {};
    }

    public class Example1 {

        public Example1() { validateCity("");}

    public void validateCity(String cityCode) {
        City city = findCity(cityCode);
        if (city == null) {
            setError(CITY_INVALID, cityCode);
        }
    }

    public City findCity(String cityCode) {
        return cityRepository.get(cityCode);
    }

    }

    public class Example2 {

    public Example2() { validateCity("");}

    public void validateCity(String cityCode) {
        Optional<City> city = findCity(cityCode);
        if (city.isPresent()) {
            return;
        }
        setError(CITY_INVALID, cityCode);
    }

    public Optional<City> findCity(String cityCode) {
        City city = cityRepository.get(cityCode);
        return Optional.ofNullable(city);
    }

    public void OptionalExamples() {

    }

    }


    private void setError(String error, String value) {
    }


}
