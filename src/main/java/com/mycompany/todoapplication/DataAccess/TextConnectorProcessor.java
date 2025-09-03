/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.todoapplication.DataAccess;


import com.mycompany.todoapplication.ToDo;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Wyclif
 */
public  class TextConnectorProcessor {
    private static final String FILEPATH="E:\\data\\javatodo";
   
    public static String fulFilePath(String fileName ){
        return (TextConnectorProcessor.FILEPATH+"\\ "+fileName);
    }
    // TODO        Load the text file

  
    public static List<String> LoadFile(String file){
        try {
              
        File fileObj=new File(file);
        List<String> lines;
            try (Scanner scanner = new Scanner(fileObj)) {
                lines = new ArrayList<>();
                while(scanner.hasNextLine()){
                    lines.add(scanner.nextLine());
                }   }
    
         return lines;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TextConnectorProcessor.class.getName()).log(Level.SEVERE, null, ex);
               return new ArrayList<>();
        }
    }
    
    public static List<ToDo> ConvertToToDoModel(List<String> lines){
//        TODO Convert lines to list of ToDO model
List<ToDo> output=new ArrayList<>();

for(String line:lines){
   
    
}

        return null;
    }
}
