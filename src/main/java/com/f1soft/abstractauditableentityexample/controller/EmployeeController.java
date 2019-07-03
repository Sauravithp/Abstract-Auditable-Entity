package com.f1soft.abstractauditableentityexample.controller;

import com.f1soft.abstractauditableentityexample.entity.Employee;
import com.f1soft.abstractauditableentityexample.service.serviceimpl.EmployeeServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private EmployeeServiceImpl EmployeeService;

    public EmployeeController(EmployeeServiceImpl EmployeeService) {
        this.EmployeeService = EmployeeService;
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Employee employee){
        return ResponseEntity.ok(EmployeeService.create(employee));
    }
}
