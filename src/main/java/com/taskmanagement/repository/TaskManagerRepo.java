package com.taskmanagement.repository; 

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.taskmanagement.model.TaskManagement;


@Repository
public interface TaskManagerRepo extends JpaRepository<TaskManagement, UUID>{

	
	@Query(value="select t from TaskManagement t")
	List<TaskManagement> getAllTasks();
	
	@Query(value="select t from TaskManagement t where t.taskId =:taskId")
	TaskManagement getTaskById(UUID taskId);
	
	@Query(value="select t from TaskManagement t where t.taskId =:taskId")
	List<TaskManagement> getTasksById(UUID taskId);
	
//	@Query(value = "select t.taskName from Task t")
//	List<String> getAllTask();
}
