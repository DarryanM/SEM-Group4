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
        //Testing Query TopNCountryPopulation with variables
        ArrayList<Country> population = app.getTopNCountryPopulation(3);

        Country pop = app.getCountry("USA");
        assertEquals(pop.population, 278357000);
        assertEquals(pop.code,"USA");
        assertEquals(pop.capital,3813);
        assertEquals(pop.name, "United States");
        assertEquals(pop.continent, "North America");
        assertEquals(pop.region, "North America");
        app.getTopNCountryPopulation(10);

        //Testing if SQL syntax incorrect Catch will run
        app.getTopNCountryPopulation(-1);
    }

    @Test
    void testGetTopNCountriesInContPopulation()
    {
        //Testing Query TopNCountriesInContPopulation with variables
        ArrayList<Country> topNCountriesContPop = app.getTopNCountriesInContPopulation("North America", 3);

        Country pop = app.getCountry("USA");
        assertEquals(pop.population, 278357000);
        assertEquals(pop.code,"USA");
        assertEquals(pop.capital,3813);
        assertEquals(pop.name, "United States");
        assertEquals(pop.continent, "North America");
        assertEquals(pop.region, "North America");
        app.getTopNCountriesInContPopulation("North America", 3);

        //Testing if SQL syntax incorrect Catch will run
        app.getTopNCountriesInContPopulation("XYZ",-10);
    }

    @Test
    void testGetTopNCountriesInRegPopulation()
    {
        //Testing Query TopNCountriesInRegPopulation with variables
        ArrayList<Country> topNCountriesRegPop = app.getTopNCountriesInRegPopulation("Seoul", 3);

        Country pop = app.getCountry("USA");
        assertEquals(pop.population, 278357000);
        assertEquals(pop.code,"USA");
        assertEquals(pop.capital,3813);
        assertEquals(pop.name, "United States");
        assertEquals(pop.continent, "North America");
        assertEquals(pop.region, "North America");
        app.getTopNCountriesInRegPopulation("North America", 3);

        //Testing if SQL syntax incorrect Catch will run
        app.getTopNCountriesInRegPopulation("XYZ",-10);
    }

    @Test
    void testGetContinentPopulation()
    {
        ArrayList<Country> population2 = app.getContinentPopulation("North America");

        Country pop = app.getCountry("ABW");
        assertEquals(pop.code, "ABW");
        assertEquals(pop.population, 103000);
        assertEquals(pop.name, "Aruba");
        assertEquals(pop.continent, "North America");
        assertEquals(pop.region, "Caribbean");
        app.getContinentPopulation("North America");
    }

    @Test
    void testGetRegionPopulation()
    {
        ArrayList<Country> population3 = app.getRegionPopulation("Caribbean");

        Country pop = app.getCountry("ABW");
        assertEquals(pop.code, "ABW");
        assertEquals(pop.population, 103000);
        assertEquals(pop.name, "Aruba");
        assertEquals(pop.continent, "North America");
        assertEquals(pop.region, "Caribbean");
        app.getRegionPopulation("Caribbean");

        app.getRegionPopulation("1");
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

    @Test
    void testgetTopCityInRegion()
    {
        app.getTopCityInRegion("xyz",-10);
        ArrayList<City> nCityTopReg = app.getTopCityInRegion("Eastern Asia",3);

        City pop = app.getCity("KOR");
        assertEquals(pop.population,9981619);
        assertEquals(pop.name,"Seoul");
        assertEquals(pop.country, "South Korea");
        assertEquals(pop.district,"Seoul");
        app.getTopCityInRegion("Eastern Asia", 3);
    }

    @Test
    void testgetTopCityInCountry()
    {
        app.getTopCityInCountry("xyz",-10);
        ArrayList<City> nCityTopCtry = app.getTopCityInCountry("South Korea",3);

        City pop = app.getCity("KOR");
        assertEquals(pop.population,9981619);
        assertEquals(pop.name,"Seoul");
        assertEquals(pop.country, "South Korea");
        assertEquals(pop.district,"Seoul");
        app.getTopCityInCountry("South Korea", 3);
    }

    @Test
    void testGetDistrictPopulation() {
        app.getDistrictPopulation("xyz", -10);
        ArrayList<City> districtPopulation11 = app.getDistrictPopulation("Istanbul", 3);

        City district = app.getCity("TUR");


        assertEquals(district.population, 8787958);
        assertEquals(district.name, "Istanbul");
        assertEquals(district.country, "Turkey");
        assertEquals(district.district, "Istanbul");

        app.getDistrictPopulation("Istanbul", 3);
    }
}