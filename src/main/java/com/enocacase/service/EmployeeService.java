package br.gahlls.example.springbootrelationship.service;

import java.util.List;

import br.gahlls.example.springbootrelationship.model.Employee;

public interface EmployeeService {

	Employee insert(Employee employee);
	
	List<Employee> findAll();
	
	Employee findById(Integer id);
	
	Employee update(Integer id, Employee employee);
	
	void delete(Integer id);
}
