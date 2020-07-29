package com.ayush.TodoManagement.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Task {

	private long taskId;
	private String taskName;
	private String taskDesc;
	private Date taskDueDate;
	private Date completionDate;
	private short taskStatus;
	private long parentTaskId;
	private long tagId;
	private List<Task> subTasks;

	public Task() {
		this.subTasks = new ArrayList<>();
	}

	public Task(long taskId, String taskName, String taskDesc, Date taskDueDate, Date completionDate, short taskStatus,
			long parentTaskId, long tagId, List<Task> subTasks) {
		super();
		this.taskId = taskId;
		this.taskName = taskName;
		this.taskDesc = taskDesc;
		this.taskDueDate = taskDueDate;
		this.completionDate = completionDate;
		this.taskStatus = taskStatus;
		this.parentTaskId = parentTaskId;
		this.tagId = tagId;
		this.subTasks = subTasks;
	}

	public long getTaskId() {
		return taskId;
	}

	public void setTaskId(long taskId) {
		this.taskId = taskId;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getTaskDesc() {
		return taskDesc;
	}

	public void setTaskDesc(String taskDesc) {
		this.taskDesc = taskDesc;
	}

	public Date getTaskDueDate() {
		return taskDueDate;
	}

	public void setTaskDueDate(Date taskDueDate) {
		this.taskDueDate = taskDueDate;
	}

	public short getTaskStatus() {
		return taskStatus;
	}

	public void setTaskStatus(short taskStatus) {
		this.taskStatus = taskStatus;
	}

	public long getParentTaskId() {
		return parentTaskId;
	}

	public void setParentTaskId(long parentTaskId) {
		this.parentTaskId = parentTaskId;
	}

	public List<Task> getSubTasks() {
		return subTasks;
	}

	public void setSubTasks(List<Task> subTasks) {
		this.subTasks = subTasks;
	}

	public long getTagId() {
		return tagId;
	}

	public void setTagId(long tagId) {
		this.tagId = tagId;
	}

	public Date getCompletionDate() {
		return completionDate;
	}

	public void setCompletionDate(Date completionDate) {
		this.completionDate = completionDate;
	}

}
