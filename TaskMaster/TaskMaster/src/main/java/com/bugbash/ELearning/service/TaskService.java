package com.bugbash.ELearning.service;

import com.bugbash.ELearning.model.Task;
import com.bugbash.ELearning.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepository;

    public void createTask(Task task) {
    	System.out.println(task);
        taskRepository.save(task);
    }
    Integer unfinishedtask = 0;
    public List<Task> getTasks() {
        return taskRepository.findUnfinishedTask(unfinishedtask);
    }
    Integer status = 1;
	public void deleteTask(Integer id) {
        //taskRepository.deleteById(id);
		taskRepository.updateTask(id,status);
	}
	
    Integer finishedtask = 1;
	public List<Task> getFinishedTasks() {
		return taskRepository.findFinishedTask(finishedtask);
	}
    
}