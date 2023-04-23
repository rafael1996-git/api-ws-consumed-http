package com.upaxer.serverless.entity;



import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

public class language {

	@JsonProperty("code")
	@SerializedName("code")
	private String code;
	@JsonProperty("policy")
	@SerializedName("policy")
	private String policy;
	public language(String code, String policy) {
		super();
		this.code = code;
		this.policy = policy;
	}
	public language() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
