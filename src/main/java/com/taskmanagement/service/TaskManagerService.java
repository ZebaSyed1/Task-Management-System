package com.taskmanagement.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.taskmanagement.dto.StringDto;
import com.taskmanagement.dto.TaskDto;
import com.taskmanagement.dto.TaskDto1;
import com.taskmanagement.dto.TaskDto2;
//import com.taskmanagement.dto.TaskDto1;
import com.taskmanagement.model.TaskManagement;
import com.taskmangement.enums.TaskStatus;

@Service
public interface TaskManagerService {
	
	TaskManagement addTasK(TaskDto taskManagement);
	
	TaskDto1 getAllTasks();
	
	TaskDto1 getTaskAccordingToStatus(TaskStatus status);
	
//	TaskDto1 updateStatus(UUID taskId,TaskStatus status);

//	String updateStatus(UUID taskId);
	
	StringDto deleteTask(UUID taskId);
	
	TaskDto2 getAllTasks(UUID taskId);
	
//	 TaskDto getTaskById(UUID taskId);

//	public List<TaskDto1> getTasksByID(UUID taskId);

//	TaskDto getTaskDetails(UUID taskId);
	
	 

}
