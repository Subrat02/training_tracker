package com.hcl.employee_management_tool.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.employee_management_tool.domain.Employee;
import com.hcl.employee_management_tool.service.EmployeeService;



@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
   @Autowired
	private EmployeeService employeeService;
   @PostMapping("/create")
   public Employee createdNewEmployee(@RequestBody Employee employee) {
	   Employee savedEmployee=employeeService.create(employee);
	   return savedEmployee;
   }
   @GetMapping("/all")
	public Iterable<Employee> getAllEmployee(){
		return employeeService.findAllEmployee();
	}
	   
   @PutMapping("/update/{id}")
    public Employee update(@RequestParam String name,@PathVariable("id") Long id) {
    	return employeeService.update(name, id);
    }
   @GetMapping("/delete/{id}")
   public Employee delete(@PathVariable("id") Long id) {
	   return employeeService.delete(id);
   }
}



