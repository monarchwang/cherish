package com.monarchwang.website.utils.http;

import lombok.Data;

/**
 *
 */
@Data
public class HttpClientConfiguration {
	private int connectionRequestTimeout;
	private int connectionTimeout;
	private int socketTimeout;

	public HttpClientConfiguration() {
		connectionRequestTimeout = 0;
		connectionTimeout = 0;
		socketTimeout = 0;
	}
}
