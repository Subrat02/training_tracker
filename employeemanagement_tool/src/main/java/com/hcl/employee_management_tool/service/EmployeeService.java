package com.hcl.employee_management_tool.service;



import com.hcl.employee_management_tool.domain.Employee;



public interface EmployeeService {
   public Employee create(Employee employee);
   public Iterable<Employee> findAllEmployee();
   public Employee update(String name,Long id);
   public Employee delete(Long id);
}
