package com.enocacase.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude ="employees")
@Entity
public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String companyName;

	@JsonIgnore
	@OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
	private Set<Employee> employees;

	public Company(String companyName, Employee... employees) {
		this.companyName = companyName;
		this.employees = Stream.of(employees).collect(Collectors.toSet());
		this.employees.forEach(x -> x.setCompany(this));
	}
}
