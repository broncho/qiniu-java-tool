package secondriver.qiniu;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

import org.apache.commons.codec.EncoderException;
import org.json.JSONException;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static secondriver.qiniu.utils.StringUtils.toUTF8;

import com.qiniu.api.auth.AuthException;
import com.qiniu.api.auth.digest.Mac;
import com.qiniu.api.config.Config;
import com.qiniu.api.io.IoApi;
import com.qiniu.api.io.PutExtra;
import com.qiniu.api.io.PutRet;
import com.qiniu.api.rs.GetPolicy;
import com.qiniu.api.rs.PutPolicy;
import com.qiniu.api.rs.URLUtils;

/**
 * 七牛云存储原始SDK使用示例
 * 
 * @author secondriver
 * 
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestQiniuSDK {

	public static Properties properties;

	public static String putFileKey = String
			.valueOf(System.currentTimeMillis());

	public String fileName = ClassLoader.getSystemResource(
			"qiniu-tools-test.jpg").getFile();

	@BeforeClass
	public static void start() {
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		URL url = loader.getResource("secondriver/qiniu/qiniu.properties");
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

	@AfterClass
	public static void end() {
		if (null != properties) {
			properties = null;
		}
	}

	@Test
	public void test1PutFile() throws AuthException, JSONException {
		Mac mac = new Mac(Config.ACCESS_KEY, Config.SECRET_KEY);
		PutPolicy putPolicy = new PutPolicy(properties.getProperty("bucket"));
		String uptoken = putPolicy.token(mac);
		PutExtra extra = new PutExtra();
		PutRet ret = IoApi.putFile(uptoken, putFileKey, fileName, extra);
		System.out.println("上传文件：");
		System.out.println(ret.toString());
	}

	@Test
	public void test2MakeBaseUrl() throws EncoderException, AuthException {
		GetPolicy getPolicy = new GetPolicy();
		Mac mac = new Mac(Config.ACCESS_KEY, Config.SECRET_KEY);
		// domain="secondriver-dev.qiniudn.com"
		String baseUrl = URLUtils.makeBaseUrl(properties.getProperty("domain"),
				toUTF8(putFileKey));
		String url = getPolicy.makeRequest(baseUrl, mac);
		System.out.println("请求上传的文件:");
		System.out.println(url);
	}
}
