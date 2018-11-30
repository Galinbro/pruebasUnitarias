/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TaskTest;

import ToDoList.Task;
import ToDoList.TaskOperation;
import java.util.ArrayList;
import java.util.List;
import org.dbunit.Assertion;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.internal.matchers.Null;

/**
 *
 * @author galindo
 */
public class testTask {
    
    public testTask() {
    }

   
    @Test
    public void saveTaskTest(){
        
        Task task = new Task("Comer","2211","otro","high","Emilio");
        TaskOperation tas = new TaskOperation();
        
        tas.saveTask(task);
        
        assertTrue(tas.compareTaskList(task));
        
    }
    
    @Test
    public void deleteTaskTest(){
        
        Task task = new Task("Comer","2211","otro","high","Emilio");
        Task task1 = new Task("Comer","2211","otro","high","Emilio1");
        TaskOperation to = new TaskOperation();
        
        to.saveTask(task);
        
        assertTrue(to.compareTaskList(task1));
         
         to.deleteTask(task);
        
         assertFalse(to.compareTaskList(task));
    }
    
    @Test
    public void completeTaskTest(){
        
        Task task = new Task("Comer","2211","otro","high","Emilio");
        TaskOperation to = new TaskOperation();
        
        to.completeTask(task);
        
        assertFalse(to.compareTaskCompleteList(task));
         
        to.saveTask(task);
        
        to.completeTask(task);
        
        assertTrue(to.compareTaskCompleteList(task));
    }
}
