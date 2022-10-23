package br.gahlls.example.springbootrelationship.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateEmployeeRequest {

	private String fullName;
	private Double salary;
	
	@JsonProperty("id-category")
	private int idBookCategory;
}
