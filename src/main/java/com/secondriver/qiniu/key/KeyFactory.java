package com.secondriver.qiniu.key;

/**
 * key工程用来获取key
 * 
 * @author secondriver
 * 
 * @see 七牛云存储：http://www.qiniu.com/ 野马红尘：http://aiilive.blog.51cto.com/
 */
public class KeyFactory {

	public static String getKey(Key key) {
		return key.generateKey();
	}

	public static String getKey() {
		return new QiniuKey().generateKey();
	}

}
