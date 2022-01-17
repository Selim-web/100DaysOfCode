package com.frontend;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.*;

@Configuration
@ConfigurationProperties(prefix="com.frontend")
public class CustomProperties {

	
	private String apiUrl;

	public String getApiUrl() {
		return apiUrl;
	}

	public void setApiUrl(String apiUrl) {
		this.apiUrl = apiUrl;
	}
}
