package com.taskmanagement.controller;

import java.util.List;
import java.util.UUID;
import com.taskmanagement.dto.StringDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.taskmanagement.dto.TaskDto;
import com.taskmanagement.dto.TaskDto1;
import com.taskmanagement.dto.TaskDto2;
import com.taskmanagement.model.TaskManagement;
import com.taskmanagement.service.TaskManagerService;
import com.taskmangement.enums.TaskStatus;

import io.swagger.v3.oas.annotations.Operation;


@RestController
public class TaskController {

	@Autowired
	TaskManagerService taskService;



	@PostMapping(value = "/tasks",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)

	public ResponseEntity<TaskManagement> post(
			//			@PathVariable("taskId") UUID taskId,
			@RequestBody TaskDto taskDto) 
	{
		return new ResponseEntity<>(taskService.addTasK(taskDto), HttpStatus.CREATED);
	}

	@GetMapping(value = "/task", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Get all tasks")
	public ResponseEntity<TaskDto1> get()
	{
		return new ResponseEntity<>(taskService.getAllTasks(), HttpStatus.OK);
	}

	@GetMapping(value = "/task/taskStatus", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Get all tasks Based On Status")
	public ResponseEntity<TaskDto1> getTasksAccordingToStatus(@RequestParam TaskStatus status)
	{
		return new ResponseEntity<>(taskService.getTaskAccordingToStatus(status), HttpStatus.OK);
	}

	@DeleteMapping(value="/tasks/{taskId}",
//			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StringDto> delete(@PathVariable UUID taskId)
	{
		return new ResponseEntity<>(taskService.deleteTask(taskId),HttpStatus.OK);
	}
	
	@GetMapping(value = "/task/{taskId}", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Get all tasks")
	public ResponseEntity<TaskDto2> getTask(@PathVariable UUID taskId)
	{
		return new ResponseEntity<>(taskService.getAllTasks(taskId), HttpStatus.OK);
	}

	//	@PutMapping(value="/task/tasks/status",produces = MediaType.APPLICATION_JSON_VALUE)
	//	@Operation(summary = "Get all tasks Based On Status")
	//	public ResponseEntity<TaskDto1> put(@RequestParam TaskManagement task)
	//	{
	//		return new ResponseEntity<>(taskService.updateStatus(task),HttpStatus.OK);
	//	}

}

