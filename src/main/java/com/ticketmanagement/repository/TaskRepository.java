package com.ticketmanagement.repository;

import com.ticketmanagement.model.Task;
import com.ticketmanagement.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByEmployee(Employee employee);
}
