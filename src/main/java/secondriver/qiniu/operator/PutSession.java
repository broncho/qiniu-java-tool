package secondriver.qiniu.operator;

import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import secondriver.qiniu.QiniuCloudSession;
import secondriver.qiniu.pair.FilePair;

import com.qiniu.api.io.IoApi;
import com.qiniu.api.io.PutExtra;
import com.qiniu.api.io.PutRet;

/**
 * PUT请求处理对象
 * 
 * @author secondriver
 * 
 */
public class PutSession {

	private QiniuCloudSession qcs;

	public PutSession(QiniuCloudSession qcs) {
		this.qcs = qcs;
	}

	/**
	 * 上传指定key和本地文件名的文件
	 * 
	 * @param key
	 * @param fileName
	 * @return
	 */
	public PutRet putFile(String key, String fileName) {
		String uptoken = this.qcs.getUpToken();
		PutExtra extra = new PutExtra();
		return IoApi.putFile(uptoken, key, fileName, extra);
	}

	/**
	 * 上传指定key和文件对象的文件
	 * 
	 * @param key
	 * @param file
	 * @return
	 */
	public PutRet putFile(String key, File file) {
		String fileName = file.getAbsolutePath();
		return putFile(key, fileName);
	}

	/**
	 * 上传指定key和流对象对象的文件
	 * @param key
	 * @param reader
	 * @return
	 */
	public PutRet putFile(String key, InputStream reader) {
		String uptoken = this.qcs.getUpToken();
		PutExtra extra = new PutExtra();
		return IoApi.Put(uptoken, key, reader, extra);
	}

	/**
	 * 上传一组文件
	 * @param filePair
	 * @return 返回对应的上传结果,结果Map的key对应文件的key
	 */
	public Map<String, PutRet> putFile(FilePair filePair) {
		Map<String, PutRet> putRetMap = new HashMap<String, PutRet>();
		if (null != filePair) {
			Set<Entry<String, File>> set = filePair.entrySet();
			for (Iterator<Entry<String, File>> iter = set.iterator(); iter
					.hasNext();) {
				Entry<String, File> entry = iter.next();
				String key = entry.getKey();
				PutRet putRet = putFile(key, entry.getValue());
				putRetMap.put(key, putRet);
			}
		}
		return putRetMap;
	}
}
