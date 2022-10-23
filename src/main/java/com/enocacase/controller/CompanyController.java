package br.gahlls.example.springbootrelationship.controller;

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

import br.gahlls.example.springbootrelationship.model.Company;
import br.gahlls.example.springbootrelationship.request.CompanyRequest;
import br.gahlls.example.springbootrelationship.service.CompanyService;

@RestController
@RequestMapping("/v1/api/company")
public class CompanyController {

	private CompanyService companyService;
	private ModelMapper modelMapper;

	@Autowired
	public CompanyController(CompanyService companyService, ModelMapper modelMapper) {
		this.companyService = companyService;
		this.modelMapper = modelMapper;
	}
	
	@PostMapping
	public ResponseEntity<Company> insertCompany(@RequestBody CompanyRequest companyRequest) {
		Company company = modelMapper.map(companyRequest, Company.class);
		return ResponseEntity.ok(companyService.insert(company));
	}
	
	@GetMapping
	public ResponseEntity<List<Company>> getAll() {
		return ResponseEntity.ok(companyService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Company> getOne(@PathVariable("id") Integer id) {
		return ResponseEntity.ok(companyService.findById(id));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCompany(@PathVariable("id") Integer id){
		companyService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Company> updateCompany(@PathVariable("id") Integer id, @RequestBody CompanyRequest companyRequest){
		Company company = modelMapper.map(companyRequest, Company.class);
		return ResponseEntity.ok(companyService.update(id, company));
	}
}
