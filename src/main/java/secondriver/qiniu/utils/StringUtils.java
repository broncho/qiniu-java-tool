package secondriver.qiniu.utils;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * 字符串工具类
 * 
 * @author secondriver
 * 
 */
public class StringUtils {

	/**
	 * 获取指定长度的随机数字字符串
	 * 
	 * @param length
	 *            长度
	 * @return 指定长度的随着数字字符串
	 */
	public static String getRadmonNumberString(int length) {
		Random random = new Random();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < length; i++) {
			sb.append(String.valueOf(random.nextInt(10)));
		}
		return sb.toString();
	}

	/**
	 * 生成一个简单的当前时间的时间戳
	 * 
	 * @return 返回格式为：yyMMddHHmmss的当前时间的时间戳
	 */
	public static String simpleTimeStamp() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmss");
		return sdf.format(new Date());
	}

	/**
	 * 字符串转化为UTF-8编码
	 * 
	 * @param str
	 *            指定字符串
	 * @return 返回编码结果,如果str==null或者str==""将返回""
	 */
	public static String toUTF8(String str) {
		if (null == str || "".equals(str)) {
			return "";
		} else {
			try {
				return new String(str.getBytes("ISO8859-1"), "UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return "";
	}
}
