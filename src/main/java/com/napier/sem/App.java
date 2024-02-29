package com.napier.sem;

import java.sql.*;
import java.util.*;

public class App {
    public static void main(String[] args) {
        // Create new Application
        App a = new App();

        // Connect to database
        a.connect();

         // City Population
        ArrayList<City> citypopulation = a.getCityPopulation();

        //Display Results
        a.printCityPopulation(citypopulation);

        // Extract City Population
        ArrayList<City> cityPop = a.getCityPop();

        //Display Results
        a.printCityPop(cityPop);


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
    public void connect() {
        try {
            // Load Database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 10;
        for (int i = 0; i < retries; ++i) {
            System.out.println("Connecting to database...");
            try {
                // Wait a bit for db to start
                Thread.sleep(30000);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://db:3306/world?useSSL=false", "root", "example");
                System.out.println("Successfully connected");
                break;
            } catch (SQLException sqle) {
                System.out.println("Failed to connect to database attempt " + Integer.toString(i));
                System.out.println(sqle.getMessage());
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

    public ArrayList<City> getCityPop()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.name AS city, city.population, country.name AS country " +
                            "FROM city " +
                            "INNER JOIN country ON city.countrycode = country.code " +
                            "ORDER BY country ASC, population DESC " +
                            "LIMIT 10";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract Population information
            ArrayList<City> population = new ArrayList<>();
            while (rset.next())
            {
                City citypopulation = new City();
                citypopulation.population = rset.getInt("city.population");
                citypopulation.name = rset.getString("city");
                citypopulation.country = rset.getString("country");

                population.add(citypopulation);
            }
            return population;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get Population details");
            return null;
        }
    }

    public void printCityPopulation(ArrayList<City> citypopulation)
    {
        // Print header
        System.out.println(String.format("Cities in a country from largest to smallest population"));
        System.out.println(String.format("%-20s %-20s %-30s", "City", "Country", "Population"));
        // Loop over all Retrieved Populations in the list
        for (City pop : citypopulation)
        {
            String popCount = String.format("%-20s %-20s %-30s", pop.name, pop.country, pop.population);
            System.out.println(popCount);
        }
    }

    /**
     * Gets the population of all countries.
     * @return A list of all Population sorted in descending order, or null if there is an error.
     */
    public ArrayList<City> getCityPopulation()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT name, countryCode, district, population "
                            + "FROM city "
                            + "Order By population DESC "
                            + "Limit 10";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract Population information
            ArrayList<City> cityPop = new ArrayList<City>();
            while (rset.next())
            {
                City pop = new City();
                pop.population = rset.getInt("city.population");
                pop.name = rset.getString("city.Name");
                pop.district = rset.getString("city.district");
                pop.countryCode = rset.getString("city.countryCode");
                cityPop.add(pop);
            }
            return cityPop;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get Population details");
            return null;
        }
    }
    /**
     * Prints a list of Populations.
     * @param CityPop The list of Population to print.
     */
    public void printCityPop(ArrayList<City> CityPop)
    {
        // Print header
        System.out.println(String.format("%-20s ", "All the Cities in the world organised by largest population to smallest."));
        System.out.println(String.format("%-20s ", " "));
        System.out.println(String.format("%-20s %-20s %-30s %10s", "Name", "Country Code", "District", "Population"));
        // Loop over all Retrieved Populations in the list
        for (City pop : CityPop)
        {

            String popCount = String.format("%-20s %-20s %-30s %10s", pop.name, pop.countryCode, pop.district, pop.population);
            System.out.println(popCount);
        }
    }
}


