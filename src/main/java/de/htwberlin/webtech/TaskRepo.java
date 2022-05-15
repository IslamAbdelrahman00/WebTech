package de.htwberlin.webtech;

import de.htwberlin.webtech.TaskEntity;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepo extends CrudRepository<TaskEntity, Long> {
}