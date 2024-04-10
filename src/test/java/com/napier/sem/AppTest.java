package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest
{
    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
    }


    @Test
    void printCountryPopulationTestNull()
    {
        app.printCountryPopulation(null);
    }

    @Test
    void printCountryPopulationTestContainsNull()
    {
        ArrayList<Country> population = new ArrayList<Country>();
        population.add(null);
        app.printCountryPopulation(population);
    }

    @Test
    void printCountryPopulationTestEmpty()
    {
        ArrayList<Country> population = new ArrayList<Country>();
        app.printCountryPopulation(population);
    }

    @Test
    void printCountryPopulation()
    {
        ArrayList<Country> population = new ArrayList<Country>();
        Country pop = new Country();
        pop.code = "ABW";
        pop.population = 103000;
        pop.name = "Aruba";
        pop.capital = 129;
        pop.continent = "North America";
        pop.region = "Caribbean";
        population.add(pop);
        app.printCountryPopulation(population);
    }

    @Test
    void printTopCityPopulationTestNull()
    {
        app.printTopCityPopulation(null);
    }

    @Test
    void printTopCityPopulationTestContainsNull()
    {
        ArrayList<City> nCityPop = new ArrayList<City>();
        nCityPop.add(null);
        app.printTopCityPopulation(nCityPop);
    }

    @Test
    void printTopCityPopulationTestEmpty()
    {
        ArrayList<City> nCityPop = new ArrayList<City>();
        app.printTopCityPopulation(nCityPop);
    }

    @Test
    void printTopCityPopulation()
    {
        ArrayList<City> nCityPop = new ArrayList<City>();
        City pop = new City();
        pop.row_num = 2;
        pop.name = "Seoul";
        pop.country = "South Korea";
        pop.district = "Seoul";
        pop.continent = "Asia";
        pop.population = 9981619;
        nCityPop.add(pop);
        app.printTopCityPopulation(nCityPop);
    }


}