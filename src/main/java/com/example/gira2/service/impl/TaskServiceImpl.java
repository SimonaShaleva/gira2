package com.example.gira2.service.impl;

import com.example.gira2.model.entity.ProgressEnum;
import com.example.gira2.model.entity.Task;
import com.example.gira2.model.entity.User;
import com.example.gira2.model.service.TaskServiceModel;
import com.example.gira2.model.service.UserServiceModel;
import com.example.gira2.repository.TaskRepository;
import com.example.gira2.service.ClassificationService;
import com.example.gira2.service.TaskService;
import com.example.gira2.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    private final ModelMapper modelMapper;
    private final UserService userService;
    private final ClassificationService classificationService;

    public TaskServiceImpl(TaskRepository taskRepository,
                           ModelMapper modelMapper,
                           UserService userService, ClassificationService classificationService) {
        this.taskRepository = taskRepository;
        this.modelMapper = modelMapper;
        this.userService = userService;
        this.classificationService = classificationService;
    }

    @Override
    public void addTask(TaskServiceModel taskServiceModel) {
        Task task = modelMapper.map(taskServiceModel, Task.class);
        task.setProgressName(ProgressEnum.OPEN);
        task.setClassification(classificationService.findByClassification(taskServiceModel.getClassification()));

        taskRepository.save(task);
    }

//    @Override
//    public void changeProgress(Long id) {
//        Task task = taskRepository.findById(id).get();
//
//        if (task.getProgress().equals(Progress.OPEN)) {
//            task.setProgress(Progress.IN_PROGRESS);
//            taskRepository.save(task);
//        } else if (task.getProgress().equals(Progress.IN_PROGRESS)) {
//            task.setProgress(Progress.COMPLETED);
//            taskRepository.save(task);
//        } else {
//            taskRepository.deleteById(id);
//        }
//    }

//    @Override
//    public List<TaskViewModel> getAllTasks() {
//        List<TaskViewModel> viewModels = new ArrayList<>();
//
//        List<Task> tasks = taskRepository.findAll();
//
//        tasks.forEach(task -> {
//            TaskViewModel taskViewModel = new TaskViewModel();
//            modelMapper.map(task, taskViewModel);
//            taskViewModel.setAssignedTo(task.getUser().getUsername());
//            taskViewModel.setClassification(task.getClassification().getClassificationName());
//            taskViewModel.setProgress(task.getProgress());
//
//            viewModels.add(taskViewModel);
//        });
//
//        return viewModels;
//    }
}
