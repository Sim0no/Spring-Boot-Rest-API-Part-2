package edu.eci.ieti.SpringBootRestAPIPart2.data;

import edu.eci.ieti.SpringBootRestAPIPart2.dto.TaskDto;

import java.util.UUID;

public class Task {

    private String id, name, description, assignedTo, dueDate;
    private boolean created;
    private Status status;

    public Task(String id, String name, String description, String assignedTo, String dueDate, boolean created, Status status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.assignedTo = assignedTo;
        this.dueDate = dueDate;
        this.created = created;
        this.status = status;
    }

    public Task(TaskDto task) {
        this.id = UUID.randomUUID().toString();
        this.name = task.getName();
        this.description = task.getDescription();
        this.assignedTo = task.getAssignedTo();
        this.dueDate = task.getDueDate();
        this.created = task.isCreated();
        this.status = task.getStatus();

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public boolean isCreated() {
        return created;
    }

    public void setCreated(boolean created) {
        this.created = created;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }
}
