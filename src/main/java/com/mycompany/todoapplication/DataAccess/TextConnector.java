/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.todoapplication.DataAccess;

import com.mycompany.todoapplication.ToDo;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Wyclif
 */
public class TextConnector implements IDataConnection {
    private final String TODOFILE="ToDoModel.csv";

    /**
     *
     * @param todo
     * @return
     */
    @Override
    public ToDo createToDo(ToDo todo) {

 List<ToDo> todolist= TextConnectorProcessor.ConvertToToDoModel(TextConnectorProcessor.LoadFile(TextConnectorProcessor.fulFilePath(TODOFILE)));
   Comparator<ToDo> c=(a,b)->Long.compare(a.getID(), b.getID());
   todolist.sort(c);
  if(!todolist.isEmpty()){
    todo.setID(todolist.getFirst().getID()+1 );  
  }else{
      todo.setID(1);
  }

 
 todolist.add(todo);
 TextConnectorProcessor.SaveToToDoModel(todolist, TODOFILE);
 return todo;
       
    }
    
}
