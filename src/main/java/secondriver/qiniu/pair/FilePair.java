package secondriver.qiniu.pair;

import java.io.File;
import java.util.HashMap;

/**
 * FilePair:
 * 
 * 指上传至七牛云存储的文件集合,其中Map的key即是七牛云存储中的key,File即是文件对象
 * 
 * @author secondriver
 * 
 */
public class FilePair extends HashMap<String, File> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7826373094692605653L;
}
