package de.htwberlin.webtech.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;


@Service
public class TaskService {

    private static Logger logger = Logger.getLogger(TaskService.class.getName());

    @Autowired
    private final TaskRepo taskRepo;

    public TaskService(TaskRepo taskRepo) {
        this.taskRepo = taskRepo;
    }

    public List<TaskEntity> getTasksList() {
        List<TaskEntity> taskList = new ArrayList<>();
        taskRepo.findAll().forEach(taskList::add);
        return taskList;
    }

    public Optional<TaskEntity> GetTaskByID(long taskId) {
        return taskRepo.findById(taskId);
    }

    public long addTasktoList(TaskEntity task) {
        long taskId = 0;
        taskRepo.save(task);
        taskId = task.getId();
        return taskId;
    }

    public boolean DeleteTask(long id) {
        long itemId = 0;
        taskRepo.deleteById(id);
        return true ;
    }

    public long UpdateTask(long todoId, TaskManuplationRequest task) {

        long newId = 0;
        try {
            TaskEntity TasktoUpdate = taskRepo.findById(todoId).get();
            TasktoUpdate.setTitle(task.getTitle());
            TasktoUpdate.setDescription(task.getDescription());
            TasktoUpdate.setDone(task.isDone());
            taskRepo.save(TasktoUpdate);
            newId = TasktoUpdate.getId();
            return newId;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newId;

    }

    public Long create(TaskManuplationRequest request) {
        var task = new TaskEntity(request.getTitle(), request.getDescription(), request.isDone());

        taskRepo.save(task);
        return task.getId();
    }

}
