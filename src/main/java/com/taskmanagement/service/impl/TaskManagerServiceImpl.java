package com.taskmanagement.service.impl;

import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taskmanagement.dto.StringDto;
import com.taskmanagement.dto.TaskDto;
import com.taskmanagement.dto.TaskDto1;
import com.taskmanagement.dto.TaskDto2;
import com.taskmanagement.model.TaskManagement;
import com.taskmanagement.repository.TaskManagerRepo;
import com.taskmanagement.service.TaskManagerService;
import com.taskmangement.enums.Deleted;
import com.taskmangement.enums.TaskStatus;


@Service
public class TaskManagerServiceImpl implements TaskManagerService {

	@Autowired
	TaskManagerRepo taskRepo;



	@Override
	public TaskManagement addTasK(TaskDto taskDto) {




		TaskManagement task = new TaskManagement();
		task.setTaskName(taskDto.getTaskName());
		task.setTaskDesc(taskDto.getTaskDesc());
		task.setTaskCreationDate(taskDto.getTaskCreationDate());
		task.setTaskStatus(TaskStatus.ToDo);
		taskRepo.save(task);
		return task;
	}
	@Override
	public TaskDto1 getAllTasks() {
		TaskDto1 dto = new TaskDto1();
		dto.setTasks(taskRepo.getAllTasks());
		return dto;
	}
	@Override
	public TaskDto1 getTaskAccordingToStatus(TaskStatus status) {

		TaskDto1 dto = new TaskDto1();
		dto.setTasks(taskRepo.getAllTasks().stream()
				.filter(t->t.getTaskStatus()==status)
				.collect(Collectors
						.toList()));
		return dto;
	}

	@Override
	public StringDto deleteTask(UUID taskId) {
		// TODO Auto-generated method stub
		StringDto dto= new StringDto();
		if(taskRepo.getTaskById(taskId)!=null) {
			TaskManagement t=taskRepo.getTaskById(taskId);
			t.setDeletedStatus(Deleted.True);
			taskRepo.save(t);
			dto.setMessage("The task has been sucessfully deleted");
			return dto;
		}
		return dto;
	}	
	
	@Override
	public TaskDto2 getAllTasks(UUID taskId) {
		TaskDto2 dto = new TaskDto2();
		dto.setTasks(taskRepo.getTaskById(taskId));
		return dto;
	}
	

}





