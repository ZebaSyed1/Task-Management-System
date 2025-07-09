package com.taskmanagement.dto;

import java.util.List;

import com.taskmanagement.model.TaskManagement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskDto1 {

	private List<TaskManagement> tasks;
}
