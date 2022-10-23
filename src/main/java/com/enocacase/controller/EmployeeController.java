package br.gahlls.example.springbootrelationship.controller;

import java.net.URI;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.gahlls.example.springbootrelationship.model.Employee;
import br.gahlls.example.springbootrelationship.request.AddEmployeeRequest;
import br.gahlls.example.springbootrelationship.request.UpdateEmployeeRequest;
import br.gahlls.example.springbootrelationship.service.EmployeeService;

@RestController
@RequestMapping("/v1/api/employee")
public class EmployeeController {
	
	private EmployeeService employeeService;
	private ModelMapper modelMapper;
	
	@Autowired
	public EmployeeController(EmployeeService employeeService, ModelMapper modelMapper) {
		this.employeeService = employeeService;
		this.modelMapper = modelMapper;
	}
	
	@PostMapping
	public ResponseEntity<URI> addEmployee(@RequestBody AddEmployeeRequest addEmployeeRequest){
		Employee employee = modelMapper.map(addEmployeeRequest, Employee.class);
		Employee employeeSaved = employeeService.insert(employee);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(employeeSaved.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@GetMapping
	public ResponseEntity<List<Employee>> getAll() {
		return ResponseEntity.ok(employeeService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Employee> getOne(@PathVariable("id") Integer id) {
		return ResponseEntity.ok(employeeService.findById(id));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Integer id, @RequestBody UpdateEmployeeRequest updateEmployeeRequest){
		Employee employee = modelMapper.map(updateEmployeeRequest, Employee.class);
		return ResponseEntity.ok(employeeService.update(id, employee));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable("id") Integer id){
		employeeService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
