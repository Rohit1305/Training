import java.util.*;

public class RegionCountryMapping {
    public static void main(String[] args) {
        Map<Integer, String> regionMap = new HashMap<>();
        regionMap.put(1, "Europe");
        regionMap.put(2, "Americas");
        regionMap.put(3, "Asia");
        regionMap.put(4, "Middle East and Africa");

        Map<String, Map<String, Integer>> countryMap = new HashMap<>();
        addCountry(countryMap, "IT", "Italy", 1);
        addCountry(countryMap, "JP", "Japan", 3);
        addCountry(countryMap, "US", "United States of America", 2);
        addCountry(countryMap, "CA", "Canada", 2);
        addCountry(countryMap, "CN", "China", 3);
        addCountry(countryMap, "IN", "India", 3);
        addCountry(countryMap, "AU", "Australia", 3);
        addCountry(countryMap, "ZW", "Zimbabwe", 4);
        addCountry(countryMap, "SG", "Singapore", 3);
        addCountry(countryMap, "UK", "United Kingdom", 1);
        addCountry(countryMap, "FR", "France", 1);
        addCountry(countryMap, "DE", "Germany", 1);
        addCountry(countryMap, "ZM", "Zambia", 4);
        addCountry(countryMap, "EG", "Egypt", 4);
        addCountry(countryMap, "BR", "Brazil", 2);
        addCountry(countryMap, "CH", "Switzerland", 1);
        addCountry(countryMap, "NL", "Netherlands", 1);
        addCountry(countryMap, "MX", "Mexico", 2);
        addCountry(countryMap, "KW", "Kuwait", 4);
        addCountry(countryMap, "IL", "Israel", 4);
        addCountry(countryMap, "DK", "Denmark", 1);
        addCountry(countryMap, "HK", "Hong Kong", 3);
        addCountry(countryMap, "NG", "Nigeria", 4);
        addCountry(countryMap, "AR", "Argentina", 2);
        addCountry(countryMap, "BE", "Belgium", 1);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a country code or ID: ");
        String userInput = scanner.nextLine();
        scanner.close();

        Map<String, Integer> countryInfo;

        if (userInput.length() == 2) {
            countryInfo = getCountryInfoByCode(countryMap, userInput);
        } else {
            try {
                int userInputId = Integer.parseInt(userInput);
                countryInfo = getCountryInfoById(countryMap, userInputId);
            } catch (NumberFormatException e) {
                countryInfo = null;
            }
        }

        if (countryInfo != null) {
            String countryCode = countryInfo.keySet().iterator().next();
            String countryName = countryMap.get(countryCode).keySet().iterator().next();
            Integer regionCode = getRegionCode(countryCode);
            String regionName = regionMap.get(regionCode);
            System.out.println("Country Code: " + countryCode);
            System.out.println("Country Name: " + countryName);
            System.out.println("Region: " + regionName);
        } else {
            System.out.println("Country not found for input: " + userInput);
        }
    }

    public static Map<String, Integer> getCountryInfoByCode(Map<String, Map<String, Integer>> countryMap, String code) {
        return countryMap.get(code);
    }

    public static Map<String, Integer> getCountryInfoById(Map<String, Map<String, Integer>> countryMap, int id) {
        for (Map<String, Integer> countryInfo : countryMap.values()) {
            if (countryInfo.containsValue(id)) {
                return countryInfo;
            }
        }
        return null; 
    }

    public static void addCountry(Map<String, Map<String, Integer>> countryMap, String code, String name, Integer id) {
        Map<String, Integer> countryInfo = new HashMap<>();
        countryInfo.put(name, id);
        countryMap.put(code, countryInfo);
    }


    private static Integer getRegionCode(String countryCode) {
        switch (countryCode) {
            case "IT":
            case "UK":
            case "FR":
            case "DE":
            case "CH":
            case "NL":
            case "DK":
            case "BE":
                return 1;
            case "US":
            case "CA":
            case "BR":
            case "MX":
            case "AR":
                return 2;
            case "JP":
            case "CN":
            case "IN":
            case "AU":
            case "SG":
            case "HK":
                return 3;
            case "ZW":
            case "ZM":
            case "EG":
            case "KW":
            case "IL":
            case "NG":
                return 4;
            default:
                return -1;
        }
    }


    private static String getRegionName(String countryCode) {
        Map<Integer, String> regionMap = new HashMap<>();
        regionMap.put(1, "Europe");
        regionMap.put(2, "Americas");
        regionMap.put(3, "Asia");
        regionMap.put(4, "Middle East and Africa");

        Integer regionCode = null;

        for (Map.Entry<Integer, String> entry : regionMap.entrySet()) {
            if (entry.getValue().equals(countryCode)) {
                regionCode = entry.getKey();
                break;
            }
        }

        if (regionCode != null) {
            return regionMap.get(regionCode);
        } else {
            return "Unknown";
        }
    }
}
