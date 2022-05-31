package com.laziz.tasks.service;
import java.util.List;

import org.springframework.data.domain.Page;

import com.laziz.tasks.entities.Person;
import com.laziz.tasks.entities.Task;
public interface TaskService {
	Task saveTask(Task t);
	Task updateTask(Task t);
	void deleteTask(Task t);
	void deleteTaskById(Long id);
	Task getTask(Long id);
	List<Task> findByTaskName(String nomTask);
	List<Task> getAllTasks();	
	Page<Task> getAllTasksParPage(int page, int size);

}
