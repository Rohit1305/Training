package com.aurionpro.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.aurionpro.model.Country;
import java.util.*;
public class CountryTest {

    public static void main(String[] args) {
        List<Country> countries = initializeCountries();
        Map<Integer, String> regionMap = initializeRegionMap();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Region ID: ");
        int regionID = sc.nextInt();

        if (regionMap.containsKey(regionID)) {
            List<String> countryNames = getCountriesByRegion(countries, regionID);
            System.out.println("Countries in " + regionMap.get(regionID) + ": " + countryNames);
            System.out.println("Number of countries: " + countryNames.size());
        } else {
            System.out.println("Invalid Region ID");
        }

        System.out.print("Enter Country Code: ");
        String countryCode = sc.next().toUpperCase();

        String countryName = getCountryNameByCode(countries, countryCode);
        if (countryName != null) {
            System.out.println("Country Name: " + countryName);
        } else {
            System.out.println("Country Code Not Found");
        }
    }

    private static List<Country> initializeCountries() {
        return Arrays.asList(
            new Country("IT", "Italy", 1),
            new Country("JP", "Japan", 3),
            new Country("US", "United States of America", 2), 
            new Country("CA", "Canada", 2),
            new Country("CN", "China", 3), 
            new Country("IN", "India", 3), 
            new Country("AU", "Australia", 3),
            new Country("ZW", "Zimbabwe", 4), 
            new Country("SG", "Singapore", 3),
            new Country("UK", "United Kingdom", 1), 
            new Country("FR", "France", 1), 
            new Country("DE", "Germany", 1),
            new Country("ZM", "Zambia", 4), 
            new Country("EG", "Egypt", 4), 
            new Country("BR", "Brazil", 2),
            new Country("CH", "Switzerland", 1), 
            new Country("NL", "Netherlands", 1),
            new Country("MX", "Mexico", 2), 
            new Country("KW", "Kuwait", 4), 
            new Country("IL", "Israel", 4),
            new Country("DK", "Denmark", 1),
            new Country("HK", "HongKong", 3), 
            new Country("NG", "Nigeria", 4),
            new Country("AR", "Argentina", 2), 
            new Country("BE", "Belgium", 1));
    };
    

    private static Map<Integer, String> initializeRegionMap() {
        Map<Integer, String> regionMap = new HashMap<>();
        regionMap.put(1, "Europe");
        regionMap.put(2, "America");
        regionMap.put(3, "Asia");
        regionMap.put(4, "Africa");
        return regionMap;
    }

    private static List<String> getCountriesByRegion(List<Country> countries, int regionID) {
        List<String> countryNames = new ArrayList<>();
        for (Country country : countries) {
            if (country.getRegionID() == regionID) {
                countryNames.add(country.getCountryName());
            }
        }
        return countryNames;
    }

    private static String getCountryNameByCode(List<Country> countries, String countryCode) {
        for (Country country : countries) {
            if (country.getCountryCode().equalsIgnoreCase(countryCode)) {
                return country.getCountryName();
            }
        }
        return null;
    }
}



