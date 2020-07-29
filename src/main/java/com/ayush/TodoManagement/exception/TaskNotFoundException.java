package com.ayush.TodoManagement.exception;

import com.ayush.TodoManagement.utils.ErrorMessage;

public class TaskNotFoundException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public TaskNotFoundException() {
		super(ErrorMessage.TASK_NOT_FOUND);
	}
	
}
