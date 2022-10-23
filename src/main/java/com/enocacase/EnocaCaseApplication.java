package com.enocacase;

import com.enocacase.model.Company;
import com.enocacase.model.Employee;
import com.enocacase.repository.CompanyRepository;
import com.enocacase.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Optional;

@SpringBootApplication
public class EnocaCaseApplication implements CommandLineRunner {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    public static void main(String[] args) {
        SpringApplication.run(EnocaCaseApplication.class, args);
    }

    @Override
    public void run(String... args) {
        // Create a couple of employee and Company
        Company workPlace = companyRepository.save(new Company("ENOCA", new Employee("Isa Kayabasi", 50.00), new Employee("Yusuf Hazar", 30.35)));

        // Find a Company
        Optional<Company> company = companyRepository.findById(workPlace.getId());

        Employee newEmployee = new Employee("Hamit Solmaz", 45.00);
        newEmployee.setCompany(company.get());

        // Save a new employee
        employeeRepository.save(newEmployee);

        // Create a new Company
        Company fantasy = companyRepository.save(new Company("IND"));

        Employee employee = new Employee("Balaban Kirilmaz", 40.00);
        employee.setCompany(fantasy); // Set Company to a new employee

        // Save a new Employee with a new Company
        employeeRepository.save(employee);
    }

}
