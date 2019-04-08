package csv;

import java.util.LinkedHashMap;

public class Country {

    private String name;
    private LinkedHashMap<Integer, Integer> population;
    private double changePopulation;

    Country() {

    }

    String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LinkedHashMap<Integer, Integer> getPopulation() {
        return population;
    }

    public void setPopulation(LinkedHashMap<Integer, Integer> population) {
        this.population = population;
    }

    public double getChangePopulation() {
        return changePopulation; 
    }

    public void setChangePopulation(double changePopulation) {
        this.changePopulation = changePopulation;
    }

    @Override
    public String toString() {
        return name +
                "\n 2013 year: " + population.get(2013) +
                "\n 2014 year: " + population.get(2014) +
                "\n 2015 year: " + population.get(2015) +
                "\n 2016 year: " + population.get(2016) +
                "\n средний прирост (в процентах) " + changePopulation + " %" +
                "\n";
    }
}
