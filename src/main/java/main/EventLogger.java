package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class EventLogger {
    final private String FILENAME;

    public EventLogger() {
        FILENAME = "log.txt";
    }

    public void writeLog(String logText) {
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH.mm.ss");
        try {
            BufferedWriter logWriter = new BufferedWriter(new FileWriter(FILENAME, true));
            logWriter.write("[" + date.format(formatter) + "] " + logText + "\n");
            logWriter.close();
        } catch (IOException e) {
            System.out.println("Virhe kirjoitettaessa logitiedostoa");
        }
    }

    public void readLog() {
        try {
            BufferedReader logReader = new BufferedReader(new FileReader(FILENAME));
            String line;
            while ((line = logReader.readLine()) != null) {
                System.out.println(line);
            }
            logReader.close();
        } catch (IOException e) {
            System.out.println("Virhe luettaessa logitiedostoa");
        }
    }
}
