package com.secondriver.qiniu.utils;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

/**
 * 
 * HTTP请求处理工具
 * 
 * @author ZhangXiao
 * 
 * @see 七牛云存储：http://www.qiniu.com/ 野马红尘：http://aiilive.blog.51cto.com/
 */
public class HttpUtils {

	/**
	 * 获取指定URL的文件扩展名
	 * 
	 * @param url
	 * @return
	 */
	public static String getExtension(String url) {
		HttpResponse response = getResponse(url);
		if (null != response) {
			HttpEntity entity = response.getEntity();
			return ExtensionWithContentType.getExtension(entity
					.getContentType().getValue());
		} else {
			return ExtensionWithContentType.getExtension(null);
		}
	}

	/**
	 * 判断指定URL的Token是否有效
	 * 
	 * @param url
	 * @return
	 */
	public static boolean tokenIsValid(String url) {

		return false;
	}

	private static HttpResponse getResponse(String url) {
		HttpClient http = new DefaultHttpClient();
		HttpGet get = new HttpGet(url);
		HttpResponse response = null;
		try {
			response = http.execute(get);
			return response;
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
