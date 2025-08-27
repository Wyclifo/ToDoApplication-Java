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
public  class ToDoTime {
    protected long ID;
    protected Date StartTime,EndTime;
    public ToDoTime(Date StartTime,Date EndTime){
      this.StartTime=StartTime;
      this.EndTime=EndTime;
    }
    public void setStartTime(Date StartTime){
        this.StartTime=StartTime;
    }
    public void setEndTime(Date EndTime){
        this.EndTime=EndTime;
    }
    public void setID(long ID){
        this.ID=ID;
    }
    public Date getStartTime(){
        return this.StartTime;
    }
    public Date getEndTime(){
        return this.EndTime;
    }
    public long getID(){
        return this.ID;
    }
    public boolean getFullTime(){
       
        try {
            return (this.EndTime.after(this.StartTime));
        } catch (Exception e) {
            return false;
        }
       
    }
}
    

