package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AppIntegrationTest
{
    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
        app.connect("localhost:33060", 30000);

    }

    @Test
    void testGetCountry()
    {
        Country pop = app.getCountry( "ABW");
        assertEquals(pop.code, "ABW");
        assertEquals(pop.population, 103000);
        assertEquals(pop.name, "Aruba");
        assertEquals(pop.continent, "North America");
        assertEquals(pop.region, "Caribbean");
    }

    @Test
    void testGetCountryPopulationNull()
    {
        app.getCountry(null);

    }

    @Test
    void testAddCountry()
    {
        Country pop = new Country();
        pop.code = "TST";
        pop.population = 1;
        pop.name = "Test-Country";
        pop.continent = "Africa";
        pop.region = "Test-Region";
        app.addCountry(pop);
        pop = app.getCountry("TST");
        assertEquals(pop.code, "TST");
        assertEquals(pop.population, 1);
        assertEquals(pop.name, "Test-Country");
        assertEquals(pop.continent, "Africa");
        assertEquals(pop.region, "Test-Region");

    }

    @Test
    void testGetCountryPopulation()
    {
        ArrayList<Country> population = app.getCountryPopulation();

        Country pop = app.getCountry("ABW");
        assertEquals(pop.code, "ABW");
        assertEquals(pop.population, 103000);
        assertEquals(pop.name, "Aruba");
        assertEquals(pop.continent, "North America");
        assertEquals(pop.region, "Caribbean");
        app.getCountryPopulation();
    }


    @Test
    void testGetTopNCountryPopulation()
    {
        app.getTopNCountryPopulation(10);
        app.getTopNCountryPopulation(-1);
    }

    @Test
    void testGetContinentPopulation()
    {
        ArrayList<Country> population2 = app.getContinentPopulation();

        Country pop = app.getCountry("ABW");
        assertEquals(pop.code, "ABW");
        assertEquals(pop.population, 103000);
        assertEquals(pop.name, "Aruba");
        assertEquals(pop.continent, "North America");
        assertEquals(pop.region, "Caribbean");
        app.getContinentPopulation();
    }


    @Test
    void testGetCity()
    {
        City pop = app.getCity( "KOR");
        assertEquals(pop.population, 9981619);
        assertEquals(pop.countryCode,"KOR");
        assertEquals(pop.name, "Seoul");
        assertEquals(pop.district, "Seoul");
        assertEquals(pop.country, "South Korea");
        app.getCityPop();

    }

    @Test
    void testGetCityPop7()
    {
        ArrayList<City> cityPop7 = app.getCityPop();

        City pop = app.getCity("KOR");
        assertEquals(pop.population, 9981619);
        assertEquals(pop.countryCode,"KOR");
        assertEquals(pop.name, "Seoul");
        assertEquals(pop.district, "Seoul");
        assertEquals(pop.country, "South Korea");
        app.getCityPop();
    }

    @Test
    void testGetTopNCountriesInContPopulation()
    {
        app.getTopNCountriesInContPopulation(3);
        app.getTopNCountriesInContPopulation(-10);
    }

    @Test
    void testgetTopCityPopulation()
        {
            app.getTopCityPopulation("xyz",-10);
            ArrayList<City> nCityPop = app.getTopCityPopulation("Asia",3);

            City pop = app.getCity("KOR");
            assertEquals(pop.population,9981619);
            assertEquals(pop.name,"Seoul");
            assertEquals(pop.country, "South Korea");
            assertEquals(pop.district,"Seoul");
            app.getTopCityPopulation("Asia", 3);
    }


}