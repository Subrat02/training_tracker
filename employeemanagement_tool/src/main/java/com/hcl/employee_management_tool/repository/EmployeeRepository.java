package com.hcl.employee_management_tool.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hcl.employee_management_tool.domain.Employee;
@Repository
public interface EmployeeRepository extends CrudRepository<Employee,Long> {
    
}
