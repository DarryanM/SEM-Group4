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
        app.getCountry("EMPTY");
    }

    @Test
    void testAddCountry()
    {
        Country pop = new Country();
        pop.code = "TST";
        pop.population = 1;
        pop.name = "Test-Country";
        pop.continent = "TST-Continent";
        pop.region = "Test-Region";
        app.addCountry(pop);
        pop = app.getCountry("TST");
        assertEquals(pop.code, "TST");
        assertEquals(pop.population, 1);
        assertEquals(pop.name, "Test-Country");
        assertEquals(pop.continent, "TST-Continent");
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
}