package com.ayush.TodoManagement.db;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.ayush.TodoManagement.model.Task;

public class TaskDAO {

	Map<Long, Task> taskBucket;
	Map<Long, Task> subTaskBucket;
	long taskId;
	private final TagDAO tagDAO;

	public TaskDAO() {
		this.taskBucket = new HashMap<>();
		this.subTaskBucket = new HashMap<>();
		taskId = 1;
		tagDAO = new TagDAO();
	}

	public List<Task> findAll() {
		Set<Long> taskSet = taskBucket.keySet();
		List<Task> tasks = new ArrayList<>();
		for (Long taskId : taskSet) {
			if (!subTaskBucket.containsKey(taskId)) {
				tasks.add(taskBucket.get(taskId));
			}
		}
		return tasks;
	}

	public long create(Task task) {
		long parentTaskId = task.getParentTaskId();
		long tagId = task.getTagId();
		if (taskBucket.containsKey(parentTaskId)) {
			taskBucket.get(parentTaskId).getSubTasks().add(task);
			subTaskBucket.put(taskId, task);
		}
		taskBucket.put(taskId, task);
		tagDAO.tagBucket.get(tagId).getTasks().add(task);

		long toBeReturned = taskId;
		taskId += 1;
		return toBeReturned;
	}

	public Task findById(long taskId) {
		if (!taskBucket.containsKey(taskId)) {
			return null;
		}
		return taskBucket.get(taskId);
	}

	public long update(long taskId, Task task) {
		if (!taskBucket.containsKey(taskId)) {
			return -1;
		}
		long initialParentTaskId = taskBucket.get(taskId).getParentTaskId();
		long currParentTaskId = task.getParentTaskId();
		if (initialParentTaskId == currParentTaskId) {
			if (subTaskBucket.containsKey(taskId)) {
				subTaskBucket.put(taskId, task);
			}
		} else {
			for (Task currTask : taskBucket.get(initialParentTaskId).getSubTasks()) {
				if (currTask.getTaskId() == taskId) {
					taskBucket.get(initialParentTaskId).getSubTasks().remove(currTask);
					taskBucket.get(initialParentTaskId).getSubTasks().add(task);
					break;
				}
			}
			taskBucket.remove(taskId);
			if (subTaskBucket.containsKey(taskId)) {
				subTaskBucket.remove(taskId);
				subTaskBucket.put(taskId, task);
			}
			taskBucket.remove(taskId);
			taskBucket.put(taskId, task);
		}
		return taskId;
	}

	public Task delete(long taskId) {
		if (!taskBucket.containsKey(taskId)) {
			return null;
		}
		Task task = taskBucket.get(taskId);
		long parentTaskId = task.getParentTaskId();
		if (taskBucket.containsKey(parentTaskId)) {
			List<Task> tasks = taskBucket.get(parentTaskId).getSubTasks();
			for (int idx = 0; idx < tasks.size(); idx++) {
				if (tasks.get(idx).getTaskId() == taskId) {
					tasks.remove(idx);
				}
			}
		}
		taskBucket.remove(taskId);
		if (subTaskBucket.containsKey(taskId)) {
			subTaskBucket.remove(taskId);
		}
		return task;
	}

	public Task markCompelete(long taskId) {
		if (!taskBucket.containsKey(taskId)) {
			return null;
		}
		Task task = taskBucket.get(taskId);
		markAllComplete(task);
		return task;
	}

	private void markAllComplete(Task task) {
		if (task == null || task.getSubTasks().size() == 0) {
			return;
		}
		task.setTaskStatus((short) 3);
		task.setCompletionDate(new Date());
		List<Task> subTasks = task.getSubTasks();
		for (Task currTask : subTasks) {
			markAllComplete(currTask);
		}
	}
	

	public void updateAllTasks() {
		for (long taskId : taskBucket.keySet()) {
			updateTask(taskBucket.get(taskId));
		}
	}

	private void updateTask(Task task) {
		if (new Date().compareTo(task.getCompletionDate()) == -1) {
			task.setTaskStatus((short) 1);
		} else if (new Date().compareTo(task.getCompletionDate()) == 1) {
			task.setTaskStatus((short) 2);
		} else {
			task.setTaskStatus((short) 3);
		}
		for (Task currTask : task.getSubTasks()) {
			updateTask(currTask);
		}
	}
}
