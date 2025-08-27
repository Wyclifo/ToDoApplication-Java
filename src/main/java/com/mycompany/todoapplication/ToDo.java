/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.todoapplication;

import java.util.Date;

/**
 *
 * @author Wyclif
 */
public class ToDo  {
    protected long ID;
    protected String Name,Description;
    protected ToDoTime time;
    public ToDo(String Name,String Description,Date StartTime,Date EndTime){
        this.Name=Name;
        this.Description=Description;
        this.time=new ToDoTime(StartTime,EndTime);
    }
    public void setID(long ID){
        this.ID=ID;
    }
    public void setName(String Name){
        this.Name=Name;
    }
    public void setDescription(String Description){
        this.Description=Description;
    }
    public void setTime(ToDoTime time){
        this.time=time;
    }
    public long getID(){
        return this.ID;
    }
    public String getName(){
        return this.Name;
    }
    public String getDescription(){
        return this.Description;
    }
    public  ToDoTime getTime(){
        return this.time;
    }
   
    
}

