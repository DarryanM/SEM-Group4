package com.napier.sem;

import java.sql.*;
import java.util.ArrayList;

public class App {

    public static void main(String[] args) {
        // Create new Application and connect to database
        App a = new App();

        if (args.length < 1) {
            a.connect("localhost:33060", 10000);
        } else {
            a.connect(args[0], Integer.parseInt(args[1]));
        }

        //Get Country information
        Country pop = a.getCountry("Aruba");

         // Extract Country Population
        ArrayList<Country> population = a.getCountryPopulation();

        //Display Results
        a.printCountryPopulation(population);

        // Extract City Population in the world
        ArrayList<City> cityPop7 = a.getCityPop();

        //Display Results for City population in the world
        a.printCityPop(cityPop7);

        // Extract city population information
        ArrayList<City> citypop10 = a.getCityPopulation10();

        //Display Results
        a.printCityPopulation10(citypop10);

        // Extract Top Countries Population
        ArrayList<Country> topPopulation = a.getTopNCountryPopulation(10);

        //Display Results
        a.printTopNCountryPopulation(topPopulation);

        // Extract Top City Population in a Continent
        ArrayList<City> nCityPop = a.getTopCityPopulation();

        //Display Results
        a.printTopCityPopulation(nCityPop);

        // Extract Continent Population
        ArrayList<Country> population2 = a.getContinentPopulation();

        //Display Continent Population Results
        a.printContinentPopulation(population2);

        // Extract City Population in a continent
        ArrayList<City> cityPop8 = a.getCityPopconti();

        //Display Results for city population in a continent
        a.printCityPop8(cityPop8);

        // Extract Top N Countries in a Continent
        ArrayList<Country> topNCountriesContPop = a.getTopNCountriesInContPopulation();

        //Display Results
        a.printTopNCountriesInContPopulation(topNCountriesContPop);

        // Extract district population information
        ArrayList<City> districtPopulation11 = a.getDistrictPopulation();

        // Display district population results
        a.printDistrictPopulation(districtPopulation11);

        // Extract district population information
        ArrayList<City> nCityTopReg = a.getTopCityInRegion();

        // Display district population results
        a.printTopCityInRegion(nCityTopReg);

        // Extract Region Population
        ArrayList<Country> population3 = a.getRegionPopulation();

        //Display Region Population Results
        a.printRegionPopulation(population3);

        // Extract Top City Population in a Continent
        ArrayList<City> topNCityPopWorld = a.getTopNCityPopWorld12();

        //Display Results
        a.printGetTopNCityPopWorld12(topNCityPopWorld);

        // Extract City Population in a region
        ArrayList<City> cityPop9 = a.getCityPopregi();

        //Display Results for city population in a region
        a.printCityPop9(cityPop9);

        // Extract Top N Countries in a Region
        ArrayList<Country> topNCountriesRegPop = a.getTopNCountriesInRegPopulation();

        //Display Results
        a.printTopNCountriesInRegPopulation(topNCountriesRegPop);

        // Extract district population information
        ArrayList<City> nCityTopCtry = a.getTopCityInCountry();

        // Display district population results
        a.printTopCityInCountry(nCityTopCtry);

        // Extract top N populated cities in a continent where N was provided
        ArrayList<City> population16 = a.getTopNPopCitiesContinent(3);

        //Display Results of top N populated cities in a continent where N was provided
        a.printTopNPopCitiesContinent(population16);

        // Extract top N populated cities in a Region where N was provided
        ArrayList<City> population17 = a.getTopNPopCitiesRegion(3);

        //Display Results of top N populated cities in a Region where N was provided
        a.printTopNPopCitiesRegion(population17);

        // Extract top N populated cities in a Country where N was provided
        ArrayList<City> population18 = a.getTopNPopCitiesCountry(3);

        //Display Results of top N populated cities in a Country where N was provided
        a.printTopNPopCitiesCountry(population18);

        // Extract top N populated cities in a District where N was provided
        ArrayList<City> population19 = a.getTopNPopCitiesDistrict(3);

        //Display Results of top N populated cities in a District where N was provided
        a.printTopNPopCitiesDistrict(population19);

        // Extract All the capital cities in the world organised by largest population to smallest
        ArrayList<City> population20 = a.getAllCapCitiesWorld();

        //Display Results of All the capital cities in the world organised by largest population to smallest
        a.printAllCapCitiesWorld(population20);

        // Extract All the capital cities in a Continent organised by largest population to smallest
        ArrayList<City> population21 = a.getAllCapCitiesContinent("Europe");

        //Display Results of All the capital cities in a Continent organised by largest population to smallest
        a.printAllCapCitiesContinent(population21);

        // Extract All the capital cities in a Region organised by largest population to smallest
        ArrayList<City> population22 = a.getAllCapCitiesRegion("Caribbean");

        //Display Results of All the capital cities in a Region organised by largest population to smallest
        a.printAllCapCitiesRegion(population22);

        // Extract All top N populated capital cities in the world where N is provided by the user
        ArrayList<City> population23 = a.getTopNPopCapCitiesWorld(5);

        //Display Results of top N populated capital cities in the world where N is provided by the user
        a.printTopNPopCapCitiesWorld(population23);

        // Extract All top N populated capital cities in a Continent where N and Continent are provided by the user
        ArrayList<City> population24 = a.getTopNPopCapCitiesContinent("Europe",5);

        //Display Results of top N populated capital cities in a Continent where N and Continent were provided by the user
        a.printTopNPopCapCitiesContinent(population24);

        // Extract All top N populated capital cities in a Region where N and Region are provided by the user
        ArrayList<City> population25 = a.getTopNPopCapCitiesRegion("Caribbean",5);

        //Display Results of top N populated capital cities in a Region where N and Region were provided by the user
        a.printTopNPopCapCitiesRegion(population25);

        // Disconnect from database
        a.disconnect();
    }

    /**
     * Connection to MySQL database.
     */
    private Connection con = null;

    /**
     * Connect to the MySQL database.
     */
    public void connect(String location, int delay) {
        try {
            // Load Database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 10;
        boolean shouldWait = false;
        for (int i = 0; i < retries; ++i) {
            System.out.println("Connecting to database...");
            try {
                if (shouldWait) {
                    // Wait a bit for db to start
                    Thread.sleep(delay);
                }

                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://" + location
                                + "/world?allowPublicKeyRetrieval=true&useSSL=false",
                        "root", "sem4");
                System.out.println("Successfully connected");
                break;
            } catch (SQLException sqle) {
                System.out.println("Failed to connect to database attempt " + i);
                System.out.println(sqle.getMessage());

                // Let's wait before attempting to reconnect
                shouldWait = true;
            } catch (InterruptedException ie) {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
    }


    /**
     * Disconnect from the MySQL database.
     */
    public void disconnect() {
        if (con != null) {
            try {
                // Close connection
                con.close();
            } catch (Exception e) {
                System.out.println("Error closing connection to database");
            }
        }
    }

    /**
     * Gets the population of all countries.
     *
     * @return A list of all Population sorted in descending order, or null if there is an error.
     */
    public ArrayList<Country> getCountryPopulation() {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT code, name, continent, region, capital, population "
                            + "FROM country "
                            + "Order By population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract Population information
            ArrayList<Country> population = new ArrayList<Country>();
            while (rset.next()) {
                Country pop = new Country();
                pop.population = rset.getInt("country.population");
                pop.name = rset.getString("country.Name");
                pop.continent = rset.getString("country.continent");
                pop.capital = rset.getInt("country.capital");
                pop.region = rset.getString("country.region");
                pop.code = rset.getString("country.code");
                population.add(pop);
            }
            return population;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get Population details");
            return null;
        }
    }

    /**
     * Prints a list of Populations.
     *
     * @param population The list of Population to print.
     */
    public void printCountryPopulation(ArrayList<Country> population) {

        // Check employees is not null
        if (population == null)
        {
            System.out.println("No Country Population");
            return;
        }

        // Print  header
        System.out.println(String.format("%-20s ", "All the countries in the world organised by largest population to smallest."));
        System.out.println(String.format("%-20s ", " "));
        System.out.println(String.format("%-10s %10s %-50s %-30s %-30s %-30s", "Code", "Population", "Country", "Capital", "Continent", "Region"));
        // Loop over all Retrieved Populations in the list
        for (Country pop : population) {

            if (pop == null)
                continue;

            String popCount = String.format("%-10s %10s %-50s %-30s %-30s %-30s", pop.code, pop.population, pop.name, pop.capital, pop.continent, pop.region);
            System.out.println(popCount);
        }


    }

    /**
     * Gets the All Cities population in the world .
     *
     * @return A list of all cities in the world Population sorted in descending order, or null if there is an error.
     */
    public ArrayList<City> getCityPop() {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT ct.countryCode, c.name as Country, ct.name As  City, ct.district, ct.population " +
                            "from city as ct Join country as c ON ct.CountryCode = c.code  " +
                            "Order by ct.population desc ";


            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract Population information
            ArrayList<City> cityPop7 = new ArrayList<City>();
            while (rset.next()) {
                City pop = new City();
                pop.population = rset.getInt("population");
                pop.name = rset.getString("city");
                pop.district = rset.getString("district");
                pop.countryCode = rset.getString("countryCode");
                pop.country = rset.getString("Country");
                cityPop7.add(pop);
            }
            return cityPop7;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get Population details");
            return null;
        }
    }

    /**
     * Prints a list of All the Cities in the World.
     *
     * @param CityPop7 The list of All Cities in the world Population to print.
     */
    public void printCityPop(ArrayList<City> CityPop7) {

        // Check employees is not null
        if (CityPop7 == null)
        {
            System.out.println("No Countries");
            return;
        }

        // Print header
        System.out.println(String.format("%-20s ", " "));
        System.out.println(String.format("%-20s ", "All the Cities in the world organised by largest population to smallest."));
        System.out.println(String.format("%-20s ", " "));
        System.out.println(String.format("%-20s %-20s %-20s %-30s %10s", "Country Code", "city", "Country", "District", "Population"));
        // Loop over all Retrieved Populations in the list
        for (City pop : CityPop7) {

            if (pop == null)
                continue;

            String popCount = String.format("%-20s %-20s %-20s %-30s %10s", pop.countryCode, pop.name, pop.countryCode, pop.district, pop.population);
            System.out.println(popCount);
        }
    }

    public ArrayList<City> getCityPopulation10() {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.name AS city, city.population, city.district, country.name AS country " +
                            "FROM city " +
                            "INNER JOIN country ON city.countrycode = country.code " +
                            "ORDER BY country ASC, population DESC ";


            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract Population information
            ArrayList<City> population = new ArrayList<>();
            while (rset.next()) {
                City citypop10 = new City();
                citypop10.population = rset.getInt("city.population");
                citypop10.name = rset.getString("city");
                citypop10.country = rset.getString("country");
                citypop10.district = rset.getString("district");

                population.add(citypop10);
            }
            return population;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get Population details");
            return null;
        }
    }

    /**
     * Prints a list of all the Cities in a country, ordered by Largest to Smallest Population.
     */
    public void printCityPopulation10(ArrayList<City> citypop10) {
        // Print header
        System.out.println(String.format("%-20s ", " "));
        System.out.println(String.format("Cities in a country from largest to smallest population"));
        System.out.println(String.format("%-20s %-20s %-30s %-30s", "Name", "Country", "District", "Population"));
        // Loop over all Retrieved Populations in the list
        for (City pop : citypop10) {
            String popCount = String.format("%-20s %-20s %-30s %-30s", pop.name, pop.country, pop.district, pop.population);
            System.out.println(popCount);
        }
    }

    /**
     * Gets the population of Top N of all countries in the world.
     *
     * @return A list of all Top Populated countries, or null if there is an error.
     */
    public ArrayList<Country> getTopNCountryPopulation(int limit1) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect = "SELECT name, continent, code, capital, Region, population "
                    + "FROM country "
                    + "Order By population DESC "
                    + "Limit " + limit1;

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract Population information
            ArrayList<Country> population = new ArrayList<Country>();
            while (rset.next()) {
                Country pop = new Country();
                pop.population = rset.getInt("country.population");
                pop.code = rset.getString("country.Code");
                pop.capital = rset.getInt("country.Capital");
                pop.name = rset.getString("country.Name");
                pop.continent = rset.getString("country.continent");
                pop.region = rset.getString("country.region");
                population.add(pop);
            }
            return population;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get Population details");
            return null;
        }
    }

    /**
     * Prints a list of Top N Populations.
     *
     * @param topPopulation The list of Population to print.
     */
    public void printTopNCountryPopulation(ArrayList<Country> topPopulation) {

        // Check countries is not null
        if (topPopulation == null)
        {
            System.out.println("No Countries");
            return;
        }


        // Print header
        System.out.println(String.format("%-20s ", " "));
        System.out.println(String.format("%-20s ", "All the Top N countries in the world with N provided by user."));
        System.out.println(String.format("%-20s ", " "));
        System.out.println(String.format("%-10s %10s %-50s %-30s %-30s %-30s", "Code", "Population", "Country", "Capital", "Continent", "Region"));
        // Loop over all Retrieved Populations in the list
        for (Country pop : topPopulation) {

            if (pop == null)
                continue;

            String popCount = String.format("%-10s %10s %-50s %-30s %-30s %-30s", pop.code, pop.population, pop.name, pop.capital, pop.continent, pop.region);
            System.out.println(popCount);
        }
    }

    public ArrayList<City> getTopCityPopulation() {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =

                    "WITH city1 as (select city.name as name, country.name as country, district, country.continent as continent, city.population as population, RANK () " +
                            "OVER(PARTITION BY continent ORDER BY population DESC) row_num " +
                            "FROM city inner join country on city.countrycode = country.code) " +
                            "SELECT * FROM city1  WHERE row_num <=3";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract Population information
            ArrayList<City> nCityPop = new ArrayList<City>();
            while (rset.next()) {
                City pop = new City();
                pop.population = rset.getInt("population");
                pop.name = rset.getString("Name");
                pop.country = rset.getString("Country");
                pop.continent = rset.getString("continent");
                pop.district = rset.getString("district");
                pop.row_num = rset.getInt("row_num");
                nCityPop.add(pop);
            }
            return nCityPop;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get Population details");
            return null;
        }
    }

    /**
     * Prints a list of Populations.
     *
     * @param nCityPop The list of Population to print.
     */
    public void printTopCityPopulation(ArrayList<City> nCityPop) {
        if (nCityPop == null)
        {
            System.out.println("No Countries");
            return;
        }
        // Print header
        System.out.println(String.format("%-20s ", "The top N populated cities in a continent where N is provided by the user."));
        System.out.println(String.format("%-20s ", " "));
        System.out.println(String.format("%10s %-30s %-30s %-30s %-30s %10s", "row_num", "City", "Country", "District", "Continent", "Population"));
        // Loop over all Retrieved Populations in the list
        for (City pop : nCityPop) {
            if (pop == null)
                continue;

            String popCount = String.format("%10s %-30s %-30s %-30s %-30s %10s", pop.row_num, pop.name, pop.country, pop.district, pop.continent, pop.population);
            System.out.println(popCount);
        }
    }

    /**
     * Gets the population of all countries in a continent.
     *
     * @return A list of all countries in continenet population sorted in descending order, or null if there is an error.
     */
    public ArrayList<Country> getContinentPopulation() {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT code, name, continent, region, capital, population "
                            + "FROM country "
                            + "Order By continent ASC, population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract Population information
            ArrayList<Country> population2 = new ArrayList<Country>();
            while (rset.next()) {
                Country pop = new Country();
                pop.population = rset.getInt("country.population");
                pop.name = rset.getString("country.Name");
                pop.continent = rset.getString("country.continent");
                pop.capital = rset.getInt("country.capital");
                pop.region = rset.getString("country.region");
                pop.code = rset.getString("country.code");
                population2.add(pop);
            }
            return population2;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get Population details");
            return null;
        }
    }

    /**
     * Prints a list of Countries in Continent Populations.
     *
     * @param population2 The list of Countries in Continent Populations to print.
     */
    public void printContinentPopulation(ArrayList<Country> population2) {
        // Check Population is not null
        if (population2 == null)
        {
            System.out.println("No Continent Population");
            return;
        }
        // Print header
        System.out.println(String.format("%-20s ", " "));
        System.out.println(String.format("%-20s ", "Population of All the countries in a continent organised by largest population to smallest."));
        System.out.println(String.format("%-20s ", " "));
        System.out.println(String.format("%-10s %10s %-50s %-30s %-30s %-30s", "Code", "Population", "Country", "Capital", "Continent", "Region"));
        // Loop over all Retrieved Populations in the list
        // Check if query returned values.
        for (Country pop : population2) {

            if (pop == null)
                continue;

            String popCount = String.format("%-10s %10s %-50s %10s %-30s %-30s", pop.code, pop.population, pop.name, pop.capital, pop.continent, pop.region);
            System.out.println(popCount);
        }
    }

    /**
     * Gets All the cities in a continent.
     *
     * @return A list of all Population sorted in descending order, or null if there is an error.
     */

    public ArrayList<City> getCityPopconti() {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT ct.countryCode, c.name As Country, ct.name As City, ct.population, c.continent " +
                            " from city as ct Join country as c ON ct.CountryCode = c.code " +
                            "Order by c.continent, ct.population desc ";


            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract Population information
            ArrayList<City> cityPop8 = new ArrayList<City>();
            while (rset.next()) {
                City pop = new City();
                pop.population = rset.getInt("population");
                pop.name = rset.getString("city");
                pop.countryCode = rset.getString("countryCode");
                pop.country = rset.getString("Country");
                pop.continent = rset.getString("Continent");
                cityPop8.add(pop);
            }
            return cityPop8;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get Population details");
            return null;
        }
    }

    /**
     * Prints a list of All the Cities in a continent sorted by largest to smallest population.
     *
     * @param CityPop8 The list of All Cities in a continent Population to print.
     */
    public void printCityPop8(ArrayList<City> CityPop8) {

        // Check employees is not null
        if (CityPop8 == null)
        {
            System.out.println("No Cities in a continent");
            return;
        }
        // Print header
        System.out.println(String.format("%-20s ", " "));
        System.out.println(String.format("%-20s ", "All the Cities in a continent organised by largest population to smallest."));
        System.out.println(String.format("%-20s ", " "));
        System.out.println(String.format("%-20s %-20s %-20s %-30s %10s", "Country Code", "city", "Country", "Continent", "Population"));
        // Loop over all Retrieved Populations in the list
        for (City pop : CityPop8) {

            if (pop == null)
                continue;

            String popCount = String.format("%-20s %-20s %-20s %-30s %10s", pop.countryCode, pop.name, pop.country, pop.continent, pop.population);
            System.out.println(popCount);
        }
    }


    /**
     * Gets the population of Top N countries, value provided by user.
     *
     * @return A list of Top N Countries Population in a Continent, or null if there is an error.
     */
    public ArrayList<Country> getTopNCountriesInContPopulation() {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =

                    "with country as (select name, code, capital, region, continent, population, row_number() over " +
                            "(partition by continent order by population desc, continent desc) as row_num from country) " +
                            "select row_num, name, code, capital, region, continent, population from country where row_num <=3";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract Population information
            ArrayList<Country> topNCountriesContPop = new ArrayList<Country>();
            while (rset.next()) {
                Country pop = new Country();
                pop.population = rset.getInt("country.population");
                pop.code = rset.getString("country.Code");
                pop.capital = rset.getInt("country.Capital");
                pop.name = rset.getString("country.Name");
                pop.continent = rset.getString("country.continent");
                pop.region = rset.getString("country.region");
                pop.row_num = rset.getInt("country.row_num");
                topNCountriesContPop.add(pop);
            }
            return topNCountriesContPop;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get Population details");
            return null;
        }
    }

    /**
     * Prints a list of Top N Countries Populations in a Continent.
     *
     * @param topNCountriesContPop The list of Top N Countries in a Continent to print.
     */
    public void printTopNCountriesInContPopulation(ArrayList<Country> topNCountriesContPop) {

        // Check countries is not null
        if (topNCountriesContPop == null)
        {
            System.out.println("No Countries");
            return;
        }


        // Print header
        System.out.println(String.format("%-20s ", " "));
        System.out.println(String.format("%-20s ", "All the TOP N countries in a Continent with N value provided by user."));
        System.out.println(String.format("%-20s ", " "));
        System.out.println(String.format("-%10s %-10s %10s %-50s %-30s %-30s %-30s", "row_num", "Code", "Population", "Country", "Capital", "Continent", "Region"));
        // Loop over all Retrieved Populations in the list
        for (Country pop : topNCountriesContPop) {

            if (pop == null)
                continue;

            String popCount = String.format("-%10s %-10s %10s %-50s %-30s %-30s %-30s", pop.row_num, pop.code, pop.population, pop.name, pop.capital, pop.continent, pop.region);
            System.out.println(popCount);
        }

    }

    /**
     * Cities in a district from largest to smallest population
     * Gets the population of all cities in a district.
     *
     * @return A list of all cities sorted by population in descending order, or null if there is an error.
     */
    public ArrayList<City> getDistrictPopulation() {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.name AS city, country.name AS country, city.district, city.population " +
                            "FROM city INNER JOIN country ON city.countrycode = country.code " +
                            "ORDER BY district ASC, population DESC ";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract Population information
            ArrayList<City> districtpopulation11 = new ArrayList<>();
            while (rset.next()) {
                City district = new City();
                district.population = rset.getInt("population");
                district.name = rset.getString("city");
                district.district = rset.getString("district");
                district.country = rset.getString("country");
                districtpopulation11.add(district);
            }
            return districtpopulation11;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get district population details");
            return null;
        }
    }

    /**
     * Prints the list of cities in a district from largest to smallest population"
     */
    public void printDistrictPopulation(ArrayList<City> districtpopulation11) {
        if (districtpopulation11 == null)
        {
            System.out.println("No Countries");
            return;
        }
        // Print header
        System.out.println(String.format("%-20s ", " "));
        System.out.println(String.format("Cities in a district from largest to smallest population"));
        System.out.println(String.format("%-20s %-30s %-20s %-30s", "City Name", "Country", "District", "Population"));
        // Loop over all retrieved populations in the list
        for (City district : districtpopulation11) {

            if (district == null)
                continue;
            String popCount = String.format("%-20s %-30s %-20s %-30s", district.name, district.country, district.district, district.population);
            System.out.println(popCount);
        }
    }


    public ArrayList<City> getTopCityInRegion() {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =

                    "WITH city1 as (select city.name as name, country.name as country, district, country.region as region, city.population as population, RANK () " +
                            "OVER(PARTITION BY region ORDER BY population DESC) row_num " +
                            "FROM city inner join country on city.countrycode = country.code) " +
                            "SELECT * FROM city1  WHERE row_num <=2";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract Population information
            ArrayList<City> nCityTopReg = new ArrayList<City>();
            while (rset.next()) {
                City pop = new City();
                pop.population = rset.getInt("population");
                pop.name = rset.getString("Name");
                pop.country = rset.getString("Country");
                pop.region = rset.getString("region");
                pop.district = rset.getString("district");
                pop.row_num = rset.getInt("row_num");
                nCityTopReg.add(pop);
            }
            return nCityTopReg;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get Population details");
            return null;
        }
    }

    /**
     * Prints a list of Populations.
     *
     * @param nCityTopReg The list of Population to print.
     */
    public void printTopCityInRegion(ArrayList<City> nCityTopReg) {

        //Null test
        if(nCityTopReg == null)
        {
            System.out.println("No Cities");
            return;
        }

        // Print header
        System.out.println(String.format("%-20s ", "The top N populated cities in a region where N is provided by the user."));
        System.out.println(String.format("%-20s ", " "));
        System.out.println(String.format("%10s %-30s %-30s %-30s %-30s %10s", "row_num", "City", "Country", "District", "Region", "Population"));
        // Loop over all Retrieved Populations in the list
        for (City pop : nCityTopReg) {

            if (pop == null) continue;

            String popCount = String.format("%10s %-30s %-30s %-30s %-30s %10s", pop.row_num, pop.name, pop.country, pop.district, pop.region, pop.population);
            System.out.println(popCount);
        }
    }

    /**
     * Gets the population of all countries in a Region.
     *
     * @return A list of the population of all countries in a Region  sorted in descending order, or null if there is an error.
     */

    public ArrayList<Country> getRegionPopulation() {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT code, name, continent, region, capital, population "
                            + "FROM country "
                            + "Order By region ASC, population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract Population information
            ArrayList<Country> population3 = new ArrayList<Country>();
            while (rset.next()) {
                Country pop = new Country();
                pop.population = rset.getInt("country.population");
                pop.name = rset.getString("country.Name");
                pop.continent = rset.getString("country.continent");
                pop.capital = rset.getInt("country.capital");
                pop.region = rset.getString("country.region");
                pop.code = rset.getString("country.code");
                population3.add(pop);
            }
            return population3;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get Population details");
            return null;
        }
    }

    /**
     * Prints a list of Countries in a Region Populations.
     *
     * @param population3 The list of Countries in Continent Populations to print.
     */
    public void printRegionPopulation(ArrayList<Country> population3) {
        // Check Population is not null
        if (population3 == null)
        {
            System.out.println("No Region Population");
            return;
        }
        // Print header
        System.out.println(String.format("%-20s ", " "));
        System.out.println(String.format("%-20s ", "Population of All the countries in a Region organised by largest population to smallest."));
        System.out.println(String.format("%-20s ", " "));
        System.out.println(String.format("%-10s %10s %-50s %-30s %-30s %-30s", "Code", "Population", "Country", "Capital", "Continent", "Region"));
        // Loop over all Retrieved Populations in the list
        // Check if query returned values.
        for (Country pop : population3) {
            if (pop == null)
                continue;

            String popCount = String.format("%-10s %10s %-50s %-30s %-30s %-30s", pop.code, pop.population, pop.name, pop.capital, pop.continent, pop.region);
            System.out.println(popCount);
        }
    }

    /**
     * Query 12: The top N populated cities in the world where N is provided by the user.
     * Gets the population of all cities in the world
     *
     * @return A list of all cities sorted by population in descending order, or null if there is an error.
     */
    public ArrayList<City> getTopNCityPopWorld12() {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "WITH city as (select city.name as name, country.name as country, city.district as district, city.population as population, RANK () " +
                            "OVER(ORDER BY population DESC) row_num " +
                            "FROM city inner join country on city.countrycode = country.code) " +
                            "SELECT * FROM city  WHERE row_num <=10 ";


            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract Population information
            ArrayList<City> topNCityPopWorld12 = new ArrayList<City>();
            while (rset.next()) {
                City pop = new City();
                pop.population = rset.getInt("population");
                pop.name = rset.getString("Name");
                pop.country = rset.getString("country");
                pop.row_num = rset.getInt("row_num");
                pop.district = rset.getString("district");
                topNCityPopWorld12.add(pop);
            }
            return topNCityPopWorld12;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get Population details");
            return null;
        }
    }

    /**
     * Prints a list of Populations.
     *
     * @param topNCityPopWorld12 The list of Population to print.
     */
    public void printGetTopNCityPopWorld12(ArrayList<City> topNCityPopWorld12) {
        if (topNCityPopWorld12 == null)
        {
            System.out.println("No Countries");
            return;
        }

        // Print header
        System.out.println(String.format("%-20s ", " "));
        System.out.println(String.format("%-20s ", "The top N populated cities in the world where N is provided by the user."));
        System.out.println(String.format("%-20s ", " "));
        System.out.println(String.format("%10s %-30s %-30s %-30s %-30s", "row_num", "City", "Country", "District", "Population"));
        // Loop over all Retrieved Populations in the list

        for (City pop : topNCityPopWorld12) {

            if (pop == null)
                continue;


            String popCount = String.format("%10s %-30s %-30s %-30s %-30s", pop.row_num, pop.name, pop.country, pop.district, pop.population);
            System.out.println(popCount);
        }
    }


    /**
     * Gets All the cities in a Region.
     *
     * @return A list of all Population sorted in descending order, or null if there is an error.
     */

    public ArrayList<City> getCityPopregi() {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT ct.countryCode, c.name As Country, ct.name As  City, ct.population, c.region  " +
                            " from city as ct  Join country as c ON ct.CountryCode = c.code  " +
                            "order by c.region, ct.population desc  ";


            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract Population information
            ArrayList<City> cityPop9 = new ArrayList<City>();
            while (rset.next()) {
                City pop = new City();
                pop.population = rset.getInt("population");
                pop.name = rset.getString("city");
                pop.countryCode = rset.getString("countryCode");
                pop.country = rset.getString("Country");
                pop.region = rset.getString("region");

                cityPop9.add(pop);
            }
            return cityPop9;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get Population details");
            return null;
        }
    }

    /**
     * Prints a list of All the Cities in a region sorted by largest to smallest population.
     *
     * @param CityPop9 The list of All Cities in a region Population to print.
     */
    public void printCityPop9(ArrayList<City> CityPop9) {

        // Check employees is not null
        if (CityPop9 == null)
        {
            System.out.println("No Cities in a region");
            return;
        }
        // Print header
        System.out.println(String.format("%-20s ", " "));
        System.out.println(String.format("%-20s ", "All the Cities in a region organised by largest population to smallest."));
        System.out.println(String.format("%-20s ", " "));
        System.out.println(String.format("%-20s %-20s %-20s %-30s %10s", "Country Code", "city", "Country", "Region", "Population"));
        // Loop over all Retrieved Populations in the list
        for (City pop : CityPop9) {

            if (pop == null)
                continue;

            String popCount = String.format("%-20s %-20s %-20s %-30s %10s", pop.countryCode, pop.name, pop.country, pop.region, pop.population);
            System.out.println(popCount);
        }
    }

    /**
     * Gets the all the countries in a Region.
     *
     * @return A list of Top N Countries Population in a Region with value provide by user, or null if there is an error.
     */
    public ArrayList<Country> getTopNCountriesInRegPopulation() {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =

                    "with country as (select name, code, capital, region, continent, population, row_number() over " +
                            "(partition by region order by population desc, name desc) as row_num from country) " +
                            "select row_num, name, code, capital, region, continent, population from country where row_num <=3";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract Population information
            ArrayList<Country> topNCountriesRegPop = new ArrayList<Country>();
            while (rset.next()) {
                Country pop = new Country();
                pop.population = rset.getInt("country.population");
                pop.code = rset.getString("country.Code");
                pop.capital = rset.getInt("country.Capital");
                pop.name = rset.getString("country.Name");
                pop.continent = rset.getString("country.continent");
                pop.region = rset.getString("country.region");
                pop.row_num = rset.getInt("country.row_num");
                topNCountriesRegPop.add(pop);
            }
            return topNCountriesRegPop;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get Population details");
            return null;
        }
    }

    /**
     * Prints a list of Top N Countries Populations in a Region.
     *
     * @param topNCountriesRegPop The list of Top N Countries in a Region to print.
     */
    public void printTopNCountriesInRegPopulation(ArrayList<Country> topNCountriesRegPop) {

        // Check countries is not null
        if (topNCountriesRegPop == null)
        {
            System.out.println("No Countries");
            return;
        }

        // Print header
        System.out.println(String.format("%-20s ", " "));
        System.out.println(String.format("%-20s ", "All the TOP N countries in a Region with N value provided by user."));
        System.out.println(String.format("%-20s ", " "));
        System.out.println(String.format("%-10s %-10s %10s %-50s %-20s %-25s %-30s", "row_num", "Code", "Population", "Country", "Capital", "Continent", "Region"));
        // Loop over all Retrieved Populations in the list
        for (Country pop : topNCountriesRegPop) {

            if (pop == null)
                continue;

            String popCount = String.format("%-10s %-10s %10s %-50s %-20s %-25s %-30s", pop.row_num, pop.code, pop.population, pop.name, pop.capital, pop.continent, pop.region);
            System.out.println(popCount);
        }
    }

    public ArrayList<City> getTopCityInCountry() {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =

                    "WITH city1 as (select city.name as name, country.name as country, district, city.population as population, RANK () " +
                            "OVER(PARTITION BY country.name ORDER BY population DESC) row_num " +
                            "FROM city inner join country on city.countrycode = country.code) " +
                            "SELECT * FROM city1  WHERE row_num <=1";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract Population information
            ArrayList<City> nCityTopCtry = new ArrayList<City>();
            while (rset.next()) {
                City pop = new City();
                pop.population = rset.getInt("population");
                pop.name = rset.getString("Name");
                pop.country = rset.getString("Country");
                pop.district = rset.getString("district");
                pop.row_num = rset.getInt("row_num");
                nCityTopCtry.add(pop);
            }
            return nCityTopCtry;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get Population details");
            return null;
        }
    }

    /**
     * Prints a list of Populations.
     *
     * @param nCityTopCtry The list of Population to print.
     */
    public void printTopCityInCountry(ArrayList<City> nCityTopCtry) {

        // Check countries is not null
        if (nCityTopCtry == null)
        {
            System.out.println("No Cities");
            return;
        }

        // Print header
        System.out.println(String.format("%-20s ", "The top N populated cities in a country where N is provided by the user."));
        System.out.println(String.format("%-20s ", " "));
        System.out.println(String.format("%10s %-30s %-30s %-30s %10s", "row_num", "City", "Country", "District", "Population"));
        // Loop over all Retrieved Populations in the list
        for (City pop : nCityTopCtry) {

            if(pop == null) continue;

            String popCount = String.format("%10s %-30s %-30s %-30s %10s", pop.row_num, pop.name, pop.country, pop.district, pop.population);
            System.out.println(popCount);
        }
    }

    public Country getCountry(String code1) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "select code, population, continent, name, region "
                            + "From country "
                            + "WHERE code = '" + code1 + "'";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new employee if valid.
            // Check one is returned
            if (rset.next()) {
                Country pop = new Country();
                pop.code = rset.getString("code");
                pop.population = rset.getInt("population");
                pop.continent = rset.getString("continent");
                pop.name = rset.getString("name");
                pop.region = rset.getString("region");
                return pop;
            } else
                return null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get Country details");
            return null;
        }
    }


    public City getCity(String code2)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT ct.countryCode, c.name as Country, ct.name As  City, ct.district, ct.population " +
                            "from city as ct Join country as c ON ct.CountryCode = c.code  " +
                            "WHERE ct.countryCode = '" + code2 + "'";


            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new City if valid.
            // Check one is returned
            if (rset.next())
            {
                City pop = new City();
                pop.population = rset.getInt("population");
                pop.name = rset.getString("city");
                pop.district = rset.getString("district");
                pop.countryCode = rset.getString("countryCode");
                pop.country = rset.getString("Country");
                return pop;
            }
            else
                return null;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get City details");
            return null;
        }
    }


    public void addCountry(Country pop)
    {
        try
        {
            Statement stmt = con.createStatement();
            String strUpdate =
                    "INSERT INTO country (population, code, name, continent, region) " +
                            "VALUES (" + pop.population + ", '" + pop.code + "', '"  + pop.name + "', '" + pop.continent + "', '"  + pop.region + "')";

            stmt.execute(strUpdate);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to add Country");
        }
    }

    /**
     * Gets the top N populated cities in a continent where N is provided.
     *
     * @return A list of the top N populated cities in a continent where N was provided  sorted in descending order, or null if there is an error.
     */

    public ArrayList<City> getTopNPopCitiesContinent(int Limit1) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "WITH continent as (select city.name as name, country.name as country, district, country.continent as continent, city.population as population, RANK () "
                            + "OVER(PARTITION BY continent ORDER BY population DESC) row_num "
                            + "FROM city inner join country on city.countrycode = country.code) "
                            + "SELECT  row_num, name, country, district, population FROM continent  WHERE row_num <=" + Limit1;
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract Population information
            ArrayList<City> population16 = new ArrayList<City>();
            while (rset.next()) {
                City pop = new City();
                pop.row_num = rset.getInt("row_num");
                pop.name = rset.getString("name");
                pop.country = rset.getString("country");
                pop.district = rset.getString("district");
                pop.population = rset.getInt("population");
                population16.add(pop);
            }
            return population16;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get Population details");
            return null;
        }
    }

    /**
     * Prints a list of the top N populated cities in a continent where N is provided.
     *
     * @param population16 The list of  the top N populated cities in a continent where N was provided to print.
     */
    public void printTopNPopCitiesContinent(ArrayList<City> population16) {
        // Check Population is not null
        if (population16 == null)
        {
            System.out.println("No Top City Population");
            return;
        }
        // Print header
        System.out.println(String.format("%-20s ", " "));
        System.out.println(String.format("%-20s ", "The Top N populated cities in a continent where N was provided."));
        System.out.println(String.format("%-20s ", " "));
        System.out.println(String.format("%10s %-40s %-40s %-40s %30s", "No.", "Name", "Country", "District", "Population"));
        // Loop over all Retrieved Populations in the list
        // Check if query returned values.
        for (City pop : population16) {
            if (pop == null)
                continue;

            String popCount = String.format("%10s %-40s %-40s %-40s %30s", pop.row_num, pop.name, pop.country,  pop.district, pop.population);
            System.out.println(popCount);
        }
    }


    /**
     * Gets the top N populated cities in a Region where N is provided.
     *
     * @return A list of the top N populated cities in a Region where N was provided  sorted in descending order, or null if there is an error.
     */

    public ArrayList<City> getTopNPopCitiesRegion(int Limit1) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "WITH continent as (select city.name as name, country.name as country, district, country.region as region, city.population as population, RANK () "
                            + "OVER(PARTITION BY region ORDER BY population DESC) row_num "
                            + "FROM city inner join country on city.countrycode = country.code) "
                            + "SELECT  row_num, name, country, district, population FROM continent  WHERE row_num <=" + Limit1;
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract Population information
            ArrayList<City> population17 = new ArrayList<City>();
            while (rset.next()) {
                City pop = new City();
                pop.row_num = rset.getInt("row_num");
                pop.name = rset.getString("name");
                pop.country = rset.getString("country");
                pop.district = rset.getString("district");
                pop.population = rset.getInt("population");
                population17.add(pop);
            }
            return population17;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get Population details");
            return null;
        }
    }

    /**
     * Prints a list of the top N populated cities in a Region where N is provided.
     *
     * @param population17 The list of  the top N populated cities in a region where N was provided to print.
     */
    public void printTopNPopCitiesRegion(ArrayList<City> population17) {
        // Check Population is not null
        if (population17 == null)
        {
            System.out.println("No Top City Population");
            return;
        }
        // Print header
        System.out.println(String.format("%-20s ", " "));
        System.out.println(String.format("%-20s ", "The Top N populated cities in a Region where N was provided."));
        System.out.println(String.format("%-20s ", " "));
        System.out.println(String.format("%10s %-40s %-40s %-40s %30s", "No.", "Name", "Country", "District", "Population"));
        // Loop over all Retrieved Populations in the list
        // Check if query returned values.
        for (City pop : population17) {
            if (pop == null)
                continue;

            String popCount = String.format("%10s %-40s %-40s %-40s %30s", pop.row_num, pop.name, pop.country,  pop.district, pop.population);
            System.out.println(popCount);
        }
    }

    /**
     * Gets the top N populated cities in a Country where N is provided.
     *
     * @return A list of the top N populated cities in a Country where N was provided  sorted in descending order, or null if there is an error.
     */

    public ArrayList<City> getTopNPopCitiesCountry(int Limit1) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "WITH countrytemp as (select city.name as name1, country.name, district, country.region as region, city.population as population, RANK ()  "
                            + "OVER(PARTITION BY country.name ORDER BY population DESC) row_num "
                            + "FROM city inner join country on city.countrycode = country.code) "
                            + "SELECT  row_num, name1 as name, name as country, district, population FROM countrytemp  WHERE row_num <=" + Limit1;
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract Population information
            ArrayList<City> population18 = new ArrayList<City>();
            while (rset.next()) {
                City pop = new City();
                pop.row_num = rset.getInt("row_num");
                pop.name = rset.getString("name");
                pop.country = rset.getString("country");
                pop.district = rset.getString("district");
                pop.population = rset.getInt("population");
                population18.add(pop);
            }
            return population18;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get Population details");
            return null;
        }
    }

    /**
     * Prints a list of the top N populated cities in a Country where N is provided.
     *
     * @param population18 The list of  the top N populated cities in a Country where N was provided to print.
     */
    public void printTopNPopCitiesCountry(ArrayList<City> population18) {
        // Check Population is not null
        if (population18 == null)
        {
            System.out.println("No Top City Population");
            return;
        }
        // Print header
        System.out.println(String.format("%-20s ", " "));
        System.out.println(String.format("%-20s ", "The Top N populated cities in a Country where N was provided."));
        System.out.println(String.format("%-20s ", " "));
        System.out.println(String.format("%10s %-40s %-40s %-40s %30s", "No.", "Name", "Country", "District", "Population"));
        // Loop over all Retrieved Populations in the list
        // Check if query returned values.
        for (City pop : population18) {
            if (pop == null)
                continue;

            String popCount = String.format("%10s %-40s %-40s %-40s %30s", pop.row_num, pop.name, pop.country,  pop.district, pop.population);
            System.out.println(popCount);
        }
    }

    /**
     * Gets the top N populated cities in a District where N is provided.
     *
     * @return A list of the top N populated cities in a District where N was provided  sorted in descending order, or null if there is an error.
     */

    public ArrayList<City> getTopNPopCitiesDistrict(int Limit1) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "WITH district as (select city.name as name, country.name as country, district, city.population as population, RANK ()  "
                            + "OVER(PARTITION BY district ORDER BY population DESC) row_num "
                            + "FROM city inner join country on city.countrycode = country.code) "
                            + "SELECT row_num, name, country, district, population FROM district  WHERE row_num <=" + Limit1;
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract Population information
            ArrayList<City> population19 = new ArrayList<City>();
            while (rset.next()) {
                City pop = new City();
                pop.row_num = rset.getInt("row_num");
                pop.name = rset.getString("name");
                pop.country = rset.getString("country");
                pop.district = rset.getString("district");
                pop.population = rset.getInt("population");
                population19.add(pop);
            }
            return population19;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get Population details");
            return null;
        }
    }

    /**
     * Prints a list of the top N populated cities in a District where N is provided.
     *
     * @param population19 The list of  the top N populated cities in a District where N was provided to print.
     */
    public void printTopNPopCitiesDistrict(ArrayList<City> population19) {
        // Check Population is not null
        if (population19 == null)
        {
            System.out.println("No Top City Population");
            return;
        }
        // Print header
        System.out.println(String.format("%-20s ", " "));
        System.out.println(String.format("%-20s ", "The Top N populated cities in a District where N was provided."));
        System.out.println(String.format("%-20s ", " "));
        System.out.println(String.format("%10s %-40s %-40s %-40s %30s", "No.", "Name", "Country", "District", "Population"));
        // Loop over all Retrieved Populations in the list
        // Check if query returned values.
        for (City pop : population19) {
            if (pop == null)
                continue;

            String popCount = String.format("%10s %-40s %-40s %-40s %30s", pop.row_num, pop.name, pop.country,  pop.district, pop.population);
            System.out.println(popCount);
        }
    }

    /**
     * Gets the All the capital cities in the world organised by largest population to smallest.
     *
     * @return A list of All the capital cities in the world organised by largest population to smallest, or null if there is an error.
     */

    public ArrayList<City> getAllCapCitiesWorld() {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "select city.name as name, country.name as country, district, country.population as population "
                            + "FROM city inner join country on city.id = country.capital "
                            + "ORDER BY population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract Population information
            ArrayList<City> population20 = new ArrayList<City>();
            while (rset.next()) {
                City pop = new City();
                pop.name = rset.getString("name");
                pop.country = rset.getString("country");
                pop.population = rset.getInt("population");
                population20.add(pop);
            }
            return population20;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get Population details");
            return null;
        }
    }

    /**
     * Prints a list of All the capital cities in the world organised by largest population to smallest..
     *
     * @param population20 The list of All the capital cities in the world organised by largest population to smallest to print.
     */
    public void printAllCapCitiesWorld(ArrayList<City> population20) {
        // Check Population is not null
        if (population20 == null)
        {
            System.out.println("No Capital City Population");
            return;
        }
        // Print header
        System.out.println(String.format("%-20s ", " "));
        System.out.println(String.format("%-20s ", "All the capital cities in the world organised by largest population to smallest."));
        System.out.println(String.format("%-20s ", " "));
        System.out.println(String.format("%-40s %-40s %30s", "Name", "Country", "Population"));
        // Loop over all Retrieved Populations in the list
        // Check if query returned values.
        for (City pop : population20) {
            if (pop == null)
                continue;

            String popCount = String.format("%-40s %-40s %30s", pop.name, pop.country, pop.population);
            System.out.println(popCount);
        }
    }

    /**
     * Gets the All the capital cities in a Continent organised by largest population to smallest.
     *
     * @return A list of All the capital cities in a Continent organised by largest population to smallest, or null if there is an error.
     */

    public ArrayList<City> getAllCapCitiesContinent( String cont1) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "select city.name as name, country.name as country, country.continent as continent, city.population as population "
                            + "FROM city inner join country on city.id = country.capital "
                            + "WHERE continent = '"+ cont1 +"' "
                            + "ORDER BY population DESC ";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract Population information
            ArrayList<City> population21 = new ArrayList<City>();
            while (rset.next()) {
                City pop = new City();
                pop.name = rset.getString("name");
                pop.country = rset.getString("country");
                pop.population = rset.getInt("population");
                population21.add(pop);
            }
            return population21;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get Population details");
            return null;
        }
    }

    /**
     * Prints a list of All the capital cities in a Continent organised by largest population to smallest..
     *
     * @param population21 The list of All the capital cities in a Continent organised by largest population to smallest to print.
     */
    public void printAllCapCitiesContinent(ArrayList<City> population21) {
        // Check Population is not null
        if (population21 == null)
        {
            System.out.println("No Capital City Population");
            return;
        }
        // Print header
        System.out.println(String.format("%-20s ", " "));
        System.out.println(String.format("%-20s ", "All the capital cities in a Continent organised by largest population to smallest."));
        System.out.println(String.format("%-20s ", " "));
        System.out.println(String.format("%-40s %-40s %30s", "Name", "Country", "Population"));
        // Loop over all Retrieved Populations in the list
        // Check if query returned values.
        for (City pop : population21) {
            if (pop == null)
                continue;

            String popCount = String.format("%-40s %-40s %30s", pop.name, pop.country, pop.population);
            System.out.println(popCount);
        }
    }

    /**
     * Gets the All the capital cities in a Continent organised by largest population to smallest.
     *
     * @return A list of All the capital cities in a Continent organised by largest population to smallest, or null if there is an error.
     */

    public ArrayList<City> getAllCapCitiesRegion( String reg1) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "select city.name as name, country.name as country, country.region as region, city.population as population "
                            + "FROM city inner join country on city.id = country.capital "
                            + "WHERE region = '"+ reg1 +"' "
                            + "ORDER BY population DESC ";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract Population information
            ArrayList<City> population22 = new ArrayList<City>();
            while (rset.next()) {
                City pop = new City();
                pop.name = rset.getString("name");
                pop.country = rset.getString("country");
                pop.population = rset.getInt("population");
                population22.add(pop);
            }
            return population22;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get Population details");
            return null;
        }
    }

    /**
     * Prints a list of All the capital cities in a Region organised by largest population to smallest..
     *
     * @param population22 The list of All the capital cities in a Region organised by largest population to smallest to print.
     */
    public void printAllCapCitiesRegion(ArrayList<City> population22) {
        // Check Population is not null
        if (population22 == null)
        {
            System.out.println("No Capital City Population");
            return;
        }
        // Print header
        System.out.println(String.format("%-20s ", " "));
        System.out.println(String.format("%-20s ", "All the capital cities in a Region organised by largest population to smallest."));
        System.out.println(String.format("%-20s ", " "));
        System.out.println(String.format("%-40s %-40s %30s", "Name", "Country", "Population"));
        // Loop over all Retrieved Populations in the list
        // Check if query returned values.
        for (City pop : population22) {
            if (pop == null)
                continue;

            String popCount = String.format("%-40s %-40s %30s", pop.name, pop.country, pop.population);
            System.out.println(popCount);
        }
    }


    /**
     * Gets the top N populated capital cities in the world where N is provided.
     *
     * @return A list of the top N populated cities in the world where N was provided  sorted in descending order, or null if there is an error.
     */

    public ArrayList<City> getTopNPopCapCitiesWorld(int Limit1) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "select city.name as name, country.name as country, country.population as population  "
                            + "FROM city inner join country on city.id = country.capital "
                            + "ORDER BY population DESC Limit " + Limit1;
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract Population information
            ArrayList<City> population23 = new ArrayList<City>();
            while (rset.next()) {
                City pop = new City();
                pop.name = rset.getString("name");
                pop.country = rset.getString("country");
                pop.population = rset.getInt("population");
                population23.add(pop);
            }
            return population23;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get Population details");
            return null;
        }
    }

    /**
     * Prints a list of the top N populated cities in a continent where N is provided.
     *
     * @param population23 The list of  the top N populated Capital cities in the world where N was provided to print.
     */
    public void printTopNPopCapCitiesWorld(ArrayList<City> population23) {
        // Check Population is not null
        if (population23 == null)
        {
            System.out.println("No Top Capital City Population");
            return;
        }
        // Print header
        System.out.println(String.format("%-20s ", " "));
        System.out.println(String.format("%-20s ", "The Top N populated Capital cities in a continent where N was provided."));
        System.out.println(String.format("%-20s ", " "));
        System.out.println(String.format("%-40s %-40s %30s", "Name", "Country", "Population"));
        // Loop over all Retrieved Populations in the list
        // Check if query returned values.
        for (City pop : population23) {
            if (pop == null)
                continue;

            String popCount = String.format("%-40s %-40s %30s", pop.name, pop.country, pop.population);
            System.out.println(popCount);
        }
    }


    /**
     * Gets the top N populated Capital cities in a Continent where N and Continent are provided.
     *
     * @return A list of the top N populated Capital cities in a Continent where N and Continent were provided  sorted in descending order, or null if there is an error.
     */

    public ArrayList<City> getTopNPopCapCitiesContinent(String cont1, int Limit1) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.name as name , country.name as country, city.population as population  "
                            + "FROM city inner join country on city.id = country.capital "
                            + "WHERE continent = '" + cont1 + "' "
                            + "ORDER BY population desc Limit " + Limit1;
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract Population information
            ArrayList<City> population24 = new ArrayList<City>();
            while (rset.next()) {
                City pop = new City();
                pop.name = rset.getString("name");
                pop.country = rset.getString("country");
                pop.population = rset.getInt("population");
                population24.add(pop);
            }
            return population24;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get Capital City Population details");
            return null;
        }
    }

    /**
     * Prints a list of the top N populated Capital cities in a Continent where N and Continent are provided.
     *
     * @param population24 The list of  the top N populated Capital cities in a Continent where N and continent were provided to print.
     */
    public void printTopNPopCapCitiesContinent(ArrayList<City> population24) {
        // Check Population is not null
        if (population24 == null)
        {
            System.out.println("No Top Capital City Population");
            return;
        }
        // Print header
        System.out.println(String.format("%-20s ", " "));
        System.out.println(String.format("%-20s ", "The Top N populated Capital cities in a District where N and continent was provided."));
        System.out.println(String.format("%-20s ", " "));
        System.out.println(String.format("%10s %-40s %-40s %30s", "No.", "Name", "Country", "Population"));
        // Loop over all Retrieved Populations in the list
        // Check if query returned values.
        for (City pop : population24) {
            if (pop == null)
                continue;

            String popCount = String.format("%-40s %-40s %30s", pop.name, pop.country, pop.population);
            System.out.println(popCount);
        }
    }

    /**
     * Gets the top N populated Capital cities in a Region where N and Region are provided.
     *
     * @return A list of the top N populated Capital cities in a Region where N  and Region were provided  sorted in descending order, or null if there is an error.
     */

    public ArrayList<City> getTopNPopCapCitiesRegion(String reg1, int Limit1) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.name as name , country.name as country, city.population as population  "
                            + "FROM city inner join country on city.id = country.capital "
                            + "WHERE region = '" + reg1 + "' "
                            + "ORDER BY population desc Limit " + Limit1;
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract Population information
            ArrayList<City> population25 = new ArrayList<City>();
            while (rset.next()) {
                City pop = new City();
                pop.name = rset.getString("name");
                pop.country = rset.getString("country");
                pop.population = rset.getInt("population");
                population25.add(pop);
            }
            return population25;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get Capital City Population details");
            return null;
        }
    }

    /**
     * Prints a list of the top N populated Capital cities in a Region where N and Region are provided.
     *
     * @param population25 The list of  the top N populated Capital cities in a Region where N and Region were provided to print.
     */
    public void printTopNPopCapCitiesRegion(ArrayList<City> population25) {
        // Check Population is not null
        if (population25 == null)
        {
            System.out.println("No Top Capital City Population");
            return;
        }
        // Print header
        System.out.println(String.format("%-20s ", " "));
        System.out.println(String.format("%-20s ", "The Top N populated Capital cities in a Region where N and Region was provided."));
        System.out.println(String.format("%-20s ", " "));
        System.out.println(String.format("%-40s %-40s %30s", "Name", "Country", "Population"));
        // Loop over all Retrieved Populations in the list
        // Check if query returned values.
        for (City pop : population25) {
            if (pop == null)
                continue;

            String popCount = String.format("%-40s %-40s %30s", pop.name, pop.country, pop.population);
            System.out.println(popCount);
        }
    }
}