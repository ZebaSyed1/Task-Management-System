package com.taskmanagement.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

	//	@Autowired
	//	TaskDto taskDto;


	@Override
	public TaskManagement addTasK(TaskDto taskDto) {



		//	if (!taskRepo.existsById(taskDto.getTakId())) {

		TaskManagement task = new TaskManagement();
		//		task.setTaskId(taskDto.getTaskId());
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
	//	@Override
	//	public String updateStatus(UUID taskId) {
	//		if (taskRepo.existsById(taskId)) {
	//			TaskManagement task=taskRepo.getTaskById(taskId);
	//			 TaskStatus newStatus;
	//		        switch (currentStatus) {
	//		            case toDo:
	//		                newStatus = TaskStatus.IN_PROGRESS;
	//		                break;
	//		            case IN_PROGRESS:
	//		                newStatus = TaskStatus.COMPLETED;
	//		                break;
	//		            case COMPLETED:
	//		            default:
	//		                newStatus = TaskStatus.TODO;
	//		                break;
	////			
	////			if(task.getTaskStatus().equals(TaskStatus.ToDo)) {
	////				task.setTaskStatus(TaskStatus.InProgress);
	////			}
	////			
	////		}
	////		return null;
	////	}
//	@Override
//	public TaskDto1 updateStatus(UUID taskId,TaskStatus task) {
//
//		TaskManagement tasks=new TaskManagement();
//		if (tasks.getTaskStatus()==ToDo){
//			tasks.setTaskStatus(TaskStatus.InProgress);
//		}
//			if(tasks.getTaskStatus()==InProgress) {
//				tasks.setTaskStatus(NeedsReview);
//
//			}
//			return taskDto;
//			
//
//		}
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
	
//	}
//	@Override
//	public List<TaskDto> getTaskById(UUID taskId) {
//		
//		TaskManagement task = taskRepo.getTaskById(taskId);
//		if (task != null && task.getDeleted().equals(Deleted.False)) {
//		    TaskDto dto = new TaskDto();
////	    List<TaskManagement> tasks = new ArrayList<>();
////	    tasks=taskRepo.getTaskById(taskId).stream()
////	            .filter(task -> task.getDeleted().equals(Deleted.False))
////	            .collect(Collectors.toList());
//
//	    List<TaskDto> dtos = new ArrayList<>();
//	    for (TaskManagement t : tasks) {
//	        TaskDto dto = new TaskDto();
//
//	        // Map TaskManagement fields to TaskDto1
//	        dto.setTaskId(t.getTaskId());
//	        dto.setTaskName(t.getTaskName());
//	        dto.setTaskDesc(t.getTaskDesc());
//	        dto.setTaskCreationDate(t.getTaskCreationDate());
////	        dto.setStatus(t.getStatus());
//	        // Add other fields as needed
//
//	        dtos.add(dto);
//	    }
//
//	    return dtos;
//	}
//	@Override
//	public List<TaskDto> getTasksByID(UUID taskId) {
//		// TODO Auto-generated method stub
//		List<TaskDto> t =getTasksByID(taskId);
//		
//		if(!t.isEmpty()) {
//			TaskManagement tm = new TaskManagement()
//			List<TaskDto> ts = new ArrayList<>();
//			t.stream().filter(ts->tm.getClass().c)
//		}
//		return null;
//	}
	
//	@Override
//	public List<TaskDto1> getTasksByID(UUID taskId) {
//	    List<TaskManagement> tasks = taskRepo.getTasksById(taskId);
//
//	    List<TaskDto1> dtos = new ArrayList<>();
//
//	    for (TaskManagement task : tasks) {
//	        if (task.getStatus() == Deleted.False) {
//	            TaskDto1 dto = new TaskDto1();
//	            dto.setTasks(tasks);
//	         
//	            dtos.add(dto);
//	        }
//	    }
//
//	    return dtos;
//	}

//	@Override
//	public TaskDto2 getAllTasks(UUID taskId) {
//		TaskDto2 dto = new TaskDto2();
//		dto.setTasks(taskRepo.getTaskById(taskId));
//		return dto;
//	}

		
//	@Override
//	public TaskDto getTaskById(UUID taskId) {
//		
//	        TaskManagement task = taskRepo.getTaskById(taskId);
//
//	        if (task != null && task.getStatus() == Deleted.False) {
//	            TaskDto dto = new TaskDto();
//	            dto.setTaskId(task.getTaskId());
//	            dto.setTaskName(task.getTaskName());
//	            dto.setTaskDesc(task.getTaskDesc());
//	            dto.setTaskCreationDate(task.getTaskCreationDate());
//	            return dto;
//	        }
//			return null;
//			
//
////	}
//	 @Override
//	    public TaskDto getTaskDetails(UUID taskId) {
//	        TaskManagement task = taskRepo.getTaskById(taskId);
//
//	        if (task != null && task.getStatus() == Deleted.False) {
//	            TaskDto dto = new TaskDto();
//	            dto.setTaskId(task.getTaskId());
//	            dto.setTaskName(task.getTaskName());
//	            dto.setTaskDesc(task.getTaskDesc());
//	            dto.setTaskCreationDate(task.getTaskCreationDate());
//	           
//	            
//
//	        dto;  // or throw new RuntimeException("Task not found")
//	    }
//			return null;
//	}
}





