/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.todoapplication;

import com.mycompany.todoapplication.DataAccess.GlobalConfig;
import com.mycompany.todoapplication.TodoApplicationUI.CreateToDoForm;

/**
 *
 * @author Wyclif
 */
public class ToDoApplication {

    public static void main(String[] args) {
        GlobalConfig.InitializeConnection(false, true);
        java.awt.EventQueue.invokeLater(() -> {
            new CreateToDoForm().setVisible(true);
        });
    }
}
