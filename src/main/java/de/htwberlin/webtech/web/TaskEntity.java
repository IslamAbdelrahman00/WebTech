package de.htwberlin.webtech.web;

import lombok.AllArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Task")
@AllArgsConstructor

public class TaskEntity {
    @Id
    @SequenceGenerator(name = "task_seq", initialValue = 1110, allocationSize = 101)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "task_seq")
    @Column(name = "task_id", updatable = false, nullable = false)
    private long id;
    @NotBlank
    @Size(min = 3, message = "A title should have at least 3 characters")
    @Column(name = "task_title")
    private String title;
    @NotBlank
    @Size(min = 6, message = "the Description should have at least 6 characters")
    @Column(name = "task_description")
    private String description;
    @Column(name = "Task_complete")
    private boolean done;


    public TaskEntity() {
    }

    public TaskEntity(String title, String description, boolean done) {
        this.title = title;
        this.description = description;
        this.done = done;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public boolean getDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }


}
