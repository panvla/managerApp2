package com.vladimirpandurov.managerApp2B.service;

import com.vladimirpandurov.managerApp2B.domain.Employee;
import com.vladimirpandurov.managerApp2B.exception.UserNotFoundException;
import com.vladimirpandurov.managerApp2B.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public Employee findEmployeeById(Long id){
        return this.employeeRepository.findEmployeeById(id).orElseThrow(()-> new UserNotFoundException("User by id " + id + " was not found"));
    }

    public List<Employee> findAllEmployees(){
        return this.employeeRepository.findAll();
    }

    public Employee addEmployee(Employee employee){
        return this.employeeRepository.save(employee);
    }

    public Employee updateEmployee(Employee employee){
        return this.employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id){
        this.employeeRepository.deleteEmployeesById(id);
    }

}
