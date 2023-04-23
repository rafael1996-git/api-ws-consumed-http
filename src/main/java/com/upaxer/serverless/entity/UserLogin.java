package com.upaxer.serverless.entity;



import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLogin {
	@JsonProperty
	private String user;
	@JsonProperty
	private String password;

}
