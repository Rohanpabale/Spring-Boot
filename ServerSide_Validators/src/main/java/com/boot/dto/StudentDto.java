package com.boot.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
	@NotNull(message = "null not allowed")
	private String studentName;
	@Email(message = "enter valid email")
	private String studentEmail;
	@Min(value = 18, message = "age must be greater than 18")
	private Integer studentAge;

}
