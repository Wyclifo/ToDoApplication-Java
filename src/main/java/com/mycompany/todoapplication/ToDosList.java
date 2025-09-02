/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.todoapplication;

import java.util.ArrayList;

/**
 *
 * @author Wyclif
 */
public class ToDosList {
    
    private ArrayList<ToDos> todos;
    public ToDosList(){
        this.todos=new ArrayList<>();
    }
    public void setTodos(ArrayList<ToDos> todos){
        this.todos=todos;
    }
    public ArrayList<ToDos> getTodos(){
        return this.todos;
    }
    
}
