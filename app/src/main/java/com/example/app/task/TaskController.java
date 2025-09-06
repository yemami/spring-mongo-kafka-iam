package com.example.app.task;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController  // @RestController returns JSON automatically (via Jackson).
@RequiredArgsConstructor
@RequestMapping("/api/tasks")
public class TaskController {
    private final TaskService service;

    @PostMapping
    @ResponseStatus (HttpStatus.CREATED)   //201 on success
    public Task create(@RequestBody @Valid Task req){
        return service.create(req);
    }

    @GetMapping ("/{id}")
    public Task get(@PathVariable String id){
        return service.get(id);
    }

    @GetMapping
    public List<Task> list (){
        return service.list();
    }

    @PatchMapping("/{id}")
    public Task update(@PathVariable String id, @RequestBody Task patch){
        return service.update(id,patch);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)  // 204 on success
    public void delete(@PathVariable String id){
        service.delete(id);
    }

}
