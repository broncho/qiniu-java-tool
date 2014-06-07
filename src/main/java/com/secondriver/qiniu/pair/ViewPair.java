package com.secondriver.qiniu.pair;

import com.qiniu.api.fop.ImageView;

/**
 * 
 * 用户生成指定格式的图片
 * 
 * @author ZhangXiao
 * 
 * @see 七牛云存储：http://www.qiniu.com/  野马红尘：http://aiilive.blog.51cto.com/
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
