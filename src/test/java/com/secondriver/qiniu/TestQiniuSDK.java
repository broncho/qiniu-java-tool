package com.secondriver.qiniu;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Properties;

import org.apache.commons.codec.EncoderException;
import org.json.JSONException;
import org.junit.Ignore;
import org.junit.Test;

import com.qiniu.api.auth.AuthException;
import com.qiniu.api.auth.digest.Mac;
import com.qiniu.api.config.Config;
import com.qiniu.api.io.IoApi;
import com.qiniu.api.io.PutExtra;
import com.qiniu.api.io.PutRet;
import com.qiniu.api.net.EncodeUtils;
import com.qiniu.api.rs.GetPolicy;
import com.qiniu.api.rs.PutPolicy;
import com.qiniu.api.rs.URLUtils;

/**
 * 七牛云存储原始SDK使用示例
 * 
 * @author secondriver
 * 
 */
public class TestQiniuSDK {

	public static String dir = "/常用开发图例";

	public static Properties properties;

	public static void start() {
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		URL url = loader.getResource("com/secondriver/qiniu/qiniu.properties");
		InputStream in;
		properties = new Properties();
		try {
			in = url.openStream();
			properties.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Config.ACCESS_KEY = properties.getProperty("accessKey");
		Config.SECRET_KEY = properties.getProperty("secretKey");
	}

	public static void end() {
		if (null != properties) {
			properties = null;
		}
	}

	@Ignore
	@Test
	public void test1() throws AuthException, JSONException {
		Mac mac = new Mac(Config.ACCESS_KEY, Config.SECRET_KEY);
		PutPolicy putPolicy = new PutPolicy(properties.getProperty("bucket"));
		String uptoken = putPolicy.token(mac);
		PutExtra extra = new PutExtra();
		String key = String.valueOf(System.currentTimeMillis());
		String fileName = dir + File.separator + "01.png";
		PutRet ret = IoApi.putFile(uptoken, key, fileName, extra);
		System.out.println(ret.toString());
	}

	@Ignore
	@Test
	public void test2() throws AuthException, JSONException,
			FileNotFoundException {
		Mac mac = new Mac(Config.ACCESS_KEY, Config.SECRET_KEY);
		PutPolicy putPolicy = new PutPolicy(properties.getProperty("bucket"));
		String uptoken = putPolicy.token(mac);
		PutExtra extra = new PutExtra();
		String key = String.valueOf(System.currentTimeMillis());
		String fileName = dir + File.separator + "02.png";
		InputStream reader = new FileInputStream(new File(fileName));
		PutRet ret = IoApi.Put(uptoken, key, reader, extra);
		System.out.println(ret.toString());
	}

	@SuppressWarnings("deprecation")
	@Ignore
	@Test
	public void test3() throws EncoderException {
		String url = URLUtils.makeBaseUrl("secondriver.qiniu.com",
				"wp-content/uploads/2014/05/1341540961LdnQWK1.jpg");
		System.out.println(url);
		System.out.println(EncodeUtils.urlsafeEncode(url));
		System.out.println(URLDecoder.decode(url));
	}

	@SuppressWarnings("deprecation")
	@Ignore
	@Test
	public void test4() throws EncoderException {
		String url = URLUtils.makeBaseUrl("secondriver-dev.qiniu.com",
				"1399965230092");
		System.out.println(url);
		System.out.println(EncodeUtils.urlsafeEncode(url));
		System.out.println(URLDecoder.decode(url));
	}

	@SuppressWarnings("deprecation")
	@Test
	public void test5() throws EncoderException, AuthException {
		GetPolicy getPolicy = new GetPolicy();
		Mac mac = new Mac(Config.ACCESS_KEY, Config.SECRET_KEY);
		String baseUrl = URLUtils.makeBaseUrl("secondriver-dev.qiniu.com",
				"1399965230092");
		String url = getPolicy.makeRequest(baseUrl, mac);
		System.out.println(url);
		System.out.println(EncodeUtils.urlsafeEncode(url));
		System.out.println(URLDecoder.decode(url));
	}
}
