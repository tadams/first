package com.tom.func;

import static com.tom.nullstuff.OptionalExample.City;
import org.junit.Test;

import java.util.Optional;

public class OptionalTest {

    City city;
    City DEFAULT_CITY;
    Optional<City> optionalCity = Optional.ofNullable(city);
    private String cityCode;

    public void optionalCreationExamples() {

        // city can be null
        Optional<City> optionalCity = Optional.ofNullable(city);

        // cannot be null or NullPointerException is thrown
        Optional<City> presentCity = Optional.of(city);

        // creates a empty or not present instance of optional
        Optional<City> absentCity = Optional.empty();
    }

    public void optionalCheckIfValuePresent() {

        if (optionalCity.isPresent()) {
            // we have a value
        }

        // When present call Consumer function
        optionalCity.ifPresent(City::setIsUsed);
    }

    public void optionalGetValue() {

        // returns the city when present or NullPointerException if absent
        City city1 = optionalCity.get();

        // returns the city or a default instance if absent
        City city2 = optionalCity.orElse(DEFAULT_CITY);

        // returns the city or hey, I'll just make a new one (uses supplier function)
        City city3 = optionalCity.orElseGet(() -> new City(cityCode));

        // returns the city or throws the exception (uses supplier function) if absent
        City city4 = optionalCity.orElseThrow(() -> new IllegalStateException("Invalid City Code"));
    }

}
