package com.ayush.TodoManagement.resources;

import java.util.List;

import javax.annotation.Resource;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import com.ayush.TodoManagement.db.TagDAO;
import com.ayush.TodoManagement.model.Tag;
import com.ayush.TodoManagement.model.Task;

@Resource
@Path("/tags")
public class TagResource {

	private final TagDAO tagDAO;

	public TagResource() {
		this.tagDAO = new TagDAO();
	}

	@GET
	public List<Tag> findAll() {
		return tagDAO.findAll();
	}

	@POST
	@Path("{tagId}")
	public void create(Tag tag) {
		tagDAO.create(tag);
	}

	@POST
	public void assignTag(List<Task> tasks, long tagId) {
		tagDAO.assignTag(tasks, tagId);
	}

}
