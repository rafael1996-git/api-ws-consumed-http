package com.upaxer.serverless.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
public class components implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@JsonProperty("type")
	@SerializedName("type")
	private String type;
	@JsonProperty("index")
	@SerializedName("index")
	private String index;
	@JsonProperty("sub_type")
	@SerializedName("sub_type")
	private String sub_type;
	@JsonProperty("parameters")
	@SerializedName("parameters")
	 @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
	private List<parameters> parameters = new ArrayList<>();
	public components(String type, String index, String sub_type,
			List<com.upaxer.serverless.entity.parameters> parameters) {
		super();
		this.type = type;
		this.index = index;
		this.sub_type = sub_type;
		this.parameters = parameters;
	}
	public components() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
