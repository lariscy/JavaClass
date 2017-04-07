package homework.proj11;

/**
 * @author Steven Lariscy
 */
public enum Cities {
    
    BOSTON ("Boston"), CHICAGO("Chicago"), DALLAS("Dallas"),
    RENO("Reno"), LOS_ANGELES("Los Angeles"), MIAMI("Miami"),
    NEW_ORLEANS("New Orleans"), TORONTO("Toronto"),
    VANCOUVER("Vancouver"), WASHINGTON_DC("Washington DC");
    
    private final String simpleName;

    private Cities(String simpleName) {
        this.simpleName = simpleName;
    }

    public String getSimpleName() {
        return this.simpleName;
    }
    
}
