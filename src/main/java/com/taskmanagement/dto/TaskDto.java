package com.taskmanagement.dto;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

import com.taskmangement.enums.Deleted;
import com.taskmangement.enums.TaskStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskDto {

	private UUID taskId;
	private String taskName;
	private String taskDesc;
	private TaskStatus status;
	private LocalDate taskCreationDate;
	private Date taskUpdationDate;
}
