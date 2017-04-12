package homework.proj11;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Steven Lariscy
 * @projectNumber PL004T
 * @date 4.12.2017
 * @dueDate 4.13.2017
 * @description Travel Mileage Calculator
 */
public class TMRData {
    
    // instance variables
    private final List<Cities> citiesVisited;
    private final int totalCitiesVisited;

    // constructor
    public TMRData(int numCitiesVisited) {
        this.totalCitiesVisited = numCitiesVisited + 2;
        this.citiesVisited = new ArrayList<>(this.totalCitiesVisited);
    } // end constructor
    
    public boolean isFull(){
        return !(this.citiesVisited.size() < this.totalCitiesVisited - 1);
    } // end isFull
    
    public void addCity(Cities city){
        this.citiesVisited.add(city);
    } // end addCity

    public List<Cities> getCitiesVisited() {
        return citiesVisited;
    } // end getCitiesVisited
    
} // end class
