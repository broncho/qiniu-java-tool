qiniu-java-tool
===============

####七牛云存储：http://www.qiniu.com/ SDK For Java 封装工具和使用示例####

####1.Maven项目添加依赖

	<repositories>
		<repository>
			<id>osc</id>
			<name>http://maven.oschina.net</name>
			<url>http://maven.oschina.net/content/repositories/thirdparty</url>
			<releases>
				<enabled>true</enabled>
			</releases>
			<snapshots>
				<enabled>false</enabled>
			</snapshots>
		</repository>
	</repositories>

	<dependencies>
		<dependency>
			<groupId>secondriver</groupId>
			<artifactId>qiniu-tools</artifactId>
			<version>1.0.0-ga</version>
		</dependency>
	</dependencies>

####2.七牛Java SDK封装对象`QiniuCloudSession`的基本使用方式：

	QiniuCloudSession qiniuCloudSession = QiniuCloudSession.build("qiniu.properties");

	String token = qiniuCloudSession.getUpToken();

这样就可以获取到上传文件的`token`字符串。






