package com.taskmanagement.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.taskmanagement.dto.StringDto;
import com.taskmanagement.dto.TaskDto;
import com.taskmanagement.dto.TaskDto1;
import com.taskmanagement.dto.TaskDto2;
import com.taskmanagement.model.TaskManagement;
import com.taskmangement.enums.TaskStatus;

@Service
public interface TaskManagerService {
	
	TaskManagement addTasK(TaskDto taskManagement);
	
	TaskDto1 getAllTasks();
	
	TaskDto1 getTaskAccordingToStatus(TaskStatus status);
		
	StringDto deleteTask(UUID taskId);
	
	TaskDto2 getAllTasks(UUID taskId);
	

	
	 

}
