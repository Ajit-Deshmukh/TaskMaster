package com.bugbash.ELearning.controller;

import com.bugbash.ELearning.model.Task;
import com.bugbash.ELearning.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    TaskService taskService;

    @PostMapping("/create")
    public ResponseEntity<?> createTask(@RequestBody Task taskDTO) {
        Task task = new Task(); 
        task.setTask(taskDTO.getTask());
        task.setDueDate(taskDTO.getDueDate());
        System.out.println(taskDTO.getDueDate());
        taskService.createTask(task);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/getTasks")
    public List<Task> getTask() {
        return taskService.getTasks();
    }
    
    @GetMapping("/getFinishedTasks")
    public List<Task> getFinishedTask() {
        return taskService.getFinishedTasks();
    }

    @DeleteMapping("/deleteTask/{id}")
    public void deleteTask(@PathVariable Integer id) {
        taskService.deleteTask(id);
    }
    
    
    
}
