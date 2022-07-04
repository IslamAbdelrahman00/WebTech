package de.htwberlin.webtech.web;

import de.htwberlin.webtech.web.TaskEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepo extends CrudRepository<TaskEntity, Long> {
}