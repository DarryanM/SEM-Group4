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
    void getCountryPopulation()
    {
        ArrayList<Country> population4 = app.getCountry("ABW");

        Country pop = app.getCountry("ABW");
        assertEquals(pop.code, "ABW");
        assertEquals(pop.population, 103000);
        assertEquals(pop.name, "Aruba");
        assertEquals(pop.capital, 129);
        assertEquals(pop.continent, "North America");
        assertEquals(pop.region, "Caribbean");
    }
}