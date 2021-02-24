package com.example.gira2.service.impl;

import com.example.gira2.model.entity.ProgressEnum;
import com.example.gira2.model.entity.Task;
import com.example.gira2.model.entity.User;
import com.example.gira2.model.service.TaskServiceModel;
import com.example.gira2.model.service.UserServiceModel;
import com.example.gira2.model.view.TaskViewModel;
import com.example.gira2.repository.TaskRepository;
import com.example.gira2.service.ClassificationService;
import com.example.gira2.service.TaskService;
import com.example.gira2.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    private final ModelMapper modelMapper;
    private final ClassificationService classificationService;
    private final UserService userService;

    public TaskServiceImpl(TaskRepository taskRepository,
                           ModelMapper modelMapper, ClassificationService classificationService, UserService userService) {
        this.taskRepository = taskRepository;
        this.modelMapper = modelMapper;
        this.classificationService = classificationService;
        this.userService = userService;
    }

    @Override
    public void addTask(TaskServiceModel taskServiceModel) {
        Task task = modelMapper.map(taskServiceModel, Task.class);
        task.setClassification(classificationService
                .findByClassification(taskServiceModel.getClassification()));

        taskRepository.save(task);
    }

    @Override
    public List<TaskViewModel> findAllTasks() {
        List<Task> list = taskRepository.findAll();
        List<TaskServiceModel> taskServiceModelList = new ArrayList<>();
        for (Task t : list) {
            TaskServiceModel taskServiceModel = modelMapper.map(t, TaskServiceModel.class);
            taskServiceModel.setUserServiceModel(modelMapper.map(t.getUser(), UserServiceModel.class));
            taskServiceModelList.add(taskServiceModel);

        }
        List<TaskViewModel> taskViewModelsList = new ArrayList<>();
        for (TaskServiceModel taskServiceModel : taskServiceModelList) {
            TaskViewModel taskViewModel = modelMapper.map(taskServiceModel, TaskViewModel.class);
            // taskViewModel.setClassification(classificationService.findByClassification(taskServiceModel.getClassification()).getClassification());
            User user = modelMapper.map(userService.findById(taskServiceModel.getUserServiceModel().getId()), User.class);
            taskViewModel.setAssignedTo(user.getUsername());
            taskViewModelsList.add(taskViewModel);

        }
        return taskViewModelsList;
    }

    @Override
    public void changeProgress(Long id) {
        Task task = taskRepository.findById(id).get();

        if (task.getProgressName().equals(ProgressEnum.OPEN)) {
            task.setProgressName(ProgressEnum.IN_PROGRESS);
            taskRepository.save(task);
        } else if (task.getProgressName().equals(ProgressEnum.IN_PROGRESS)) {
            task.setProgressName(ProgressEnum.COMPLETED);
            taskRepository.save(task);
        } else {
            taskRepository.deleteById(id);
        }
    }

}
