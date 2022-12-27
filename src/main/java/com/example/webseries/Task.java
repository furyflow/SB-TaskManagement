package com.example.webseries;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name="task_table")
public class Task {
    @Id
    private String taskId;
    private String taskHolderName;
    private String taskDate;
    private String taskName;
    private String taskStatus;
}
