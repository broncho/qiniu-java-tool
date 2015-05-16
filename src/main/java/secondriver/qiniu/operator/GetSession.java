package secondriver.qiniu.operator;

import static secondriver.qiniu.utils.StringUtils.toUTF8;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.EncoderException;

import secondriver.qiniu.QiniuCloudSession;
import secondriver.qiniu.utils.Constant;
import secondriver.qiniu.utils.HttpUtils;

import com.qiniu.api.auth.AuthException;
import com.qiniu.api.rs.URLUtils;

/**
 * 
 * Get请求处理对象
 * 
 * @author secondriver
 * 
 */
public class GetSession {

	private QiniuCloudSession qcs;

	public GetSession(QiniuCloudSession qcs) {
		this.qcs = qcs;
	}

	/**
	 * 获取公开的指定key的文件URL
	 * 
	 * @param key
	 * @return
	 */
	public String getPublicFileUrl(String key) {
		String url = "";
		try {
			url = URLUtils.makeBaseUrl(this.qcs.getDomain(), toUTF8(key));
		} catch (EncoderException e) {
			e.printStackTrace();
			return "";
		}
		return url;
	}

	/**
	 * 获取公开的指定一組的key的文件URL組
	 * 
	 * @param keys
	 * @return
	 */
	public Map<String, String> getPublicFileUrl(String[] keys) {
		Map<String, String> result = new HashMap<String, String>();
		if (null != keys && 0 == keys.length) {
			for (int i = 0, length = keys.length; i < length; i++) {
				result.put(keys[i], getPrivetFileUrl(keys[i]));
			}
		}
		return result;
	}

	/**
	 * 获取私有的指定key的文件URL
	 * 
	 * @param key
	 * @return
	 */
	public String getPrivetFileUrl(String key) {
		String url = "";
		try {
			String baseUrl = URLUtils.makeBaseUrl(this.qcs.getDomain(),
					toUTF8(key));
			url = this.qcs.getGetPolicy().makeRequest(baseUrl,
					this.qcs.getMac());
		} catch (EncoderException e) {
			e.printStackTrace();
			return url;
		} catch (AuthException e) {
			e.printStackTrace();
			return url;
		}
		return url;
	}

	/**
	 * 获取私有的指定一組的key的文件URL組
	 * 
	 * @param keys
	 * @return
	 */
	public Map<String, String> getPrivateFileUrl(String[] keys) {
		Map<String, String> result = new HashMap<String, String>();
		if (null != keys && 0 != keys.length) {
			for (int i = 0, length = keys.length; i < length; i++) {
				result.put(keys[i], getPrivetFileUrl(keys[i]));
			}
		}
		return result;
	}

	/**
	 * 获取私有的指定key和filename的下载URL(建议：如果下载URL用于非浏览器操作，filename不用添加扩展名)
	 * 
	 * @param key
	 * @param filename
	 * @return
	 */
	public String getPrivateDownFileUrl(String key, String filename) {
		String url = getPrivetFileUrl(key);
		if (-1 == filename.lastIndexOf(".")) {
			filename = filename + HttpUtils.getExtension(url);
		}
		return url + Constant.DOWNLOAD + filename;
	}

	/**
	 * 获取公有的指定key和filename的下载URL(建议：如果下载URL用于非浏览器操作，filename可以不用添加扩展名)
	 * 
	 * @param key
	 * @param filename
	 * @return
	 */
	public String getPublicDownfileUrl(String key, String filename) {
		String url = getPublicFileUrl(key);
		if (-1 == filename.lastIndexOf(".")) {
			filename = filename + HttpUtils.getExtension(url);
		}
		return url + Constant.DOWNLOAD + filename;
	}
}
