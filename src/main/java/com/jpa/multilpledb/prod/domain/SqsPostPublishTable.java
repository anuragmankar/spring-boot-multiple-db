package com.jpa.multilpledb.prod.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "customer" ,name = "customer_publish_error_catalog_prod")
public class SqsPostPublishTable {

	@Id
	@GeneratedValue
	@Column(name = "error_id")
	private Long id;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "batch_online_indicator")
	private String batchOnlineIndicator;
	
	@Column(name = "request")
	private String request;
	
	@Column(name = "response")
	private String response;
	
	@Column(name = "response_code")
	private String responseCode;
	
	@Column(name = "error_timestamp")
	private String errorTimestamp;
	
	@Column(name = "place_where_error_occurs")
	private String placeWhereErrorOccurs;
	
	public SqsPostPublishTable() {
	}

	public SqsPostPublishTable(String status, String batchOnlineIndicator, String request, String response,
			String responseCode, String placeWhereErrorOccurs) {
		this.status = status;
		this.batchOnlineIndicator = batchOnlineIndicator;
		this.request = request;
		this.response = response;
		this.responseCode = responseCode;
		this.placeWhereErrorOccurs = placeWhereErrorOccurs;
	}

	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getBatchOnlineIndicator() {
		return batchOnlineIndicator;
	}

	public void setBatchOnlineIndicator(String batchOnlineIndicator) {
		this.batchOnlineIndicator = batchOnlineIndicator;
	}

	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public String getErrorTimestamp() {
		return errorTimestamp;
	}

	public void setErrorTimestamp(String errorTimestamp) {
		this.errorTimestamp = errorTimestamp;
	}

	public String getPlaceWhereErrorOccurs() {
		return placeWhereErrorOccurs;
	}

	public void setPlaceWhereErrorOccurs(String placeWhereErrorOccurs) {
		this.placeWhereErrorOccurs = placeWhereErrorOccurs;
	}
	
	
}
