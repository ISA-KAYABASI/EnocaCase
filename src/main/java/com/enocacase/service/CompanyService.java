package com.enocacase.service;



import com.enocacase.model.Company;

import java.util.List;

public interface CompanyService {

	Company insert(Company company);
	
	List<Company> findAll();
	
	Company findById(Integer id);
	
	void delete(Integer id);
	
	Company update(Integer id, Company company);
}
