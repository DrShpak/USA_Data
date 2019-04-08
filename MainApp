package csv;

import java.io.IOException;
import java.util.ArrayList;

public class MainApp {

    private static final String PATH_TO_FILE = "/Users/test/Downloads/Data USA Cart.csv";

    public static void main(String[] args) throws IOException {

        ArrayList<Country> countries = Utils.createCountriesList(Utils.readFile(PATH_TO_FILE));
        ArrayList<Country> topCountries = Utils.peekTopCountries(countries);
        topCountries.forEach(System.out::println);


        System.out.println("\nPrediction to next year:\n");
        for (Country country : topCountries) {
            System.out.println(country.getName() + "\n" +
                    "population in next year: " + Utils.predict(country) + "\n");
        }
    }
}
