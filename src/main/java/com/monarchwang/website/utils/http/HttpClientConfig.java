package com.monarchwang.website.utils.http;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.http.client.HttpClient;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;

public class HttpClientConfig {
	public static final int RESPONSE_CODE_OK = 200;
	public static final int TIMEOUT = 30000;
	private static final int DEFAULT_MAX_CONNECTION_PER_ROUTE = 50;
	private static final int TOTAL_MAX_CONNECTION = 100;
	private static HttpClient client;

	public HttpClientConfig() {
	}

	public static void initialize() {
		SSLContext context = null;

		try {
			context = SSLContext.getInstance("TLS");
			context.init((KeyManager[]) null, new TrustManager[]{new X509TrustManager() {
				public X509Certificate[] getAcceptedIssuers() {
					return null;
				}

				public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
				}

				public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
				}
			}}, (SecureRandom) null);
		} catch (KeyManagementException | NoSuchAlgorithmException var2) {
			var2.printStackTrace();
			throw new RuntimeException("Cannot create http client");
		}

		ThreadSafeClientConnManager connManager = new ThreadSafeClientConnManager();
		connManager.setDefaultMaxPerRoute(50);
		connManager.setMaxTotal(100);
		connManager.getSchemeRegistry().register(new Scheme("https", 443, new SSLSocketFactory(context, SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER)));
		client = new DefaultHttpClient(connManager);
		client.getParams().setIntParameter("http.connection.timeout", 30000);
		client.getParams().setIntParameter("http.socket.timeout", 30000);
	}

	public static HttpClient get() {
		return client;
	}
}
