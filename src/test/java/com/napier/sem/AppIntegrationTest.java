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

    //Test Country Population
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
    void testgetCitypop10()
    {
        ArrayList<City> cityPop10 = app.getCityPopulation10();

        City pop = app.getCity("KOR");
        assertEquals(pop.population, 9981619);
        assertEquals(pop.countryCode,"KOR");
        assertEquals(pop.name, "Seoul");
        assertEquals(pop.district, "Seoul");
        assertEquals(pop.country, "South Korea");
        app.getCityPopulation10();
    }

    @Test
    void testGetcityPop9()
    {
        ArrayList<City> cityPop9 = app.getCityPopregi();

        City pop = app.getCity("KOR");
        assertEquals(pop.population, 9981619);
        assertEquals(pop.countryCode,"KOR");
        assertEquals(pop.name, "Seoul");
        assertEquals(pop.district, "Seoul");
        assertEquals(pop.country, "South Korea");
        app.getCityPopregi();
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


    @Test
    void testGetCapitalCity()
    {
        City pop = app.getCapitalCity( "CHN");
        assertEquals(pop.population, 7472000);
        assertEquals(pop.name, "Peking");
        assertEquals(pop.continent, "Asia");
        assertEquals(pop.region, "Eastern Asia");
        assertEquals(pop.district, "Peking");
        assertEquals(pop.country, "China");
    }

    @Test
    void testGetAllCapCitiesWorld()
    {
        app.getAllCapCitiesWorld();
        ArrayList<City> population20 = app.getAllCapCitiesWorld();

        City pop = app.getCapitalCity("CHN");
        assertEquals(pop.population,7472000);
        assertEquals(pop.name,"Peking");
        assertEquals(pop.district,"Peking");
        app.getAllCapCitiesWorld();
    }

    @Test
    void testGetAllCapContinent()
    {
        app.getAllCapCitiesContinent("Asia");
        ArrayList<City> population21 = app.getAllCapCitiesContinent("Asia");

        City pop = app.getCapitalCity("CHN");
        assertEquals(pop.population,7472000);
        assertEquals(pop.name,"Peking");
        assertEquals(pop.district,"Peking");
        app.getAllCapCitiesContinent("Asia");
    }

    @Test
    void testGetAllCapRegion()
    {
        app.getAllCapCitiesRegion("Eastern Asia");
        ArrayList<City> population22 = app.getAllCapCitiesRegion("Eastern Asia");

        City pop = app.getCapitalCity("CHN");
        assertEquals(pop.population,7472000);
        assertEquals(pop.name,"Peking");
        assertEquals(pop.district,"Peking");
        app.getAllCapCitiesRegion("Eastern Asia");
    }

    @Test
    void testGetTopNPopCapCitiesWorld()
    {
        app.getTopNPopCapCitiesWorld(-5);
        ArrayList<City> population23 = app.getTopNPopCapCitiesWorld(5);

        City pop = app.getCapitalCity("CHN");
        assertEquals(pop.population,7472000);
        assertEquals(pop.name,"Peking");
        assertEquals(pop.country,"China");
        app.getTopNPopCapCitiesWorld(5);
    }

    @Test
    void testGetTopNPopCapContinent()
    {
        app.getTopNPopCapCitiesContinent("Asia", -5);
        ArrayList<City> population23 = app.getTopNPopCapCitiesContinent("Asia", 5);

        City pop = app.getCapitalCity("CHN");
        assertEquals(pop.population,7472000);
        assertEquals(pop.name,"Peking");
        assertEquals(pop.country,"China");
        app.getTopNPopCapCitiesContinent("Asia",5);
    }

    @Test
    void testGetTopNPopCapRegion()
    {
        app.getTopNPopCapCitiesRegion("Eastern Asia", -5);
        ArrayList<City> population23 = app.getTopNPopCapCitiesRegion("Eastern Asia", 5);

        City pop = app.getCapitalCity("CHN");
        assertEquals(pop.population,7472000);
        assertEquals(pop.name,"Peking");
        assertEquals(pop.country,"China");
        app.getTopNPopCapCitiesRegion("Eastern Asia",5);
    }


    @Test
    void testGetLivingPopContinent()
    {
        //app.getLivingPopContinent("North America");
        ArrayList<City> population26 = app.getLivingPopContinent("North America");

        City pop = app.getLivingPop1( "North America");
        assertEquals(pop.continent, "North America");
        assertEquals(pop.continentpop, 482993000);
        assertEquals(pop.citypop, 168250381);
        assertEquals(pop.noncitypop, 314742619);
        assertEquals(pop.citypoppercent, 34.83);
        assertEquals(pop.noncitypoppercent, 65.17);
        app.getLivingPopContinent("North America");
    }

    @Test
    void testGetLivingPopRegion()
    {
        app.getLivingPopContinent("North America");
        ArrayList<City> population27 = app.getLivingPopRegion("Caribbean");

        City pop = app.getLivingPop2( "Caribbean");
        assertEquals(pop.region, "Caribbean");
        assertEquals(pop.regionpop, 38140000);
        assertEquals(pop.citypop, 11067550);
        assertEquals(pop.noncitypop, 27072450);
        assertEquals(pop.citypoppercent, 29.02);
        assertEquals(pop.noncitypoppercent, 70.98);
        app.getLivingPopRegion("Caribbean");
    }

    @Test
    void testGetLivingPopCountry()
    {
        //app.getLivingPopContinent("North America");
        ArrayList<City> population28 = app.getLivingPopCountry("Aruba");

        City pop = app.getLivingPop3( "Aruba");
        assertEquals(pop.country, "Aruba");
        assertEquals(pop.countrypop, 103000);
        assertEquals(pop.citypop, 29034);
        assertEquals(pop.noncitypop, 73966);
        assertEquals(pop.citypoppercent, 28.19);
        assertEquals(pop.noncitypoppercent, 71.81);
        app.getLivingPopRegion("Aruba");
    }

}