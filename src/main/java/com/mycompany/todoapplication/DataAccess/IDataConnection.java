/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.todoapplication.DataAccess;

import com.mycompany.todoapplication.ToDo;
import java.util.List;

/**
 *
 * @author Wyclif
 */
public interface IDataConnection {
   ToDo createToDo(ToDo todo);
   List<ToDo> getToDos() ;
}
