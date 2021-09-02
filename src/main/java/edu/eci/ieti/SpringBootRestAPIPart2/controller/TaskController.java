package edu.eci.ieti.SpringBootRestAPIPart2.controller;

import edu.eci.ieti.SpringBootRestAPIPart2.data.Task;
import edu.eci.ieti.SpringBootRestAPIPart2.dto.TaskDto;
import edu.eci.ieti.SpringBootRestAPIPart2.exception.TaskException;
import edu.eci.ieti.SpringBootRestAPIPart2.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( "/v1/task" )
public class TaskController {

    private final TaskService taskService;

    public TaskController(@Autowired TaskService taskService )
    {
        this.taskService = taskService;
    }


    @GetMapping
    public ResponseEntity<List<Task>> all()
    {

        return new ResponseEntity<>(taskService.all(), HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable String id )
    {
        try {
            return new ResponseEntity<>(taskService.findById(id),HttpStatus.OK);
        } catch (TaskException e) {

            return new ResponseEntity<>(e,HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping
    public ResponseEntity<?> create( @RequestBody TaskDto taskDto )
    {
        try {
            return new ResponseEntity<>(taskService.create(taskDto),HttpStatus.CREATED);
        } catch (TaskException e) {
            return new ResponseEntity<>(e,HttpStatus.FORBIDDEN);

        }
    }

    @PutMapping( "/{id}" )
    public ResponseEntity<?> update( @RequestBody TaskDto taskDto, @PathVariable String id )
    {
        try {
            return new ResponseEntity<>(taskService.update(taskDto,id),HttpStatus.NO_CONTENT);
        } catch (TaskException e) {
            return new ResponseEntity<>(e,HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping( "/{id}" )
    public ResponseEntity<?> delete( @PathVariable String id )
    {
        try {
            return new ResponseEntity<>(taskService.deleteById(id),HttpStatus.OK);
        } catch (TaskException e) {
            return new ResponseEntity<>(e,HttpStatus.NOT_FOUND);
        }

    }


}
