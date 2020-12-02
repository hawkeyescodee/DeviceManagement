/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linhnln.logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Calendar;


/**
 *
 * @author Liam Nguyen
 */
public class LogFileText implements Serializable{

    public static void writeToLogFile(String view, String errorMsg) {
        String fileName = view + "logFile" + ".txt";
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(new FileOutputStream(new File(fileName), true));
            Calendar cal = Calendar.getInstance();
            Timestamp currentTime = new Timestamp(cal.getTimeInMillis());
            writer.println(view + " " + currentTime + " " + errorMsg); // stores in RAM first
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (writer != null) writer.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }
    }
    
    
    //test
    public static void main(String[] args) {
        writeToLogFile("adminViewMode","AHIHI SUCESS ");
        writeToLogFile("adminViewMode","AHIHI SUCESS 123");
    }
}
