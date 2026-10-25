/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.todoapplication.DataAccess;

import com.mycompany.todoapplication.ToDo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Wyclif
 */
public class GlobalConfig {
    public static List<IDataConnection> connection=new ArrayList<>();
    public static void InitializeConnection(boolean database,boolean textfile){
        if(database){
//          TODO Connect to the Database
SqlConnector sql=new SqlConnector();
connection.add(sql);
        }
        if(textfile){
//            TODO Connect to the Text File
TextConnector text=new TextConnector();
connection.add(text);
        }
    }

  
    public static List<ToDo> getToDos() {

        // Prefer SQL as the read source
        for (IDataConnection connection : GlobalConfig.connection) {

            if (connection instanceof SqlConnector) {

                try {
                    return connection.getToDos();

                } catch (Exception ex) {
                    ex.printStackTrace();

                    // Continue and try the text source
                }
            }
        }

        // Fallback to text
        for (IDataConnection connection : GlobalConfig.connection) {

            if (connection instanceof TextConnector) {

                try {
                    return connection.getToDos();

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }

        return new ArrayList<>();
    }
}
