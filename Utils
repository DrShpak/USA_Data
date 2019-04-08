package csv;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class Utils {

    private static final Integer beginYear = 2013;

    static ArrayList<String> readFile(String path) throws IOException {
        return (ArrayList<String>) Files.readAllLines(Paths.get(path));
    }

    private static String[] split(String string) {
        return string.split(",");
    }

    private static String createString(String[] stringArray) {
        StringBuilder sb = new StringBuilder();
        for (String element : stringArray) {
            sb.append(element).append(" ");
        }

        return sb.toString();
    }

    private static Country createCountry(String[] stringArray) {
        Country country = new Country();
        LinkedHashMap<Integer, Integer> population = new LinkedHashMap<>();
        Integer year = beginYear;
        for (String element : stringArray) {
            if (isParsable(element)) {
                population.put(year, Integer.parseInt(element));
                year++;
            }
        }

        if (!population.isEmpty()) {
            country.setName(stringArray[0].substring(1));
            country.setPopulation(population);
            return country;
        }
        return null;
    }

    private static boolean isParsable(String input) {
        boolean parsable = true;
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            parsable = false;
        }
        return parsable;
    }

    static ArrayList<Country> createCountriesList(ArrayList<String> sourceList) {
        ArrayList<Country> countries = new ArrayList<>();
//        sourceList.forEach(string -> countries.add(createCountry(split(string))));
        for (String string : sourceList) {
            Country currCountry = createCountry(split(string));
            if (currCountry != null) {
                countries.add(currCountry);
            }
        }
        return countries;
    }

    static ArrayList<Country> peekTopCountries(ArrayList<Country> countries) {
        ArrayList<Country> topCountries = new ArrayList<>();
        ArrayList<Country> countriesCopy = new ArrayList<>(countries);
        for (int i = 0; i < 5; i++) {
            topCountries.add(returnTopCountry(countriesCopy));
        }
        return topCountries;
    }

    private static Country returnTopCountry(ArrayList<Country> countriesCopy) {
        double maxChange = Integer.MIN_VALUE;
        Country currTopCountry = countriesCopy.get(0);
        for (Country country : countriesCopy) {
            double currChange = calculateAverageChangePopulation(country.getPopulation());
            if (currChange > maxChange) {
                maxChange = currChange;
                currTopCountry = country;
            }
        }

        currTopCountry.setChangePopulation(maxChange);
        countriesCopy.remove(currTopCountry);
        return currTopCountry;
    }

    private static double calculateAverageChangePopulation(LinkedHashMap<Integer, Integer> population) {
        Iterator<Map.Entry<Integer, Integer>> it = population.entrySet().iterator();
        Map.Entry<Integer, Integer> prev = it.next();
        ArrayList<Double> changes = new ArrayList<>();
        while (((Iterator) it).hasNext()) {
            Map.Entry<Integer, Integer> curr = it.next();
            Double changePercent = (curr.getValue() * 100.0) / prev.getValue() - 100;
            changes.add(changePercent);
            prev = curr;
        }

        return Math.round(calculateSumOfPercents(changes) / population.size() * 100.0) / 100D;
    }

    private static double calculateSumOfPercents(ArrayList<Double> changes) {
        double sum = 0;
        for (Double percent : changes) {
            sum += percent;
        }
        return sum;
    }

    static int predict(Country country) {
        return (int) ((100 + country.getChangePopulation()) * country.getPopulation().get(2016) / 100);
    }
}
