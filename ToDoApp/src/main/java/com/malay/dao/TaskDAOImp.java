package com.malay.dao;

import static com.malay.constant.TaskConstant.*;

import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.malay.model.Task;

public class TaskDAOImp extends JdbcDaoSupport implements TaskDAO{
	private RowMapper<Task> rowMapper;
	public void setRowMapper(RowMapper<Task> rowMapper) {
		this.rowMapper = rowMapper;
	}
	@Override
	public void addTask(Task t) {
		getJdbcTemplate().update(ADDTASK,t.getUsername(),t.getTask(),t.getDate(),t.getStatus());
	}

	@Override
	public void updateTask(Task t) {
		getJdbcTemplate().update(UPDATETASK,t.getTask(),t.getDate(),t.getStatus(),t.getUsername(),t.getId());
	}

	@Override
	public void deleteTask(String username, int id) {
		getJdbcTemplate().update(DELETETASK,username,id);
		
	}
	@Override
	public void updateStatus(String username, int id) {
		getJdbcTemplate().update(UPDATESTATUS,username,id);
		
	}
	@Override
	public Task viewTask(String username, int id) {
		return getJdbcTemplate().query(VIEWTASK, rowMapper,username,id).get(0);
	}
	@Override
	public List<Task> showTasks(String username) {
		return getJdbcTemplate().query(SHOWTASKS, rowMapper,username);
	}

}
