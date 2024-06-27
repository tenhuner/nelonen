package main;


// Import the necessary classes for file processing and date formatting "java.io.*"
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class EventLogger { // EventLogger class responsible for logging and reading events
    final private String FILENAME; // Constant variable for filename

    public EventLogger() { // Constructor method that initializes the filename
        FILENAME = "log.txt"; // The name of the file where the events are logged
    }

    public void writeLog(String logText) { // Method for logging the event
        LocalDateTime date = LocalDateTime.now(); // Get the current date and time
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH.mm.ss"); // Define the date and time format
        try (BufferedWriter logWriter = new BufferedWriter(new FileWriter(FILENAME, true))) { // Trying to write to the log file
            logWriter.write("[" + date.format(formatter) + "] " + logText + "\n"); // Write the event to the file in the format [date and time]
        } catch (IOException e) {
            System.out.println("Virhe kirjoitettaessa logitiedostoa"); // If an error occurs, an error message is printed
        }
    }

    public void readLog() { // Method for reading the log file
        try (BufferedReader logReader = new BufferedReader(new FileReader(FILENAME))) { // Trying to read the log file
            String line; // String to store the read row
            while ((line = logReader.readLine()) != null) { // Read the file line by line
                System.out.println(line); // Print a line to the console
            }
        } catch (IOException e) {
            System.out.println("Virhe luettaessa logitiedostoa"); // If an error occurs, an error message is printed
        }
    }
}
