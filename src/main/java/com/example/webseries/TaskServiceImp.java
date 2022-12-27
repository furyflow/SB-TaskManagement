package com.example.webseries;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImp implements TaskService {

    @Autowired
    private TaskRepository taskRepo;


    @Override
    public String upsertTask(Task task) {
        taskRepo.save(task);
        return "Success";
    }

    @Override
    public String changeStatusTask(String status,String id) {
        Optional<Task> t1 = taskRepo.findById(id);
        if(t1.isPresent()){
            Task t2 = t1.get();
            t2.setTaskStatus(status);
            taskRepo.save(t2);
            return "success";
        }
        else
            return "no record found";

    }

    @Override
    public List<Task> getAllTaskH() {
        return taskRepo.findAll();
    }

    @Override
    public List<Task> getByName(String name) {
        return taskRepo.findByTaskHolderName(name);
    }

    @Override
    public String deleteTask(String id) {
        if(taskRepo.existsById(id)){
            taskRepo.deleteById(id);
            return "Deleted Successfully";
        } else{
            return "No record found";
        }
    }
}
