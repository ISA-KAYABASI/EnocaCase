package com.enocacase.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String fullName;
	private Double salary;
	
	@ManyToOne
	@JoinColumn
	private Company company;
	
	public Employee(String fullName, Double salary) {
		this.fullName = fullName;
		this.salary = salary;
	}
}
