qiniu-java-tool
===============

###七牛云存储：http://www.qiniu.com/ SDK For Java 封装工具和使用示例###


七牛Java SDK封装对象`QiniuCloudSession`的基本使用方式：

	QiniuCloudSession qiniuCloudSession = QiniuCloudSession.build("qiniu.properties");

	String token = qiniuCloudSession.getUpToken();

这样就可以获取到上传文件的`token`字符串。




