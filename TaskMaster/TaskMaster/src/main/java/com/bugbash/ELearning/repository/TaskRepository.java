package com.bugbash.ELearning.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bugbash.ELearning.model.Task;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface TaskRepository extends JpaRepository<Task,Integer>{
	@Query(value= "update task t set t.status=:status where t.id=:id", nativeQuery = true)
	@Modifying
public void updateTask(Integer id, Integer status);

	@Modifying
	@Query(value= "select * from task t where t.status=:unfinishedtask", nativeQuery = true)
	public List<Task> findUnfinishedTask(Integer unfinishedtask);

	@Modifying
	@Query(value= "select * from task t where t.status=:finishedtask", nativeQuery = true)
	public List<Task> findFinishedTask(Integer finishedtask);

}
