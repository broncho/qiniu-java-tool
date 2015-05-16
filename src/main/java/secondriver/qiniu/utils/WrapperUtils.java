package secondriver.qiniu.utils;

import java.util.ArrayList;
import java.util.List;

import secondriver.qiniu.pair.KeyPair;
import secondriver.qiniu.pair.KeyPairs;

import com.qiniu.api.rs.EntryPath;
import com.qiniu.api.rs.EntryPathPair;

/**
 * 
 * 包装类工具
 * 
 * @author secondriver
 * 
 */
public class WrapperUtils {

	public static List<EntryPath> wrapperEntryPath(String bucket, String[] keys) {
		List<EntryPath> entryPathList = new ArrayList<EntryPath>();
		for (int i = 0, length = keys.length; i < length; i++) {
			EntryPath ep = new EntryPath();
			ep.bucket = bucket;
			ep.key = keys[i];
			entryPathList.add(ep);
		}
		return entryPathList;

	}

	public static List<EntryPath> wrapperEntryPath(List<KeyPair> keyPairList) {
		List<EntryPath> entryPathList = new ArrayList<EntryPath>();
		for (int i = 0, s = keyPairList.size(); i < s; i++) {
			KeyPair kp = keyPairList.get(i);
			EntryPath ep = new EntryPath();
			ep.bucket = kp.getBucket();
			ep.key = kp.getKey();
			entryPathList.add(ep);
		}
		return entryPathList;
	}

	public static List<EntryPathPair> wrapperEntryPathPair(
			List<KeyPairs> keyPairsList) {
		List<EntryPathPair> entryPathPairList = new ArrayList<EntryPathPair>();
		for (int i = 0, s = keyPairsList.size(); i < s; i++) {
			KeyPairs kp = keyPairsList.get(i);

			KeyPair src = kp.getSrcKeyPair();
			EntryPath srcEp = new EntryPath();
			srcEp.bucket = src.getBucket();
			srcEp.key = src.getKey();

			KeyPair dest = kp.getDestKeyPair();
			EntryPath destEp = new EntryPath();
			destEp.bucket = dest.getBucket();
			destEp.key = dest.getKey();

			EntryPathPair epp = new EntryPathPair();
			epp.src = srcEp;
			epp.dest = destEp;
			entryPathPairList.add(epp);
		}
		return entryPathPairList;
	}
}
