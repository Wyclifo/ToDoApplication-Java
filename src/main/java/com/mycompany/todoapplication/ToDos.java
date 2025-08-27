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
public class ToDos {
    protected long  ID;
    protected String ToDosName;
    protected ArrayList<ToDo> Todos;
    public ToDos(String ToDosName){
        this.ToDosName=ToDosName;
        this.Todos=new ArrayList<>();
    }
    
    public void setID(long ID){
        this.ID=ID;
    }
    public void setToDosName(String ToDosName){
        this.ToDosName=ToDosName;
    }
    public void setTodos(ToDo todo){
        this.Todos.add(todo);
    }
    public long getID(){
        return this.ID;
    }
    public String getNaToDosName(){
        return this.ToDosName;
    }
    public ArrayList<ToDo> getTodos(){
        return this.Todos;
    }
    
    
    
    
    
}
