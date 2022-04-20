package com.nit.sandesh.payloads;

import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {
	
	private Integer categoryId;
	@NotEmpty
	private String categoryTitle;
	@NotEmpty
	private String categoryDiscripter;

}
