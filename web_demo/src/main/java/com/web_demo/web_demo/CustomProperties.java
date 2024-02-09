package com.web_demo.web_demo;

import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@Configuration
public class CustomProperties {
	
	private String apiUrl = "http://localhost:9000";

	public String getApiUrl() {
		return this.apiUrl;
	}
}
