/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.todoapplication.DataAccess;


import com.mycompany.todoapplication.ToDo;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Date;


/**
 *
 * @author Wyclif
 */
public  class TextConnectorProcessor {
    private static final String FILEPATH="E:\\data\\javatodo";
   private static final DateTimeFormatter DATE_FORMATTER =
        DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    public static String fulFilePath(String fileName ){
       return new File(FILEPATH, fileName).getAbsolutePath();
    }
    // TODO        Load the text file

    /**
     *
     * @param file
     * @return
     */
    public static List<String> LoadFile(  String file){
      List<String> lines = new ArrayList<>();
    File fileObj = new File(file);

    try {
        // Create the parent directory if it does not exist
        File parent = fileObj.getParentFile();

        if (parent != null && !parent.exists()) {
            parent.mkdirs();
        }

        // Create the file if it does not exist
        if (!fileObj.exists()) {
            fileObj.createNewFile();
            return lines;
        }

        // Read the existing file
        try (BufferedReader reader =
                new BufferedReader(new FileReader(fileObj))) {

            String line;

            while ((line = reader.readLine()) != null) {
                if (!line.isBlank()) {
                    lines.add(line);
                }
            }
        }

    } catch (IOException ex) {
        Logger.getLogger(TextConnectorProcessor.class.getName())
                .log(Level.SEVERE, "Failed to load Todo file: " + file, ex);
    }

    return lines;
    }
    
  public static List<ToDo> ConvertToToDoModel(List<String> lines){
List<ToDo> output = new ArrayList<>();

    for (String line : lines) {

        String[] cols = line.split(",");

        LocalDateTime startDateTime =
                LocalDateTime.parse(cols[3], DATE_FORMATTER);

        LocalDateTime endDateTime =
                LocalDateTime.parse(cols[4], DATE_FORMATTER);

        Date startTime = Date.from(
                startDateTime
                        .atZone(ZoneId.systemDefault())
                        .toInstant()
        );

        Date endTime = Date.from(
                endDateTime
                        .atZone(ZoneId.systemDefault())
                        .toInstant()
        );

        ToDo todo = new ToDo(
                cols[1],
                cols[2],
                startTime,
                endTime
        );

        todo.setID(Long.parseLong(cols[0]));

        output.add(todo);
    }

    return output;
    }
    
    public static void SaveToToDoModel(List<ToDo> models,String fileName){
      List<String> lines = new ArrayList<>();

    for (ToDo todo : models) {

        LocalDateTime startDateTime =
                todo.getTime()
                        .getStartTime()
                        .toInstant()
                        .atZone(ZoneId.systemDefault())
                        .toLocalDateTime();

        LocalDateTime endDateTime =
                todo.getTime()
                        .getEndTime()
                        .toInstant()
                        .atZone(ZoneId.systemDefault())
                        .toLocalDateTime();

        String startTime =
                startDateTime.format(DATE_FORMATTER);

        String endTime =
                endDateTime.format(DATE_FORMATTER);

        lines.add(
                todo.getID()
                + ","
                + todo.getName()
                + ","
                + todo.getDescription()
                + ","
                + startTime
                + ","
                + endTime
        );
    }

    File fileObj =
            new File(TextConnectorProcessor.fulFilePath(fileName));

    if (!fileObj.exists()) {
        try {
            fileObj.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(
                    TextConnectorProcessor.class.getName()
            ).log(Level.SEVERE, null, ex);
        }
    }

    try {

        try (BufferedWriter writer =
                new BufferedWriter(
                        new FileWriter(fileObj.getAbsolutePath())
                )) {

            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
        }

    } catch (IOException ex) {

        Logger.getLogger(
                TextConnectorProcessor.class.getName()
        ).log(Level.SEVERE, null, ex);
    }
    }
}
