package com.monarchwang.website.utils.http;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;


public class HttpHandler {

	private static final Logger LOG = LoggerFactory.getLogger(HttpHandler.class);

	public <T> HttpResponse postModelRequest(T requeset, String url) {
		List<NameValuePair> data = new ArrayList<NameValuePair>();
		getParamList(requeset, data);
		return postEncodedFormRequest(data, url);
	}

	public HttpResponse postEncodedFormRequest(List<NameValuePair> formparams, String url) {

		UrlEncodedFormEntity uefEntity;
		try {
			uefEntity = new UrlEncodedFormEntity(formparams, "UTF-8");
			return getHttpResponse(uefEntity, url);
		} catch (Exception e) {
			LOG.error("executing request " + url, e);
		}
		return null;
	}

	public HttpResponse postStringRequest(String request, String url) {
		StringEntity strEntity;
		try {
			strEntity = new StringEntity(request, "UTF-8");
			return getHttpResponse(strEntity, url);
		} catch (Exception e) {
			LOG.error("executing request " + url, e);
		}
		return null;
	}

	private HttpResponse getHttpResponse(HttpEntity httpEntity, String url) {
		HttpPost httppost = new HttpPost(url);
		try {
			LOG.info("Requeset content: " + EntityUtils.toString(httpEntity, "UTF-8"));
			httppost.setEntity(httpEntity);
			LOG.info("executing request " + httppost.getURI());
			HttpClient httpclient = HttpClientConfig.get();
			if (httpclient == null)
				return null;
			return httpclient.execute(httppost);
		} catch (Exception e) {
			LOG.error("executing request error", e);
		}
		return null;
	}

	private final <T> List<NameValuePair> getParamList(T model, List<NameValuePair> list) {
		if (model == null) {
			return list;
		}
		Class<? extends Object> cc = model.getClass();
		Field[] Fields = cc.getFields();
		for (Field field : Fields) {
			try {
				if (field.get(model) != null && !field.get(model).toString().equals("")) {
					list.add(new BasicNameValuePair(field.getName(), field.get(model).toString()));
					LOG.info("[" + field.getName() + "]=[" + field.get(model) + "]");
				}
			} catch (Exception e) {
				LOG.error(field.getName(), e);
				continue;
			}
		}
		return list;
	}
}
