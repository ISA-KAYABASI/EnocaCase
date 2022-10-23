package com.enocacase.controller;


import com.enocacase.model.Company;
import com.enocacase.request.CompanyRequest;
import com.enocacase.service.CompanyService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

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
