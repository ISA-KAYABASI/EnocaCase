package br.gahlls.example.springbootrelationship.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddEmployeeRequest {

	private String fullName;
	private Double salary;
}
