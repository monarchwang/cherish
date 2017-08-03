package com.monarchwang.website.utils.http;

import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.*;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.LayeredConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.*;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.UnknownHostException;
import java.security.SecureRandom;
import java.security.Security;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HttpClientUtil {
	private static final Logger LOG = LoggerFactory.getLogger(HttpClientUtil.class);

	public static String doGetSend(String url) throws HttpException {
		CloseableHttpClient httpClient = null;

		String result = StringUtils.EMPTY;
		try {
			httpClient = HttpClientUtil.generateHttpClient(null);

			Map<String, String> headers = Maps.newHashMap();
			headers.put("content-type", "application/json");
			result = HttpClientUtil.sendGet(httpClient, url, headers);
		} catch (Exception e) {
			LOG.error("", e);
		} finally {
			try {
				if (null != httpClient) {
					httpClient.close();
				}
			} catch (IOException e) {
			}
		}

		return result;
	}

	public static String doPostSend(Map<String, String> map, String url) throws HttpException {
		CloseableHttpClient httpClient = null;

		String result = StringUtils.EMPTY;
		try {
			httpClient = HttpClientUtil.generateHttpClient(null);

			result = HttpClientUtil.sendPost(httpClient, url, false, map);
		} catch (Exception e) {
			LOG.error("", e);
			throw new HttpException("Http post异常: " + e.getMessage());
		} finally {
			try {
				if (null != httpClient) {
					httpClient.close();
				}
			} catch (IOException e) {
			}
		}

		return result;
	}

	public static String doPostSend(String json, String url) throws HttpException {
		CloseableHttpClient httpClient = null;

		String result = StringUtils.EMPTY;
		try {
			httpClient = HttpClientUtil.generateHttpClient(null);

			result = HttpClientUtil.sendPost(httpClient, url, false, json);
		} catch (Exception e) {
			LOG.error("", e);
			throw new HttpException("Http post异常: " + e.getMessage());
		} finally {
			try {
				if (null != httpClient) {
					httpClient.close();
				}
			} catch (IOException e) {
			}
		}

		return result;
	}

	public static String doPostSend(String json, String url, HttpClientConfiguration configuration) throws HttpException {
		CloseableHttpClient httpClient = null;

		String result = StringUtils.EMPTY;
		try {
			httpClient = HttpClientUtil.generateHttpClient(configuration);

			result = HttpClientUtil.sendPost(httpClient, url, false, json);
		} catch (Exception e) {
			LOG.error("", e);
			throw new HttpException("Http post异常: " + e.getMessage());
		} finally {
			try {
				if (null != httpClient) {
					httpClient.close();
				}
			} catch (IOException e) {
			}
		}

		return result;
	}

	public static CloseableHttpClient generateHttpClient(HttpClientConfiguration configuration) {
		int connectionRequestTimeout = 1000;
		int connectionTimeout = 3000;
		int socketTimeout = 6000;

		if (null != configuration) {
			if (0 != configuration.getConnectionRequestTimeout()) {
				connectionRequestTimeout = configuration.getConnectionRequestTimeout();
			}
			if (0 != configuration.getConnectionTimeout()) {
				connectionTimeout = configuration.getConnectionTimeout();
			}
			if (0 != configuration.getSocketTimeout()) {
				socketTimeout = configuration.getSocketTimeout();
			}
		}

		RequestConfig config = RequestConfig.custom().setConnectionRequestTimeout(connectionRequestTimeout)
				.setConnectTimeout(connectionTimeout).setSocketTimeout(socketTimeout).build();

		ConnectionSocketFactory plainsf = PlainConnectionSocketFactory.getSocketFactory();

		LayeredConnectionSocketFactory sslsf = SSLConnectionSocketFactory.getSocketFactory();

		Registry<ConnectionSocketFactory> registry =
				RegistryBuilder.<ConnectionSocketFactory>create().register("http", plainsf).register("https", sslsf).build();

		PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager(registry);
		// 将最大连接数增加
		cm.setMaxTotal(400);
		// 设置路由并发连接数
		cm.setDefaultMaxPerRoute(200);

		// 请求重试处理
		HttpRequestRetryHandler httpRequestRetryHandler = new HttpRequestRetryHandler() {
			public boolean retryRequest(IOException exception, int executionCount, HttpContext context) {
				if (executionCount >= 3)// 重试次数
				{
					return false;
				}
				if (exception instanceof NoHttpResponseException)// 如果服务器丢掉了连接，那么就重试
				{
					return true;
				}
				if (exception instanceof SSLHandshakeException)// 不要重试SSL握手异常
				{
					return true;
				}
				if (exception instanceof InterruptedIOException)// 超时
				{
					return true;
				}
				if (exception instanceof UnknownHostException)// 目标服务器不可达
				{
					return true;
				}
				if (exception instanceof ConnectTimeoutException)// 连接被拒绝
				{
					return true;
				}
				if (exception instanceof SSLException)// SSL握手异常
				{
					return true;
				}
				HttpClientContext clientContext = HttpClientContext.adapt(context);
				HttpRequest request = clientContext.getRequest();
				if (!(request instanceof HttpEntityEnclosingRequest))// 如果请求是幂等的，就再次尝试
				{
					return true;
				}
				return false;
			}
		};

		CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(cm).setRetryHandler(httpRequestRetryHandler)
				.setKeepAliveStrategy(new HttpClientKeepAliveStrategy()).setDefaultRequestConfig(config).build();

		return httpClient;
	}

	// trusting all certificate
	public static void doTrustToCertificates() throws Exception {
		Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
		TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager() {
			public X509Certificate[] getAcceptedIssuers() {
				return null;
			}

			public void checkServerTrusted(X509Certificate[] certs, String authType) throws CertificateException {
				return;
			}

			public void checkClientTrusted(X509Certificate[] certs, String authType) throws CertificateException {
				return;
			}
		}};

		SSLContext sc = SSLContext.getInstance("SSL");
		sc.init(null, trustAllCerts, new SecureRandom());
		HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
		HostnameVerifier hv = new HostnameVerifier() {
			public boolean verify(String urlHostName, SSLSession session) {
				if (!urlHostName.equalsIgnoreCase(session.getPeerHost())) {
					//System.out.println("Warning: URL host '" + urlHostName + "' is different to SSLSession host '" + session.getPeerHost() + "'.");
					LOG.warn("Warning: URL host '" + urlHostName + "' is different to SSLSession host '" + session.getPeerHost() + "'.");
				}
				return true;
			}
		};
		HttpsURLConnection.setDefaultHostnameVerifier(hv);
	}

	public static String sendGet(CloseableHttpClient client, String url) throws HttpException {
		return sendGet(client, url, null);
	}

	/**
	 * 发送Get请求
	 *
	 * @param client
	 * @param url
	 * @return
	 * @throws HttpException
	 */
	public static String sendGet(CloseableHttpClient client, String url, Map<String, String> headers) throws HttpException {
		try {
			doTrustToCertificates();
		} catch (Exception e1) {
		}

		if (null == client) {
			LOG.warn("send http get request error,HttpClient is null");
			return null;
		}

		HttpGet request = new HttpGet(url);
		if (null != headers) {
			for (String key : headers.keySet()) {
				request.setHeader(key, headers.get(key));
			}
		}
		request.setHeader("connection", "Keep-Alive");

		String result = StringUtils.EMPTY;

		HttpEntity entity = null;
		CloseableHttpResponse response = null;
		try {
			// 发送get请求，并获取response
			response = client.execute(request, HttpClientContext.create());
			int status = response.getStatusLine().getStatusCode();
			if (status != HttpStatus.OK.getCode() && status != HttpStatus.VOID.getCode()) {
				throw new HttpException(status);
			}
			entity = response.getEntity();
			if (null == entity && status != HttpStatus.VOID.getCode()) {
				throw new HttpException(HttpStatus.FAIL.getCode(), "Response Entity is null");
			}
			if (null != entity) {
				result = EntityUtils.toString(entity, "UTF-8");
			}
		} catch (Exception e) {
			LOG.error("", e);
//			throw new HttpException(HttpStatus.FAIL.getCode(), e.getMessage());
		} finally {
			if (null != entity) {
				try {
					EntityUtils.consume(entity);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (null != response) {
				try {
					response.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (null != request) {
				request.releaseConnection();
			}
		}

		return result;
	}

	public static String sendPost(CloseableHttpClient client, String url, boolean isJson, Map<String, String> params) throws HttpException {
		return sendPost(client, url, isJson, params, null);
	}

	private static String sendPost(CloseableHttpClient client, String url, boolean isJson, String json) throws HttpException {
		return sendPost(client, url, isJson, json, null);
	}

	private static String sendPost(CloseableHttpClient client, String url, boolean isJson, String json, Map<String, String> headers)
			throws HttpException {
		try {
			doTrustToCertificates();
		} catch (Exception e1) {
		}

		HttpPost request = new HttpPost(url);

		if (null != headers) {
			for (String key : headers.keySet()) {
				request.setHeader(key, headers.get(key));
			}
		}

		request.setHeader("connection", "Keep-Alive");
		if (isJson) {
			request.setHeader("content-type", "application/json");
		}
		HttpEntity entity = null;
		CloseableHttpResponse response = null;
		String result = StringUtils.EMPTY;
		try {
			request.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));
			response = client.execute(request, HttpClientContext.create());
			int status = response.getStatusLine().getStatusCode();
			if (status != HttpStatus.OK.getCode() && status != HttpStatus.VOID.getCode()) {
				throw new HttpException(status);
			}
			entity = response.getEntity();
			if (null == entity && status != HttpStatus.VOID.getCode()) {
				throw new HttpException(HttpStatus.FAIL.getCode(), "Response Entity is null");
			}
			if (null != entity) {
				result = EntityUtils.toString(entity, "UTF-8");
			}
		} catch (Exception e) {
			LOG.error("", e);
//			throw new HttpException(HttpStatus.FAIL.getCode(), e.getMessage());
		} finally {
			if (null != entity) {
				try {
					EntityUtils.consume(entity);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (null != response) {
				try {
					response.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (null != request) {
				request.releaseConnection();
			}
		}
		return result;
	}

	/**
	 * 发送Post请求
	 *
	 * @param client
	 * @param url
	 * @param isJson
	 * @param params
	 * @return
	 */
	public static String sendPost(CloseableHttpClient client, String url, boolean isJson, Map<String, String> params, Map<String, String> headers)
			throws HttpException {
		try {
			doTrustToCertificates();
		} catch (Exception e1) {
		}

		HttpPost request = new HttpPost(url);

		if (null != headers) {
			for (String key : headers.keySet()) {
				request.setHeader(key, headers.get(key));
			}
		}

		request.setHeader("connection", "Keep-Alive");
		if (isJson) {
			request.setHeader("content-type", "application/json");
		}
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		Set<String> keySet = params.keySet();
		for (String key : keySet) {
			nvps.add(new BasicNameValuePair(key, params.get(key).toString()));
		}
		HttpEntity entity = null;
		CloseableHttpResponse response = null;
		String result = StringUtils.EMPTY;
		try {
			request.setEntity(new UrlEncodedFormEntity(nvps, "UTF-8"));
			response = client.execute(request, HttpClientContext.create());
			int status = response.getStatusLine().getStatusCode();
			if (status != HttpStatus.OK.getCode() && status != HttpStatus.VOID.getCode()) {
				throw new HttpException(status);
			}
			entity = response.getEntity();
			if (null == entity && status != HttpStatus.VOID.getCode()) {
				throw new HttpException(HttpStatus.FAIL.getCode(), "Response Entity is null");
			}
			if (null != entity) {
				result = EntityUtils.toString(entity, "UTF-8");
			}
		} catch (Exception e) {
			LOG.error("", e);
//			throw new HttpException(HttpStatus.FAIL.getCode(), e.getMessage());
		} finally {
			if (null != entity) {
				try {
					EntityUtils.consume(entity);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (null != response) {
				try {
					response.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (null != request) {
				request.releaseConnection();
			}
		}
		return result;
	}
}
