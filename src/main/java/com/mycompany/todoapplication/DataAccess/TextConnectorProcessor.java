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
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Date;
import java.util.Iterator;

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

    /**
     *
     * @param file
     * @return
     */
    public static List<String> LoadFile(  String file){
        try {
              
        File fileObj=new File(file);
        List<String> lines=new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(fileObj.getAbsolutePath()));
        try {
         String line;
         while((line=reader.readLine())!=null){
         lines.add(line);
          }
         reader.close();
        } catch (IOException ex) {
              ex.printStackTrace();
               
            }
               
           
                
    
         return lines;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TextConnectorProcessor.class.getName()).log(Level.SEVERE, null, ex);
               return new ArrayList<>();
        }
    }
    
    public static List<ToDo> ConvertToToDoModel(List<String> lines){

List<ToDo> output=new ArrayList<>();

        for (String line:lines) {
            String [] cols=line.split(",");
            ToDo todo=new ToDo(cols[1],cols[2],new Date(cols[3]), new Date(cols[4]));
            todo.setID(Long.parseLong(cols[0]));
            output.add(todo);
        }

    return output;
    }
    public static void SaveToToDoModel(List<ToDo> models,String fileName){
      List<String> lines=new ArrayList<>();
      
      for(ToDo todo:models){
       lines.add(todo.getID()+","+todo.getName()+","+todo.getDescription()+","+todo.getTime().getStartTime()+","+todo.getTime().getEndTime());
      }
      File fileObj=new File(TextConnectorProcessor.fulFilePath(fileName));
         if(!fileObj.exists()){
          try {
              fileObj.createNewFile();
          } catch (IOException ex) {
              Logger.getLogger(TextConnectorProcessor.class.getName()).log(Level.SEVERE, null, ex);
          }
          }
        
          try {
          try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileObj.getAbsolutePath()))) {
              for(String line:lines){
                  writer.write(line+"\n");
              }
          }
          
        } catch (IOException ex) {
         
            Logger.getLogger(TextConnectorProcessor.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
   
      
      
      
    }
}
