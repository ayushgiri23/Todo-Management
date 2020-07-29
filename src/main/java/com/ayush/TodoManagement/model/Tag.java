package com.ayush.TodoManagement.model;

import java.util.ArrayList;
import java.util.List;

public class Tag {

	private long tagId;
	private String tagName;
	private String tagDescription;
	private List<Task> tasks;

	public Tag() {
		this.tasks = new ArrayList<>();
	}

	public Tag(long tagId, String tagName, String tagDescription, List<Task> tasks) {
		super();
		this.tagId = tagId;
		this.tagName = tagName;
		this.tagDescription = tagDescription;
		this.tasks = tasks;
	}

	public long getTagId() {
		return tagId;
	}

	public void setTagId(long tagId) {
		this.tagId = tagId;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public String getTagDescription() {
		return tagDescription;
	}

	public void setTagDescription(String tagDescription) {
		this.tagDescription = tagDescription;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

}
