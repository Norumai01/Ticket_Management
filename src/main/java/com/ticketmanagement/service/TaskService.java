package com.ticketmanagement.service;

import com.ticketmanagement.model.Task;
import com.ticketmanagement.model.Employee;
import com.ticketmanagement.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Task addTask(Task task) {
        return taskRepository.save(task);
    }

    public Task updateTask(Long id, Task updatedTask) {
        return taskRepository.findById(id).map(task ->
        {
            task.setTitle(updatedTask.getTitle());
            task.setDescription(updatedTask.getDescription());
            task.setStatus(updatedTask.getStatus());
            task.setEmployee(updatedTask.getEmployee());
            return taskRepository.save(task);
        })
        .orElseThrow(() -> new RuntimeException("Task not found"));
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    public List<Task> getTasksByEmployee(Employee employee) {
        return taskRepository.findByEmployee(employee);
    }

    public void deleteTaskById(Long id) {
        taskRepository.deleteById(id);
    }

    public Task updateTaskStatus(Long id, String status) {
        return taskRepository.findById(id).map(task ->
        {
            task.setStatus(status);
            return taskRepository.save(task);
        })
        .orElseThrow(() -> new RuntimeException("Task not found"));
    }
}
