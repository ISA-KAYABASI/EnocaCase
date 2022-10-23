package br.gahlls.example.springbootrelationship.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.gahlls.example.springbootrelationship.model.Company;
import br.gahlls.example.springbootrelationship.repository.CompanyRepository;
import br.gahlls.example.springbootrelationship.service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyRepository companyRepository;

	@Override
	public Company insert(Company company) {
		return companyRepository.save(company);
	}

	@Override
	public List<Company> findAll() {
		return companyRepository.findAll();
	}

	@Override
	public Company findById(Integer id) {
		return companyRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found with id: " + id));
	}

	@Override
	public void delete(Integer id) {
		Company company = this.findById(id);
		companyRepository.delete(company);
	}

	@Override
	public Company update(Integer id, Company company) {
		Company companyCurrent = this.findById(id);
		companyCurrent.setCompanyName(company.getCompanyName());
		return companyRepository.save(companyCurrent);
	}
}
