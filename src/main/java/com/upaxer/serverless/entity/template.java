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
public class template implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@JsonProperty("name")
	@SerializedName("name")
	private String name;
	@JsonProperty("language")
	@SerializedName("language")
	 @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
	private List<language> language = new ArrayList<>();
	@JsonProperty("namespace")
	@SerializedName("namespace")
	private String namespace;
	@JsonProperty("components")
	@SerializedName("components")
	 @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
	private List<components> components = new ArrayList<>();
	public template(String name, List<com.upaxer.serverless.entity.language> language, String namespace,
			List<com.upaxer.serverless.entity.components> components) {
		super();
		this.name = name;
		this.language = language;
		this.namespace = namespace;
		this.components = components;
	}
	public template() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
