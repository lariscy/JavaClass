package homework.proj11;

/**
 * @author Steven Lariscy
 * @projectNumber PL004T
 * @date 4.12.2017
 * @dueDate 4.13.2017
 * @description Travel Mileage Calculator
 */
public enum Cities {
    
    BOSTON ("Boston"), CHICAGO("Chicago"), DALLAS("Dallas"),
    RENO("Reno"), LOS_ANGELES("Los Angeles"), MIAMI("Miami"),
    NEW_ORLEANS("New Orleans"), TORONTO("Toronto"),
    VANCOUVER("Vancouver"), WASHINGTON_DC("Washington DC");
    
    private final String simpleName;

    // end constructor
    private Cities(String simpleName) {
        this.simpleName = simpleName;
    } // end constructor

    public String getSimpleName() {
        return this.simpleName;
    } // end getSimpleName

    @Override
    public String toString() {
        return this.getSimpleName();
    } // end toString
    
} // end class
