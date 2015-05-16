package secondriver.qiniu;

import static secondriver.qiniu.utils.Constant.ACCESS_KEY;
import static secondriver.qiniu.utils.Constant.BUCKET;
import static secondriver.qiniu.utils.Constant.DEFAULT_CONFIG;
import static secondriver.qiniu.utils.Constant.DOMAIN;
import static secondriver.qiniu.utils.Constant.SECRET_KEY;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

import org.json.JSONException;

import com.qiniu.api.auth.AuthException;
import com.qiniu.api.auth.digest.Mac;
import com.qiniu.api.rs.GetPolicy;
import com.qiniu.api.rs.PutPolicy;
import com.qiniu.api.rs.RSClient;
import com.qiniu.api.rsf.RSFClient;

/**
 * 七牛云存储会话管理对象
 * 
 * @author secondriver
 * 
 * @website 七牛云存储：http://www.qiniu.com/
 * @blog 野马红尘：http://aiilive.blog.51cto.com/
 */
public class QiniuCloudSession {

	private String accessKey;

	private String secretKey;

	private String bucket;

	private String domain;

	private Mac mac;

	private PutPolicy putPolicy;

	private GetPolicy getPolicy;

	private RSClient rsClient;

	private RSFClient rsfClient;

	private static QiniuCloudSession qiniuCloudSession;

	private QiniuCloudSession() {

	}

	private QiniuCloudSession(String accessKey, String secretKey,
			String bucket, String domain) {
		this.accessKey = accessKey;
		this.secretKey = secretKey;
		this.bucket = bucket;
		this.domain = domain;
		init();
	}

	private QiniuCloudSession init() {
		this.mac = new Mac(this.accessKey, this.secretKey);
		this.putPolicy = new PutPolicy(this.bucket);
		this.getPolicy = new GetPolicy();
		this.rsClient = new RSClient(this.mac);
		this.rsfClient = new RSFClient(this.mac);
		return this;
	}

	public static QiniuCloudSession build() {
		return build(DEFAULT_CONFIG);
	}

	public static QiniuCloudSession build(String filepath) {
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		URL url = loader.getResource(filepath);
		InputStream in = null;
		Properties properties = new Properties();
		try {
			in = url.openStream();
			properties.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (null != in) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		qiniuCloudSession = build(properties);
		return qiniuCloudSession;
	}

	public synchronized static QiniuCloudSession build(Properties properties) {
		if (null == properties) {
			throw new IllegalArgumentException(
					"Qiniu configuration profile object can't  be null."
							+ " Please properties object contains key have "
							+ ACCESS_KEY + "|" + SECRET_KEY + "|" + BUCKET
							+ "|" + DOMAIN
							+ " Notice the key is case sensitive.");
		}
		if (null == qiniuCloudSession) {
			qiniuCloudSession = new QiniuCloudSession(
					properties.getProperty(ACCESS_KEY),
					properties.getProperty(SECRET_KEY),
					properties.getProperty(BUCKET),
					properties.getProperty(DOMAIN));
		}
		return qiniuCloudSession;
	}

	public synchronized static QiniuCloudSession build(String accessKey,
			String secretKey, String bucket, String domain) {
		if (null == qiniuCloudSession) {
			qiniuCloudSession = new QiniuCloudSession(accessKey, secretKey,
					bucket, domain);
		}
		return qiniuCloudSession;
	}

	public QiniuCloudSession reloadBucket(String bucket) {
		synchronized (bucket) {
			this.bucket = bucket;
			return init();
		}
	}

	public QiniuCloudSession reloadDomain(String domain) {
		synchronized (domain) {
			this.domain = domain;
			return init();
		}
	}

	public void closeSession() {
		if (null == qiniuCloudSession) {
			qiniuCloudSession = null;
		}
	}

	public String getUpToken() {
		String upToKen = "";
		try {
			upToKen = this.putPolicy.token(this.mac);
		} catch (AuthException e) {
			e.printStackTrace();
			return upToKen;
		} catch (JSONException e) {
			e.printStackTrace();
			return upToKen;
		}
		return upToKen;
	}

	public Mac getMac() {
		return mac;
	}

	public String getBucket() {
		return bucket;
	}

	public String getDomain() {
		return domain;
	}

	public GetPolicy getGetPolicy() {
		return getPolicy;
	}

	public PutPolicy getPutsPolicy() {
		return putPolicy;
	}

	public RSClient getRsClient() {
		return rsClient;
	}

	public RSFClient getRsfClient() {
		return rsfClient;
	}

	public PutPolicy newPutPolicy() {
		return new PutPolicy(this.getBucket());
	}

	public PutPolicy newPutPolicy(String key) {
		return new PutPolicy(this.getBucket() + ":" + key);
	}

	public GetPolicy newGetPolicy() {
		return new GetPolicy();
	}

	public RSClient newRSClient() {
		return new RSClient(this.mac);
	}

	public RSFClient newRSFClient() {
		return new RSFClient(this.mac);
	}
}
