package com.example.webseries;

import java.util.List;

public interface TaskService {
    public String upsertTask(Task task);

    public String changeStatusTask(String status,String id);

    public List<Task> getAllTaskH();

    public List<Task> getByName(String name);

    public String deleteTask(String id);


}
