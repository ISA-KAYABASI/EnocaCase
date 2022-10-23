package br.gahlls.example.springbootrelationship.service;

import java.util.List;

import br.gahlls.example.springbootrelationship.model.Company;

public interface CompanyService {

	Company insert(Company company);
	
	List<Company> findAll();
	
	Company findById(Integer id);
	
	void delete(Integer id);
	
	Company update(Integer id, Company company);
}
