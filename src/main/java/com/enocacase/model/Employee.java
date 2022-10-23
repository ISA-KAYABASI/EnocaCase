package br.gahlls.example.springbootrelationship.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
