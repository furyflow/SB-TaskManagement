package com.example.webseries;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskRestController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/saveTask")
    public ResponseEntity<String> saveTask(@RequestBody Task task){
        return new ResponseEntity<>(taskService.upsertTask(task), HttpStatus.ACCEPTED);
    }

    @PostMapping("/changeStatus")
    public ResponseEntity<String> changeTask(@RequestParam(name="id") String id,@RequestParam(name="status") String status){
        return new ResponseEntity<>(taskService.changeStatusTask(status,id),HttpStatus.OK);
    }

    @GetMapping("/alltasks")
    public ResponseEntity<List<Task>> getAllTasks(){
        return new ResponseEntity<>(taskService.getAllTaskH(),HttpStatus.OK);
    }

    @GetMapping("/getTask")
    public ResponseEntity<List<Task>> getByName(@RequestParam(name = "name1") String Hname){
        return new ResponseEntity<>(taskService.getByName(Hname),HttpStatus.OK);
    }


    @DeleteMapping("/deleteHouse")
    public ResponseEntity<String> deleteTasks(@RequestParam(name = "id") String id){
        return new ResponseEntity<>(taskService.deleteTask(id),HttpStatus.OK);
    }

}
