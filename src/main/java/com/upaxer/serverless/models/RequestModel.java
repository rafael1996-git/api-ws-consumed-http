package com.upaxer.serverless.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import com.upaxer.serverless.entity.template;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class RequestModel implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@JsonProperty("to")
	@SerializedName("to")
	private String to;
	@JsonProperty("type")
	@SerializedName("type")
	private String type;
	@JsonProperty("template")
	@SerializedName("template")
	 @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
	private List<template> template = new ArrayList<>();
	@JsonProperty("campaign_id")
	@SerializedName("campaign_id")
	private  String campaign_id;
	@JsonProperty("recipient_type")
	@SerializedName("recipient_type")
	private String recipient_type;
	
	
	public RequestModel(String to, String type, List<com.upaxer.serverless.entity.template> template,
			String campaign_id, String recipient_type) {
		this.to = to;
		this.type = type;
		this.template = template;
		this.campaign_id = campaign_id;
		this.recipient_type = recipient_type;
	}


	public RequestModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
