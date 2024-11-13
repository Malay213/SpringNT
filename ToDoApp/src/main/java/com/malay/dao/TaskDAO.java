package com.malay.dao;

import java.util.List;

import com.malay.model.Task;

public interface TaskDAO {
	void addTask(Task t);
	void updateTask(Task t);
	void updateStatus(String username, int id);
	void deleteTask(String username,int id);
	Task viewTask(String username,int id);
	List<Task> showTasks(String username);
}
