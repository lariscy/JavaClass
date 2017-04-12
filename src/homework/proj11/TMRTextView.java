package homework.proj11;

import java.util.Scanner;

/**
 * @author Steven Lariscy
 * @projectNumber PL004T
 * @date 4.12.2017
 * @dueDate 4.13.2017
 * @description Travel Mileage Calculator
 */
public class TMRTextView {

    // instance variables
    private final Scanner keyboard;
    
    // constructor
    public TMRTextView(Scanner keyboard) {
        this.keyboard = keyboard;
    } // end constructor

    public void play() {
        this.showWelcome();
        
        System.out.print("-> How many cities were visited: ");
        int numCitiesVisited = Integer.parseInt(this.keyboard.nextLine());
        
        System.out.println("Choose starting city:");
        this.showCitiesOptions();
        System.out.print("-> Option: ");
        Cities startingCity = Cities.values()[Integer.parseInt(this.keyboard.nextLine())];
        
        TMRData cityData = new TMRData(numCitiesVisited);
        cityData.addCity(startingCity);
        
        Cities currentCity = startingCity;
        do { // while (!data.isFull())
            System.out.println("Choose next city: ");
            this.showCitiesOptions(currentCity);
            System.out.print("-> Option ("+currentCity.getSimpleName()+" -> ?): ");
            currentCity = Cities.values()[Integer.parseInt(this.keyboard.nextLine())];
            cityData.addCity(currentCity);
        } while (!cityData.isFull()); // end do-while
        
        cityData.addCity(startingCity);
        
        System.out.println("");
        System.out.println("-- Results --");
        
        int miles;
        for (int i=0; i<(cityData.getCitiesVisited().size() - 1); i++){
            System.out.println(cityData.getCitiesVisited().get(i) + " -> " +
                    cityData.getCitiesVisited().get(i + 1));
            miles = TMRCalculator.getMilesBetweenCities(
                    cityData.getCitiesVisited().get(i),
                    cityData.getCitiesVisited().get(i + 1)
            );
            System.out.println("\tMiles   : " + miles);
            System.out.println("\tCurrency: " + TMRCalculator.getMoneyForMiles(miles));
        } // end for
    } // end play

    private void showWelcome() {
        System.out.println("*************************************************");
        System.out.println("Travel Mileage Reimbursement Calculator");
        System.out.println("*************************************************");
    } // end showWelcome
    
    private void showCitiesOptions(){
        this.showCitiesOptions(null);
    } // end showCitiesOptions
    
    private void showCitiesOptions(Cities exceptCity){
        for (Cities city : Cities.values()){
            if (exceptCity == null || exceptCity != city){
                System.out.println(city.ordinal()+") "+city.getSimpleName());
            } // end if
        } // end for
    } // end showCitiesOptions
    
} // end class
