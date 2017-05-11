package homework.proj13;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Steven Lariscy
 */
public class Logger {
    
    // instance variables
    private static Logger instance;
    private static final String FILE_NAME = "BankProgram.log";
    private static BufferedWriter writer;
    
    // private constructor
    private Logger(){}
    
    public static Logger getInstance(){
        if (Logger.instance == null){
            Logger.instance = new Logger();
            Logger.initLogger();
        } // end if
        return Logger.instance;
    } // end getInstance
    
    private static void initLogger(){
        try {
            Logger.writer = new BufferedWriter(new FileWriter(new File(Logger.FILE_NAME), true));
        } catch (IOException ex) { // end trye
            System.err.println("error initializing the logger: "+ex);
        } // end catch
    } // end 
    
    public void log(String line){
        try {
            Logger.writer.write(line + "\n");
        } catch (IOException ex) { // end try
            System.err.println("error writing to log file: "+ex);
        } // end catch
    } // end 
    
    public void closeLogger(){
        try {
            Logger.writer.flush();
            Logger.writer.close();
        } catch (IOException ex) { // end try
            System.err.println("error closing the logger: "+ex);
        } // end catch
    } // end 
    
} // end class
