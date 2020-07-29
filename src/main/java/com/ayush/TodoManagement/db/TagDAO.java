package com.ayush.TodoManagement.db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.ayush.TodoManagement.model.Tag;
import com.ayush.TodoManagement.model.Task;

public class TagDAO {

	Map<Long, Tag> tagBucket;
	long tagId;

	public TagDAO() {
		this.tagBucket = new HashMap<>();
		tagId = 1;
	}

	public List<Tag> findAll() {
		Set<Long> tagSet = tagBucket.keySet();
		List<Tag> tags = new ArrayList<>();
		for (long tagId : tagSet) {
			tags.add(tagBucket.get(tagId));
		}
		return tags;
	}

	public void create(Tag tag) {
		tagBucket.put(tagId, tag);
		tagId += 1;
	}

	public void assignTag(List<Task> tasks, long tagId) {
		for (Task currTask : tasks) {
			assignTag(currTask, tagId);
		}
	}

	private void assignTag(Task task, long tagId) {
		task.setTagId(tagId);
		for (Task currTask : task.getSubTasks()) {
			assignTag(currTask, tagId);
		}
	}

}
