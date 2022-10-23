package com.enocacase.service;


import com.enocacase.model.Employee;

import java.util.List;

public interface EmployeeService {

	Employee insert(Employee employee);
	
	List<Employee> findAll();
	
	Employee findById(Integer id);
	
	Employee update(Integer id, Employee employee);
	
	void delete(Integer id);
}
