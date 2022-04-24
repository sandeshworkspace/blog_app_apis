package com.nit.sandesh.payloads;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {
	
	private String title;
	private String content;
	private String imageName;
	private Date addedDate;
	private UserDto user;
	private CategoryDto category;

}
