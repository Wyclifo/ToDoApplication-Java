/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.todoapplication.DataAccess;

import com.mycompany.todoapplication.ToDo;
import java.util.List;

/**
 *
 * @author Wyclif
 */
public class SqlConnector implements IDataConnection {

    @Override
    public ToDo createToDo(ToDo todo) {
//        Here we will connect to sql and save the data to sql
        System.out.println("Data Saved to SQL");
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ToDo> getToDos() {
        System.out.println("Not yet implemented for sql reading the todos ");
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
