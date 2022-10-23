package com.enocacase.service.impl;


import com.enocacase.model.Employee;
import com.enocacase.repository.EmployeeRepository;
import com.enocacase.service.CompanyService;
import com.enocacase.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private CompanyService companyService;

	@Override
	public Employee insert(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee findById(Integer id) {
		return employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found with id: " +id));
	}

	@Override
	public Employee update(Integer id, Employee employee) {
		Employee employeeCurrent = this.findById(id);
		employeeCurrent.setCompany(companyService.findById(employee.getCompany().getId()));
		employeeCurrent.setSalary(employee.getSalary());
		employeeCurrent.setFullName(employee.getFullName());
		return employeeRepository.save(employeeCurrent);
	}

	@Override
	public void delete(Integer id) {
		Employee employeeCurrent = this.findById(id);
		employeeRepository.delete(employeeCurrent);
	}
}
