package com.example.app.task;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository repo;

    // create: ignore client provided id (safer)
    public Task create(Task t){
        t.setId(null);
        return repo.save(t);
    }

    public Task get(String id){
        return repo.findById(id).orElseThrow(() -> new TaskNotFound(id));
    }

    public List<Task> list(){
        return repo.findAll();
    }

    //partial update: only change provided fields
    public Task update(String id, Task patch){
        Task cur = get(id);
        if (patch.getTitle() != null) cur.setTitle(patch.getTitle());
        cur.setDone(patch.isDone()); // boolean defaults to false if not provided
        return repo.save(cur);
    }

    public void delete (String id){
        Task existing = get(id); //throws TaskNotFound if not found
        repo.delete(existing);
    }

}
