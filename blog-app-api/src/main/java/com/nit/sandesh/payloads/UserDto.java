package com.nit.sandesh.payloads;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

	private int id;
	@NotEmpty
	@Size(min = 4,message = "UserName must be at list 4 characters")
	private String name;
	@Email(message = "Email address is not valid ")
	private String email;
	@NotEmpty
	@Size(min = 3, message = "password must be at list 3 characters")
	private String password;
	@NotEmpty
	
	private String about;

}
