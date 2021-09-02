package edu.eci.ieti.SpringBootRestAPIPart2.service;

import edu.eci.ieti.SpringBootRestAPIPart2.data.Task;
import edu.eci.ieti.SpringBootRestAPIPart2.dto.TaskDto;
import edu.eci.ieti.SpringBootRestAPIPart2.exception.TaskException;

import java.util.List;

public interface TaskService
{
    Task create(TaskDto task ) throws TaskException;

    Task findById( String id ) throws TaskException ;

    List<Task> all();

    Task deleteById( String id ) throws TaskException;

    Task update( TaskDto task, String id ) throws TaskException ;
}


