package de.htwberlin.webtech.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
public class TaskController {
    @Autowired
    private final TaskService taskservice;

    public TaskController(TaskService taskservice) {
        this.taskservice = taskservice;
    }

    @GetMapping(path = "api/v1/tasks")
    @ResponseStatus(HttpStatus.OK)
    public List<TaskEntity> fetchTasks() {
        return taskservice.getTasksList();
    }

    @PostMapping(path = "/api/v1/tasks")
    public ResponseEntity<Void> createtodo(@RequestBody TaskManuplationRequest request) throws URISyntaxException {
        var taskId = taskservice.create(request);
        URI uri = new URI("/api/v1/tasks/" + taskId);
        return ResponseEntity.created(uri).build();
    }

    @GetMapping(path = "/api/v1/tasks/{id}")
    public ResponseEntity<TaskEntity> fetchtaskById(@PathVariable Long id) {
        Optional<TaskEntity> task = taskservice.GetTaskByID(id);
        return task.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping(path = "/api/v1/tasks/{id}")
    public ResponseEntity<TaskEntity> updatetodo(@PathVariable Long id, @RequestBody TaskManuplationRequest request) {
        var taskID = taskservice.UpdateTask(id, request);
        Optional<TaskEntity> task = taskservice.GetTaskByID(taskID);
        return task.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = "/api/v1/tasks/{id}")
    public ResponseEntity<Void> deletetask(@PathVariable Long id) {
        var successful = taskservice.DeleteTask(id);
        return successful ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }


}
