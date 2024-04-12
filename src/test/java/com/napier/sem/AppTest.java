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
//Test for City in the World City pop7
    @Test
    void printCityPopTestNull()
    {
        app.printCityPop(null);
    }

    @Test
    void printCityPopTestEmpty()
    {
        ArrayList<City>CityPop7 = new ArrayList<City>();
        app.printCityPop(CityPop7);
    }

    @Test
    void printCityPop()
    {
        ArrayList<City> CityPop7 = new ArrayList<City>();
        City pop = new City();
        pop.countryCode = "USA";
        pop.population = 8008278;
        pop.name = "United States";
        pop.district = "New York";
         CityPop7.add(pop);
        app. printCityPop(CityPop7);
    }
//Test for City in a continent City pop8

    @Test
    void printCityPop8TestNull()
    {
        app.printCityPop8(null);
    }

    @Test
    void printCityPop8TestEmpty()
    {
        ArrayList<City>CityPop8 = new ArrayList<City>();
        app.printCityPop8(CityPop8);
    }

    @Test
    void printCityPop8()
    {
        ArrayList<City> CityPop8 = new ArrayList<City>();
        City pop = new City();
        pop.countryCode = "USA";
        pop.population = 8008278;
        pop.name = "United States";
        pop.country = "New York";
        pop.region = " New York";
        CityPop8.add(pop);
        app. printCityPop8(CityPop8);
    }

    //Test for City in a Region City pop9

    @Test
    void printCityPop9TestNull()
    {
        app.printCityPop9(null);
    }

    @Test
    void printCityPop9TestEmpty()
    {
        ArrayList<City>CityPop9 = new ArrayList<City>();
        app.printCityPop9(CityPop9);
    }

    @Test
    void printCityPop9()
    {
        ArrayList<City> CityPop9 = new ArrayList<City>();
        City pop = new City();
        pop.countryCode = "USA";
        pop.population = 8008278;
        pop.name = "United States";
        pop.country = "New York";
        pop.region = "New York";
        CityPop9.add(pop);
        app. printCityPop9(CityPop9);
    }

    @Test
    void printTopNCountryPopulationTestNull()
    {
        app.printTopNCountryPopulation(null);
    }
    @Test
    void printTopNCountryPopulationTestContainsNull()
    {
        ArrayList<Country> topPopulation = new ArrayList<Country>();
        topPopulation.add(null);
        app.printTopNCountryPopulation(topPopulation);
    }
    @Test
    void printTopNCountryPopulationTestEmpty()
    {
        ArrayList<Country> topPopulation = new ArrayList<Country>();
        app.printTopNCountryPopulation(topPopulation);
    }

    @Test
    void printTopNCountryPopulation()
    {
        ArrayList<Country> topPopulation = new ArrayList<Country>();
        Country pop = new Country();
        pop.population = 111506000;
        pop.code = "NGA";
        pop.capital = 2754;
        pop.name = "Nigeria";
        pop.continent = "Africa";
        pop.region = "Western Africa ";
        topPopulation.add(pop);
        app.printTopNCountryPopulation(topPopulation);
    }






    @Test
    void printTopNCountriesInContPopulationTestNull()
    {
        app.printTopNCountriesInContPopulation(null);
    }
    @Test
    void printTopNCountriesInContPopulationTestContainsNull()
    {
        ArrayList<Country> topNCountriesContPop = new ArrayList<Country>();
        topNCountriesContPop.add(null);
        app.printTopNCountriesInContPopulation(topNCountriesContPop);
    }
    @Test
    void printTopNCountriesInContPopulationTestEmpty()
    {
        ArrayList<Country> topNCountriesContPop = new ArrayList<Country>();
        app.printTopNCountriesInContPopulation(topNCountriesContPop);
    }

    @Test
    void printTopNCountriesInContPopulation()
    {
        ArrayList<Country> topNCountriesContPop = new ArrayList<Country>();
        Country pop = new Country();
        pop.row_num = 0;
        pop.code = "NGA";
        pop.population = 111506000;
        pop.name = "Nigeria";
        pop.capital = 2754;
        pop.continent = "Africa";
        pop.region = "Western Africa ";
        topNCountriesContPop.add(pop);
        app.printTopNCountriesInContPopulation(topNCountriesContPop);
    }






}