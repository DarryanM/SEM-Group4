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



    // Testing of Country By Population print Method
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

    // Testing of Continent By Population print Method
    @Test
    void printContinentPopulationTestNull()
    {
        app.printContinentPopulation(null);
    }

    @Test
    void printContinentPopulationTestContainsNull()
    {
        ArrayList<Country> population2 = new ArrayList<Country>();
        population2.add(null);
        app.printContinentPopulation(population2);
    }

    @Test
    void printContinentPopulationTestEmpty()
    {
        ArrayList<Country> population2 = new ArrayList<Country>();
        app.printContinentPopulation(population2);
    }

    @Test
    void printContinentPopulation()
    {
        ArrayList<Country> population2 = new ArrayList<Country>();
        Country pop = new Country();
        pop.code = "ABW";
        pop.population = 103000;
        pop.name = "Aruba";
        pop.capital = 129;
        pop.continent = "North America";
        pop.region = "Caribbean";
        population2.add(pop);
        app.printContinentPopulation(population2);
    }

    // Testing of Region By Population print Method
    @Test
    void printRegionPopulationTestNull()
    {
        app.printRegionPopulation(null);
    }

    @Test
    void printRegionPopulationTestContainsNull()
    {
        ArrayList<Country> population3 = new ArrayList<Country>();
        population3.add(null);
        app.printRegionPopulation(population3);
    }

    @Test
    void printRegionPopulationTestEmpty()
    {
        ArrayList<Country> population3 = new ArrayList<Country>();
        app.printRegionPopulation(population3);
    }

    @Test
    void printRegionPopulation()
    {
        ArrayList<Country> population3 = new ArrayList<Country>();
        Country pop = new Country();
        pop.code = "ABW";
        pop.population = 103000;
        pop.name = "Aruba";
        pop.capital = 129;
        pop.continent = "North America";
        pop.region = "Caribbean";
        population3.add(pop);
        app.printRegionPopulation(population3);
    }

    //tests for printCityPopulation10
    @Test
    void printCityPopulation10TestNull()
    {
        app.printCountryPopulation(null);
    }

    @Test
    void printCityPopulation10TestContainsNull()
    {
        ArrayList<Country> population = new ArrayList<Country>();
        population.add(null);
        app.printCountryPopulation(population);
    }

    @Test
    void printCityPopulation10TestEmpty()
    {
        ArrayList<Country> population = new ArrayList<Country>();
        app.printCountryPopulation(population);
    }

    @Test
    void printCityPopulation10()
    {
        ArrayList<City> population = new ArrayList<>();
        City citypop10 = new City();
        citypop10.population = 10000;
        citypop10.name = "city";
        citypop10.country = "country";
        citypop10.district = "district";
        population.add(citypop10);
        app.printCityPopulation10(population);
    }

    // tests for printDistrictPopulation
    @Test
    void printDistrictPopulationTestNull()
    {
        app.printDistrictPopulation(null);
    }

    @Test
    void printDistrictPopulationTestContainsNull()
    {
        ArrayList<City> districtpopulation11 = new ArrayList<>();
        app.printDistrictPopulation(districtpopulation11);
    }

    @Test
    void printDistrictPopulationTestEmpty()
    {
        ArrayList<City> districtpopulation11 = new ArrayList<>();
        app.printDistrictPopulation(districtpopulation11);
    }

    @Test
    void printDistrictPopulation()
    {
        ArrayList<City> districtpopulation11 = new ArrayList<>();
        City district = new City();
        district.population = 10000;
        district.name = "city";
        district.country = "country";
        district.district = "district";
        districtpopulation11.add(district);
        app.printDistrictPopulation(districtpopulation11);
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
    void printCityPopTestContainsNull()
    {
        ArrayList<City> CityPop7 = new ArrayList<City>();
        CityPop7.add(null);
        app.printCityPop(CityPop7);
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
    void printCityPop8TestContainsNull()
    {
        ArrayList<City> CityPop8 = new ArrayList<City>();
        CityPop8.add(null);
        app.printCityPop8(CityPop8);
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
    void printCityPop9TestContainsNull()
    {
        ArrayList<City> CityPop9 = new ArrayList<City>();
        CityPop9.add(null);
        app.printCityPop9(CityPop9);
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

    @Test
    void printTopNCountriesInRegPopulationTestNull()
    {
        app.printTopNCountriesInRegPopulation(null);
    }
    @Test
    void printTopNCountriesInRegPopulationTestContainsNull()
    {
        ArrayList<Country> topNCountriesRegPop = new ArrayList<Country>();
        topNCountriesRegPop.add(null);
        app.printTopNCountriesInRegPopulation(topNCountriesRegPop);
    }
    @Test
    void printTopNCountriesInRegPopulationTestEmpty()
    {
        ArrayList<Country> topNCountriesRegPop = new ArrayList<Country>();
        app.printTopNCountriesInRegPopulation(topNCountriesRegPop);
    }

    @Test
    void printTopNCountriesInRegPopulation()
    {
        ArrayList<Country> topNCountriesRegPop = new ArrayList<Country>();
        Country pop = new Country();
        pop.row_num = 0;
        pop.code = "NGA";
        pop.population = 111506000;
        pop.name = "Nigeria";
        pop.capital = 2754;
        pop.continent = "Africa";
        pop.region = "Western Africa ";
        topNCountriesRegPop.add(pop);
        app.printTopNCountriesInRegPopulation(topNCountriesRegPop);
    }


    // tests for printGetTopNCityPopWorld12
    @Test
    void printGetTopNCityPopWorld12TestNull()
    {
        app.printGetTopNCityPopWorld12(null);
    }

    @Test
    void printGetTopNCityPopWorld12TestContainsNull()
    {
        ArrayList<City> topNCityPopWorld12 = new ArrayList<City>();
        app.printGetTopNCityPopWorld12(topNCityPopWorld12);
    }

    @Test
    void printGetTopNCityPopWorld12TestEmpty()
    {
        ArrayList<City> topNCityPopWorld12 = new ArrayList<City>();
        app.printGetTopNCityPopWorld12(topNCityPopWorld12);
    }

    @Test
    void printGetTopNCityPopWorld12()
    {
        ArrayList<City> topNCityPopWorld12 = new ArrayList<City>();
        City pop = new City();
        pop.population = 10000;
        pop.name = "city";
        pop.country = "country";
        pop.row_num = 40;
        pop.district = "district";
        topNCityPopWorld12.add(pop);
        app.printGetTopNCityPopWorld12(topNCityPopWorld12);
    }


    // TESTS FOR printTopCityInCountry
    @Test
    void printTopCityInRegionTestNull()
    {
        app.printTopCityInRegion(null);
    }

    @Test
    void printTopCityInRegionContainsNull()
    {
        ArrayList<City> TopCityInRegion = new ArrayList<City>();
        TopCityInRegion.add(null);
        app.printTopCityInRegion(TopCityInRegion);
    }

    @Test
    void printTopCityInRegionTestEmpty()
    {
        ArrayList<City> TopCityInRegion = new ArrayList<City>();
        app.printTopCityInRegion(TopCityInRegion);
    }

    @Test
    void printTopCityInRegion()
    {
        ArrayList<City> nCityTopReg = new ArrayList<City>();
        City pop = new City();
        pop.population = 100000;
        pop.name = "Name";
        pop.country = "Country";
        pop.region = "region";
        pop.district = "district";
        pop.row_num = 1;
        nCityTopReg.add(pop);
        app.printTopCityInRegion(nCityTopReg);
    }


    // TESTS FOR printTopCityInCountry
    @Test
    void printTopCityInCountryTestNull()
    {
        app.printTopCityInCountry(null);
    }

    @Test
    void printTopCityInCountryNull()
    {
        ArrayList<City> TopCityInCountry = new ArrayList<City>();
        TopCityInCountry.add(null);
        app.printTopCityInCountry(TopCityInCountry);
    }

    @Test
    void printTopCityInCountryTestEmpty()
    {
        ArrayList<City> TopCityInCountry = new ArrayList<City>();
        app.printTopCityInCountry(TopCityInCountry);
    }

    @Test
    void printTopCityInCountry() {
        ArrayList<City> nCityTopCtry= new ArrayList<City>();
        City pop = new City();
        pop.population = 100000;
        pop.name = "Name";
        pop.country = "Country";
        pop.district = "district";
        pop.row_num = 1;
        nCityTopCtry.add(pop);
        app.printTopCityInCountry(nCityTopCtry);
    }


    }