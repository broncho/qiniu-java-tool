package secondriver.qiniu.key;

/**
 * key工程用来获取key
 * 
 * @author secondriver
 * 
 */
public class KeyFactory {

	public static String getKey(Key key) {
		return key.generateKey();
	}

	public static String getKey() {
		return new QiniuKey().generateKey();
	}

}
