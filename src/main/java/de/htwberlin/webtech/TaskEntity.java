package de.htwberlin.webtech;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
@Entity
@Table(name = "Task")
@AllArgsConstructor
@NoArgsConstructor

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

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public long getId() {
        return id;
    }

    public boolean getDone() {
        return done;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDone(boolean done) {
        this.done = done;
    }


}
