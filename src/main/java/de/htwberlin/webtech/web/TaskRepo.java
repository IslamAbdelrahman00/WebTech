package de.htwberlin.webtech.web;

import de.htwberlin.webtech.web.TaskEntity;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepo extends CrudRepository<TaskEntity, Long> {
}