package com.secondriver.qiniu;

import java.io.File;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import com.qiniu.api.io.PutRet;
import com.secondriver.qiniu.operator.GetSession;
import com.secondriver.qiniu.operator.PutSession;

/**
 * QiniuCloundSession对象来操作bucket和文件
 * 
 * @author secondriver
 * 
 */
public class TestQiniuCloudSession {

	public static String dir = "/常用开发图例";

	@Ignore
	@Test
	public void test6() {
		QiniuCloudSession qcs = QiniuCloudSession.build();
		Assert.assertNotNull(qcs);
	}

	@Ignore
	@Test
	public void test5() {
		QiniuCloudSession qcs = QiniuCloudSession.build();
		boolean result = true;
		for (int i = 0; i < 1000; i++) {
			result = qcs.equals(QiniuCloudSession.build());
			if (!result) {
				break;
			}
		}
		Assert.assertEquals(true, result);
	}

	@Ignore
	@Test
	public void test1() {
		QiniuCloudSession qcs = QiniuCloudSession.build();
		PutSession put = new PutSession(qcs);
		PutRet putRet = put.putFile(String.valueOf(System.currentTimeMillis()),
				dir + File.separator + "03.png");
		System.out.print(putRet.toString());
		Assert.assertNotNull(putRet);
	}

	@Test
	public void test2() {
		QiniuCloudSession qcs = QiniuCloudSession.build();
		GetSession session = new GetSession(qcs);
		String url = session.getPrivetFileUrl("1399965230092");
		System.out.println(url);
	}
}
