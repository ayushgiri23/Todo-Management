package com.ayush.TodoManagement.resources;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.ayush.TodoManagement.db.TaskDAO;
import com.ayush.TodoManagement.exception.TaskNotFoundException;
import com.ayush.TodoManagement.model.Task;

@Resource
public class TaskResource {

	private TaskDAO taskDAO;

	public TaskResource() {
		taskDAO = new TaskDAO();
	}

	@GET
	public List<Task> findAll() {
		return taskDAO.findAll();
	}

	@POST
	public long create(Task task) {
		return taskDAO.create(task);
	}

	@GET
	@Path("{taskId}")
	public Task findById(@PathParam("{taskId}") long taskId) throws TaskNotFoundException {
		Task task = taskDAO.findById(taskId);
		if (task == null) {
			throw new TaskNotFoundException();
		}
		return task;
	}

	@PUT
	@Path("{taskId}")
	public long update(@PathParam("{taskId}") long taskId, @Valid Task task) throws TaskNotFoundException {
		long ans = taskDAO.update(taskId, task);
		if (ans == -1) {
			throw new TaskNotFoundException();
		}
		return ans;
	}

	@DELETE
	@Path("{taskId}")
	public Task delete(@PathParam("{taskId}") long taskId) throws TaskNotFoundException {
		Task task = taskDAO.delete(taskId);
		if (task == null) {
			throw new TaskNotFoundException();
		}
		return task;
	}

	@POST
	@Path("/markComplete")
	public Task markComplete(@PathParam("{taskId}") long taskId) throws TaskNotFoundException {
		Task task = taskDAO.markCompelete(taskId);
		if (task == null) {
			throw new TaskNotFoundException();
		}
		return task;
	}

	@POST
	@Path("/updateStatus")
	public void updateAllTasks() {
		taskDAO.updateAllTasks();
	}

}
