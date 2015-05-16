package secondriver.qiniu.key;

import static secondriver.qiniu.utils.StringUtils.getRadmonNumberString;
import static secondriver.qiniu.utils.StringUtils.simpleTimeStamp;

/**
 * 默认生成key策略实现
 * 
 * @author secondriver
 * 
 */
public class QiniuKey implements Key {

	@Override
	public String generateKey() {
		return simpleTimeStamp() + getRadmonNumberString(4);
	}
}
