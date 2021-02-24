package com.example.gira2.web;

import com.example.gira2.model.binding.TaskAddBindingModel;
import com.example.gira2.model.entity.ProgressEnum;
import com.example.gira2.model.service.TaskServiceModel;
import com.example.gira2.model.service.UserServiceModel;
import com.example.gira2.service.TaskService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;
    private final ModelMapper modelMapper;

    public TaskController(TaskService taskService, ModelMapper modelMapper) {
        this.taskService = taskService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/add")
    public String add(Model model, HttpSession httpSession) {
        if (httpSession.getAttribute("user") == null) {
            return redirectLogin();
        }
        if (!model.containsAttribute("taskAddBindingModel")) {
            model.addAttribute(new TaskAddBindingModel());
        }
        return "add-task";
    }

    @PostMapping("/add")
    public String addPost(@Valid TaskAddBindingModel taskAddBindingModel,
                          BindingResult bindingResult,
                          RedirectAttributes redirectAttributes,
                          HttpSession httpSession) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("taskAddBindingModel", taskAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.taskAddBindingModel", bindingResult);

            return redirectAddTask();
        }

        TaskServiceModel taskServiceModel = modelMapper.map(taskAddBindingModel, TaskServiceModel.class);

        taskServiceModel.setUserServiceModel((UserServiceModel) httpSession.getAttribute("user"));
        taskServiceModel.setProgressName(ProgressEnum.OPEN);
        taskService.addTask(taskServiceModel);

        return redirectHome();
    }

    @GetMapping("/progress/{id}")
    public String changeProgress(@PathVariable Long id, HttpSession httpSession) {
        if (httpSession.getAttribute("user") == null) {
            return redirectLogin();
        }

        taskService.changeProgress(id);

        return redirectHome();
    }

    private String redirectAddTask() {
        return "redirect:add";
    }

    private String redirectHome() {
        return "redirect:/";
    }

    private String redirectLogin() {
        return "redirect:/users/login";
    }
}
