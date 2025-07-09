package com.taskmanagement.model;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

import org.springframework.cglib.core.Local;

import com.taskmangement.enums.Deleted;
import com.taskmangement.enums.TaskStatus;

//import com.taskmangement.enums.Deleted;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "task_bar")
public class TaskManagement {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID taskId;
	private String taskName;
	private String taskDesc;
	
	
	private LocalDate taskCreationDate;
	private LocalDate taskUpdationDate;
	
	@Enumerated(EnumType.STRING)
	private TaskStatus taskStatus;
	
	@Enumerated(EnumType.STRING)
	private Deleted deletedStatus;
	
	}

