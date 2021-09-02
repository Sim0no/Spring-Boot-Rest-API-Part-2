package edu.eci.ieti.SpringBootRestAPIPart2.service.impl;

import edu.eci.ieti.SpringBootRestAPIPart2.data.Status;
import edu.eci.ieti.SpringBootRestAPIPart2.data.Task;
import edu.eci.ieti.SpringBootRestAPIPart2.dto.TaskDto;
import edu.eci.ieti.SpringBootRestAPIPart2.exception.TaskException;
import edu.eci.ieti.SpringBootRestAPIPart2.service.TaskService;
import org.springframework.stereotype.Service;

import java.security.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;




@Service
public class TaskServiceImpl implements TaskService {

    HashMap<String, Task> map = new HashMap<String, Task>();

    public TaskServiceImpl() {

        Task testTask1 = new Task(new TaskDto("Buscar", "Busqueda", "Marlon", java.time.LocalDate.now().toString(),false, Status.DONE));

        Task testTask2 = new Task(new TaskDto("Buscar", "Busqueda", "Pepe", java.time.LocalDate.now().toString(),false, Status.DOING));

        map.put(testTask1.getId(), testTask1);
        map.put(testTask2.getId(), testTask2);

    }

    @Override
    public Task create(TaskDto task) throws TaskException {
        Task newTask = new Task(task);
        if(map.containsKey(newTask.getId())){
            throw new TaskException("Esta tarea ya existe.");
        }

        map.put(newTask.getId(),newTask);
        return newTask;
    }

    @Override
    public Task findById(String id) throws TaskException {
        Task result = map.get(id);
        if(result==null){
            throw new TaskException("Tarea no existe.");

        }

        return result;
    }

    @Override
    public List<Task> all() {
        List<Task> users = new ArrayList<>(map.values());
        return users;
    }

    @Override
    public Task deleteById(String id) throws TaskException {
        Task taskDelete = map.remove(id);
        if(taskDelete==null){
            throw new TaskException("Esta Tarea no existe.");
        }
        return taskDelete;

    }

    @Override
    public Task update(TaskDto task, String id) throws TaskException {
        Task newTask = new Task(task);
        Task value = null;

        if(map.containsKey(id)){
            value = map.get(id);
            map.put(id,newTask);
        }

        if(value == null){
            throw new TaskException("Esta Tarea no existe.");
        }
        return value;
    }
}
