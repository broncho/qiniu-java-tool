package secondriver.qiniu;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import secondriver.qiniu.operator.GetSession;
import secondriver.qiniu.operator.PutSession;

import com.qiniu.api.io.PutRet;

/**
 * QiniuCloundSession对象来操作bucket和文件
 * 
 * @author secondriver
 * 
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestQiniuCloudSession {

	public static String putFileKey = String
			.valueOf(System.currentTimeMillis());

	public String fileName = ClassLoader.getSystemResource(
			"qiniu-tools-test.jpg").getFile();

	@Test
	public void test1QiniuCloundSessionStatus() {
		QiniuCloudSession qcs = QiniuCloudSession.build();
		Assert.assertNotNull(qcs);
	}

	@Test
	public void test2QiniuCloundSessionPutFile() {
		QiniuCloudSession qcs = QiniuCloudSession.build();
		PutSession put = new PutSession(qcs);
		PutRet putRet = put.putFile(putFileKey, fileName);
		System.out.println("上传文件:");
		System.out.print(putRet.toString());
		Assert.assertNotNull(putRet);
	}

	@Test
	public void test3QiniuCloundSessionRequestFileUrl() {
		QiniuCloudSession qcs = QiniuCloudSession.build();
		GetSession session = new GetSession(qcs);
		String url = session.getPrivetFileUrl(putFileKey);
		System.out.println("请求上传文件:");
		System.out.println(url);
	}
}
