package com.secondriver.qiniu.operator;

import com.qiniu.api.auth.AuthException;
import com.qiniu.api.fop.ExifRet;
import com.qiniu.api.fop.ImageExif;
import com.qiniu.api.fop.ImageInfo;
import com.qiniu.api.fop.ImageInfoRet;
import com.qiniu.api.net.CallRet;
import com.secondriver.qiniu.QiniuCloudSession;
import com.secondriver.qiniu.pair.ViewPair;

/**
 * 图片处理
 * 
 * @author ZhangXiao
 * 
 * @see 七牛云存储：http://www.qiniu.com/ 野马红尘：http://aiilive.blog.51cto.com/
 */
public class ImageSession {

	private QiniuCloudSession qcs;

	public ImageSession(QiniuCloudSession qcs) {
		this.qcs = qcs;
	}

	/**
	 * 获取公开的指定key的图片对象
	 * @param key
	 * @return
	 */
	public ImageInfoRet getPublicImageInfo(String key) {
		return ImageInfo.call(this.qcs.getBucket() + "/" + key);
	}

	/**
	 * 获取私有的指定key的图片对象
	 * @param key
	 * @return
	 */
	public ImageInfoRet getPrivetImageInfo(String key) {
		try {
			return ImageInfo.call(this.qcs.getBucket() + "/" + key,
					this.qcs.getMac());
		} catch (AuthException e) {
			e.printStackTrace();
		}
		return null;
	}

	
	public ExifRet getPublicImageExif(String key) {
		return ImageExif.call(this.qcs.getBucket() + "/" + key);
	}

	public ExifRet getPrivateIamgeExif(String key) {
		try {
			return ImageExif.call(this.qcs.getBucket() + "/" + key,
					this.qcs.getMac());
		} catch (AuthException e) {
			e.printStackTrace();
		}
		return null;
	}

	public CallRet getPublicPreview(ViewPair viewPair, String key) {
		return viewPair.call(this.qcs.getBucket() + "/" + key);
	}

	public CallRet getPrivatePreview(ViewPair viewPair, String key) {
		try {
			return viewPair.call(this.qcs.getBucket() + "/" + key,
					this.qcs.getMac());
		} catch (AuthException e) {
			e.printStackTrace();
		}
		return null;
	}
}
