package com.example.app.task;

public class TaskNotFound extends RuntimeException{
    public TaskNotFound(String id){  //Throwing a meaningful exception lets us convert it to HTTP 404 later (clean API).
        super("Task not found: " + id);
    }
}
