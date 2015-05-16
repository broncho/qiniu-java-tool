package secondriver.qiniu.pair;

/**
 * 
 * 全局唯一命名的bucket与key组成KeyPair
 * 
 * 一个bucket+一个key=一个文件对象
 * 
 * @author secondriver
 * 
 */
public class KeyPair {

	private String bucket;

	private String key;

	private KeyPair() {
		super();
	}

	private KeyPair(String bucket, String key) {
		super();
		this.bucket = bucket;
		this.key = key;
	}

	public String getBucket() {
		return bucket;
	}

	public void setBucket(String bucket) {
		this.bucket = bucket;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

}
