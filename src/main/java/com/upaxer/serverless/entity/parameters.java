package com.upaxer.serverless.entity;



import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class parameters {

	@JsonProperty("type")
	@SerializedName("type")
	private String type;
	@JsonProperty
	@SerializedName("payload")
	private String payload;
	public parameters(String type, String payload) {
		super();
		this.type = type;
		this.payload = payload;
	}
	public parameters() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
