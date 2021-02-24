package com.example.gira2.service;

import com.example.gira2.model.service.TaskServiceModel;
import com.example.gira2.model.service.UserServiceModel;
import com.example.gira2.model.view.TaskViewModel;

import java.util.List;

public interface TaskService {
    void addTask(TaskServiceModel taskServiceModel);

    List<TaskViewModel> findAllTasks();

    void changeProgress(Long id);
}
