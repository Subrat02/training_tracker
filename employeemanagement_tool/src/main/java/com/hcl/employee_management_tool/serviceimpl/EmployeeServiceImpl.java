package com.hcl.employee_management_tool.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.employee_management_tool.domain.Employee;
import com.hcl.employee_management_tool.repository.EmployeeRepository;
import com.hcl.employee_management_tool.service.EmployeeService;
@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee create(Employee employee) {
		
		return  employeeRepository.save(employee);
	}

	@Override
	public Iterable<Employee> findAllEmployee() {
		
		return employeeRepository.findAll();
	}

	@Override
	public Employee update(String name,Long id) {
		
			Optional<Employee>employeeFromDb=employeeRepository.findById(id);
			if(!employeeFromDb.isEmpty()) {
			
			Employee employee=employeeFromDb.get();
				employee.setId(id);
				employee.setName(name);
				
				 employeeRepository.save(employee);
		}
			return employeeFromDb.get();
		
		
		
		}
	
	
	@Override
	public Employee delete(Long id) {
		Optional<Employee>employeeFromDb=employeeRepository.findById(id);
		if(!employeeFromDb.isEmpty()) {
		 Employee employee=employeeFromDb.get();
			employee.setId(id);
		     employeeRepository.delete(employee);
		}
			return employeeFromDb.get();
	}
	
	
		
	

}
