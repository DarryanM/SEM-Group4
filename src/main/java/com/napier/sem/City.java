package com.napier.sem;

import java.math.BigDecimal;
import java.math.BigInteger;

public class City {
    /**
     * City Population
     */
    public int population;
    /**
     * City Information
     */
    public String name;

    public String countryCode;

    public String district;

    public String country;

    public String continent;

    public int row_num;

    public String region;

    //Total Country Population
    public BigDecimal countrypop;

    //Total City Population
    public BigDecimal citypop;

    //Total Non City Population
    public BigDecimal noncitypop;

    // total Region Population
    public BigDecimal regionpop;

    //Total Continent Population
    public BigDecimal continentpop;

    //Percentage of people in city
    public double citypoppercent;

    //Percentage of people not living in city
    public double noncitypoppercent;
}
