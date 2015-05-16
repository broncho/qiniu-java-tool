package secondriver.qiniu.operator;

import static secondriver.qiniu.utils.WrapperUtils.wrapperEntryPath;
import static secondriver.qiniu.utils.WrapperUtils.wrapperEntryPathPair;

import java.util.List;

import secondriver.qiniu.QiniuCloudSession;
import secondriver.qiniu.pair.KeyPairs;

import com.qiniu.api.net.CallRet;
import com.qiniu.api.rs.Entry;
import com.qiniu.api.rs.EntryPath;
import com.qiniu.api.rsf.ListItem;

/**
 * 
 * 管理Bucket文件对象
 * 
 * @author secondriver
 * 
 */
public class ManageSession {

	private QiniuCloudSession qcs;

	public ManageSession(QiniuCloudSession qcs) {
		this.qcs = qcs;
	}

	/**
	 * 获取指定key的文件属性信息
	 * 
	 * @param key
	 * @return
	 */
	public Entry stat(String key) {
		return this.qcs.getRsClient().stat(this.qcs.getBucket(), key);
	}

	/**
	 * 获取指定的一组key的文件集合属性信息
	 * 
	 * @param keys
	 * @return
	 */
	public List<Entry> stat(String[] keys) {
		String bucket = this.qcs.getBucket();
		List<EntryPath> entryPathList = wrapperEntryPath(bucket, keys);
		return this.qcs.getRsClient().batchStat(entryPathList).results;
	}

	/**
	 * 同一个bucket中复制文件
	 * 
	 * @param srcKey
	 *            源文件的key
	 * @param destKey
	 *            目的文件的key
	 * @return
	 */
	public CallRet copy(String srcKey, String destKey) {
		if (null == srcKey || null == destKey) {
			return null;
		} else if (srcKey.equals(destKey)) {
			return null;
		} else {
			return this.qcs.getRsClient().copy(this.qcs.getBucket(), srcKey,
					this.qcs.getBucket(), destKey);
		}
	}

	/**
	 * 跨bucket复制文件
	 * 
	 * @param srcKey
	 *            源文件的key
	 * @param destBucket
	 *            目的文件的bucket(需要注意的是操作目的bucket需要权限)
	 * @param destKey
	 *            目的文件的key
	 * @return 返回操作结果
	 */
	public CallRet copy(String srcKey, String destBucket, String destKey) {
		return this.qcs.getRsClient().copy(this.qcs.getBucket(), srcKey,
				destBucket, destKey);
	}

	/**
	 * 批量复制文件
	 * 
	 * @param keyPairsList
	 *            复制文件的srcPair和destPair集合
	 * @return 返回每次操作的结果集合
	 */
	public List<CallRet> copy(List<KeyPairs> keyPairsList) {
		return this.qcs.getRsClient().batchCopy(
				wrapperEntryPathPair(keyPairsList)).results;
	}

	/**
	 * 删除指定key的文件
	 * 
	 * @param key
	 * @return
	 */
	public CallRet delete(String key) {
		return this.qcs.getRsClient().delete(this.qcs.getBucket(), key);
	}

	/**
	 * 批量删除指定集合key的文件
	 * 
	 * @param keys
	 * @return
	 */
	public List<CallRet> delete(String[] keys) {
		String bucket = this.qcs.getBucket();
		List<EntryPath> entryPathList = wrapperEntryPath(bucket, keys);
		return this.qcs.getRsClient().batchDelete(entryPathList).results;
	}

	/**
	 * 同一个bucket中移动文件
	 * 
	 * @param srcKey
	 * @param destKey
	 * @return
	 */
	public CallRet move(String srcKey, String destKey) {
		String bucket = this.qcs.getBucket();
		if (null != srcKey && null != destKey && !srcKey.equals(destKey)) {
			return this.qcs.getRsClient().move(bucket, srcKey, bucket, destKey);
		}
		return null;
	}

	/**
	 * 不同一个bucket中移动文件
	 * 
	 * @param srcKey
	 * @param destBucket
	 *            目的文件的bucket(需要注意的是操作目的bucket需要权限)
	 * @param destKey
	 * @return
	 */
	public CallRet move(String srcKey, String destBucket, String destKey) {
		String srcBucket = this.qcs.getBucket();
		if (null != srcKey && null != destKey && !srcBucket.equals(destBucket)
				&& !srcKey.equals(destKey)) {
			return this.qcs.getRsClient().move(srcBucket, srcKey, destBucket,
					destKey);
		}
		return null;
	}

	/**
	 * 批量移动文件
	 * 
	 * @param keyPairsList
	 *            移动文件的srcPair和destPair集合
	 * @return
	 */
	public List<CallRet> move(List<KeyPairs> keyPairsList) {
		return this.qcs.getRsClient().batchMove(
				wrapperEntryPathPair(keyPairsList)).results;
	}

	public List<ListItem> listFile(String prefix, String marker, int limit) {
		return this.qcs.getRsfClient().listPrifix(this.qcs.getBucket(), prefix,
				marker, limit).results;
	}

}
