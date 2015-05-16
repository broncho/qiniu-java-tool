package secondriver.qiniu.pair;

import com.qiniu.api.fop.ImageView;

/**
 * 
 * 用户生成指定格式的图片
 * 
 * @author secondriver
 * 
 */
public class ViewPair extends ImageView {

	public ViewPair(int model, int width, int height, int quality, String format) {
		
		this.mode = model;
		this.width = width;
		this.height = height;
		this.quality = quality;
		this.format = format;
	}

}
