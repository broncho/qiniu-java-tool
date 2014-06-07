package com.secondriver.qiniu.pair;

/**
 * KeyPair表示一组具有keyPair,其中srcKeyPair,destKeyPair用于bucket内管理文件
 * 
 * @author ZhangXiao
 * 
 * @see 七牛云存储：http://www.qiniu.com/  野马红尘：http://aiilive.blog.51cto.com/
 */
public class KeyPairs {

	/**
	 * @see com.qiniu.api.rs.EntryPath
	 */
	private KeyPair srcKeyPair;

	/**
	 * @see com.qiniu.api.rs.EntryPath
	 */
	private KeyPair destKeyPair;

	private KeyPairs() {
		super();
	}

	private KeyPairs(KeyPair srcKeyPair, KeyPair destKeyPair) {
		super();
		this.srcKeyPair = srcKeyPair;
		this.destKeyPair = destKeyPair;
	}

	public KeyPair getSrcKeyPair() {
		return srcKeyPair;
	}

	public void setSrcKeyPair(KeyPair srcKeyPair) {
		this.srcKeyPair = srcKeyPair;
	}

	public KeyPair getDestKeyPair() {
		return destKeyPair;
	}

	public void setDestKeyPair(KeyPair destKeyPair) {
		this.destKeyPair = destKeyPair;
	}

}
