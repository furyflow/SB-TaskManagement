package com.example.webseries;

import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.List;


public interface TaskRepository extends JpaRepository<Task, Serializable>{

    List<Task> findByTaskHolderName(String name);
}
