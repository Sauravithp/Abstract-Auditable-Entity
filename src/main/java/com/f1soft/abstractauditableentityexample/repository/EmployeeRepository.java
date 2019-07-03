package com.f1soft.abstractauditableentityexample.repository;

import com.f1soft.abstractauditableentityexample.entity.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
