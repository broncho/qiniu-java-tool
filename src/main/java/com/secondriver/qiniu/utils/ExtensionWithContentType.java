package com.secondriver.qiniu.utils;

/**
 * 文件扩展名与内容类型映射表
 * 
 * @author ZhangXiao
 * 
 * @see 七牛云存储：http://www.qiniu.com/ 野马红尘：http://aiilive.blog.51cto.com/
 */
public final class ExtensionWithContentType {

	/**
	 * 扩展名
	 * 
	 * @see http://tool.oschina.net/commons
	 */
	private static final String[] EXTENSION = new String[] { ".*", ".tif",
			".001", ".301", ".323", ".906", ".907", ".a11", ".acp", ".ai",
			".aif", ".aifc", ".aiff", ".anv", ".asa", ".asf", ".asp", ".asx",
			".au", ".avi", ".awf", ".biz", ".bmp", ".bot", ".c4t", ".c90",
			".cal", ".cat", ".cdf", ".cdr", ".cel", ".cer", ".cg4", ".cgm",
			".cit", ".class", ".cml", ".cmp", ".cmx", ".cot", ".crl", ".crt",
			".csi", ".css", ".cut", ".dbf", ".dbm", ".dbx", ".dcd", ".dcx",
			".der", ".dgn", ".dib", ".dll", ".doc", ".dot", ".drw", ".dtd",
			".dwf", ".dwf", ".dwg", ".dxb", ".dxf", ".edn", ".emf", ".eml",
			".ent", ".epi", ".eps", ".eps", ".etd", ".exe", ".fax", ".fdf",
			".fif", ".fo", ".frm", ".g4", ".gbr", ".", ".gif", ".gl2", ".gp4",
			".hgl", ".hmr", ".hpg", ".hpl", ".hqx", ".hrf", ".hta", ".htc",
			".htm", ".html", ".htt", ".htx", ".icb", ".ico", ".ico", ".iff",
			".ig4", ".igs", ".iii", ".img", ".ins", ".isp", ".IVF", ".java",
			".jfif", ".jpe", ".jpe", ".jpeg", ".jpg", ".jpg", ".js", ".jsp",
			".la1", ".lar", ".latex", ".lavs", ".lbm", ".lmsff", ".ls", ".ltr",
			".m1v", ".m2v", ".m3u", ".m4e", ".mac", ".man", ".math", ".mdb",
			".mdb", ".mfp", ".mht", ".mhtml", ".mi", ".mid", ".midi", ".mil",
			".mml", ".mnd", ".mns", ".mocha", ".movie", ".mp1", ".mp2",
			".mp2v", ".mp3", ".mp4", ".mpa", ".mpd", ".mpe", ".mpeg", ".mpg",
			".mpga", ".mpp", ".mps", ".mpt", ".mpv", ".mpv2", ".mpw", ".mpx",
			".mtx", ".mxp", ".net", ".nrf", ".nws", ".odc", ".out", ".p10",
			".p12", ".p7b", ".p7c", ".p7m", ".p7r", ".p7s", ".pc5", ".pci",
			".pcl", ".pcx", ".pdf", ".pdf", ".pdx", ".pfx", ".pgl", ".pic",
			".pko", ".pl", ".plg", ".pls", ".plt", ".png", ".png", ".pot",
			".ppa", ".ppm", ".pps", ".ppt", ".ppt", ".pr", ".prf", ".prn",
			".prt", ".ps", ".ps", ".ptn", ".pwz", ".r3t", ".ra", ".ram",
			".ras", ".rat", ".rdf", ".rec", ".red", ".rgb", ".rjs", ".rjt",
			".rlc", ".rle", ".rm", ".rmf", ".rmi", ".rmj", ".rmm", ".rmp",
			".rms", ".rmvb", ".rmx", ".rnx", ".rp", ".rpm", ".rsml", ".rt",
			".rtf", ".rtf", ".rv", ".sam", ".sat", ".sdp", ".sdw", ".sit",
			".slb", ".sld", ".slk", ".smi", ".smil", ".smk", ".snd", ".sol",
			".sor", ".spc", ".spl", ".spp", ".ssm", ".sst", ".stl", ".stm",
			".sty", ".svg", ".swf", ".tdf", ".tg4", ".tga", ".tif", ".tif",
			".tiff", ".tld", ".top", ".torrent", ".tsd", ".txt", ".uin",
			".uls", ".vcf", ".vda", ".vdx", ".vml", ".vpg", ".vsd", ".vsd",
			".vss", ".vst", ".vst", ".vsw", ".vsx", ".vtx", ".vxml", ".wav",
			".wax", ".wb1", ".wb2", ".wb3", ".wbmp", ".wiz", ".wk3", ".wk4",
			".wkq", ".wks", ".wm", ".wma", ".wmd", ".wmf", ".wml", ".wmv",
			".wmx", ".wmz", ".wp6", ".wpd", ".wpg", ".wpl", ".wq1", ".wr1",
			".wri", ".wrk", ".ws", ".ws2", ".wsc", ".wsdl", ".wvx", ".xdp",
			".xdr", ".xfd", ".xfdf", ".xhtml", ".xls", ".xls", ".xlw", ".xml",
			".xpl", ".xq", ".xql", ".xquery", ".xsd", ".xsl", ".xslt", ".xwd",
			".x_b", ".sis", ".sisx", ".x_t", ".ipa", ".apk", ".xap" };

	/**
	 * 内容类型
	 * 
	 * @see http://tool.oschina.net/commons
	 */
	private static final String[] CONTENTTYPE = new String[] {
			"application/octet-stream", "image/tiff", "application/x-001",
			"application/x-301", "text/h323", "application/x-906",
			"drawing/907", "application/x-a11", "audio/x-mei-aac",
			"application/postscript", "audio/aiff", "audio/aiff", "audio/aiff",
			"application/x-anv", "text/asa", "video/x-ms-asf", "text/asp",
			"video/x-ms-asf", "audio/basic", "video/avi",
			"application/vnd.adobe.workflow", "text/xml", "application/x-bmp",
			"application/x-bot", "application/x-c4t", "application/x-c90",
			"application/x-cals", "application/vnd.ms-pki.seccat",
			"application/x-netcdf", "application/x-cdr", "application/x-cel",
			"application/x-x509-ca-cert", "application/x-g4",
			"application/x-cgm", "application/x-cit", "java/*", "text/xml",
			"application/x-cmp", "application/x-cmx", "application/x-cot",
			"application/pkix-crl", "application/x-x509-ca-cert",
			"application/x-csi", "text/css", "application/x-cut",
			"application/x-dbf", "application/x-dbm", "application/x-dbx",
			"text/xml", "application/x-dcx", "application/x-x509-ca-cert",
			"application/x-dgn", "application/x-dib",
			"application/x-msdownload", "application/msword",
			"application/msword", "application/x-drw", "text/xml",
			"Model/vnd.dwf", "application/x-dwf", "application/x-dwg",
			"application/x-dxb", "application/x-dxf",
			"application/vnd.adobe.edn", "application/x-emf", "message/rfc822",
			"text/xml", "application/x-epi", "application/x-ps",
			"application/postscript", "application/x-ebx",
			"application/x-msdownload", "image/fax", "application/vnd.fdf",
			"application/fractals", "text/xml", "application/x-frm",
			"application/x-g4", "application/x-gbr", "application/x-",
			"image/gif", "application/x-gl2", "application/x-gp4",
			"application/x-hgl", "application/x-hmr", "application/x-hpgl",
			"application/x-hpl", "application/mac-binhex40",
			"application/x-hrf", "application/hta", "text/x-component",
			"text/html", "text/html", "text/webviewhtml", "text/html",
			"application/x-icb", "image/x-icon", "application/x-ico",
			"application/x-iff", "application/x-g4", "application/x-igs",
			"application/x-iphone", "application/x-img",
			"application/x-internet-signup", "application/x-internet-signup",
			"video/x-ivf", "java/*", "image/jpeg", "image/jpeg",
			"application/x-jpe", "image/jpeg", "image/jpeg",
			"application/x-jpg", "application/x-javascript", "text/html",
			"audio/x-liquid-file", "application/x-laplayer-reg",
			"application/x-latex", "audio/x-liquid-secure",
			"application/x-lbm", "audio/x-la-lms", "application/x-javascript",
			"application/x-ltr", "video/x-mpeg", "video/x-mpeg",
			"audio/mpegurl", "video/mpeg4", "application/x-mac",
			"application/x-troff-man", "text/xml", "application/msaccess",
			"application/x-mdb", "application/x-shockwave-flash",
			"message/rfc822", "message/rfc822", "application/x-mi",
			"audio/mid", "audio/mid", "application/x-mil", "text/xml",
			"audio/x-musicnet-download", "audio/x-musicnet-stream",
			"application/x-javascript", "video/x-sgi-movie", "audio/mp1",
			"audio/mp2", "video/mpeg", "audio/mp3", "video/mpeg4",
			"video/x-mpg", "application/vnd.ms-project", "video/x-mpeg",
			"video/mpg", "video/mpg", "audio/rn-mpeg",
			"application/vnd.ms-project", "video/x-mpeg",
			"application/vnd.ms-project", "video/mpg", "video/mpeg",
			"application/vnd.ms-project", "application/vnd.ms-project",
			"text/xml", "application/x-mmxp", "image/pnetvue",
			"application/x-nrf", "message/rfc822", "text/x-ms-odc",
			"application/x-out", "application/pkcs10", "application/x-pkcs12",
			"application/x-pkcs7-certificates", "application/pkcs7-mime",
			"application/pkcs7-mime", "application/x-pkcs7-certreqresp",
			"application/pkcs7-signature", "application/x-pc5",
			"application/x-pci", "application/x-pcl", "application/x-pcx",
			"application/pdf", "application/pdf", "application/vnd.adobe.pdx",
			"application/x-pkcs12", "application/x-pgl", "application/x-pic",
			"application/vnd.ms-pki.pko", "application/x-perl", "text/html",
			"audio/scpls", "application/x-plt", "image/png",
			"application/x-png", "application/vnd.ms-powerpoint",
			"application/vnd.ms-powerpoint", "application/x-ppm",
			"application/vnd.ms-powerpoint", "application/vnd.ms-powerpoint",
			"application/x-ppt", "application/x-pr", "application/pics-rules",
			"application/x-prn", "application/x-prt", "application/x-ps",
			"application/postscript", "application/x-ptn",
			"application/vnd.ms-powerpoint", "text/vnd.rn-realtext3d",
			"audio/vnd.rn-realaudio", "audio/x-pn-realaudio",
			"application/x-ras", "application/rat-file", "text/xml",
			"application/vnd.rn-recording", "application/x-red",
			"application/x-rgb", "application/vnd.rn-realsystem-rjs",
			"application/vnd.rn-realsystem-rjt", "application/x-rlc",
			"application/x-rle", "application/vnd.rn-realmedia",
			"application/vnd.adobe.rmf", "audio/mid",
			"application/vnd.rn-realsystem-rmj", "audio/x-pn-realaudio",
			"application/vnd.rn-rn_music_package",
			"application/vnd.rn-realmedia-secure",
			"application/vnd.rn-realmedia-vbr",
			"application/vnd.rn-realsystem-rmx",
			"application/vnd.rn-realplayer", "image/vnd.rn-realpix",
			"audio/x-pn-realaudio-plugin", "application/vnd.rn-rsml",
			"text/vnd.rn-realtext", "application/msword", "application/x-rtf",
			"video/vnd.rn-realvideo", "application/x-sam", "application/x-sat",
			"application/sdp", "application/x-sdw", "application/x-stuffit",
			"application/x-slb", "application/x-sld", "drawing/x-slk",
			"application/smil", "application/smil", "application/x-smk",
			"audio/basic", "text/plain", "text/plain",
			"application/x-pkcs7-certificates", "application/futuresplash",
			"text/xml", "application/streamingmedia",
			"application/vnd.ms-pki.certstore", "application/vnd.ms-pki.stl",
			"text/html", "application/x-sty", "text/xml",
			"application/x-shockwave-flash", "application/x-tdf",
			"application/x-tg4", "application/x-tga", "image/tiff",
			"application/x-tif", "image/tiff", "text/xml", "drawing/x-top",
			"application/x-bittorrent", "text/xml", "text/plain",
			"application/x-icq", "text/iuls", "text/x-vcard",
			"application/x-vda", "application/vnd.visio", "text/xml",
			"application/x-vpeg005", "application/vnd.visio",
			"application/x-vsd", "application/vnd.visio",
			"application/vnd.visio", "application/x-vst",
			"application/vnd.visio", "application/vnd.visio",
			"application/vnd.visio", "text/xml", "audio/wav", "audio/x-ms-wax",
			"application/x-wb1", "application/x-wb2", "application/x-wb3",
			"image/vnd.wap.wbmp", "application/msword", "application/x-wk3",
			"application/x-wk4", "application/x-wkq", "application/x-wks",
			"video/x-ms-wm", "audio/x-ms-wma", "application/x-ms-wmd",
			"application/x-wmf", "text/vnd.wap.wml", "video/x-ms-wmv",
			"video/x-ms-wmx", "application/x-ms-wmz", "application/x-wp6",
			"application/x-wpd", "application/x-wpg", "application/vnd.ms-wpl",
			"application/x-wq1", "application/x-wr1", "application/x-wri",
			"application/x-wrk", "application/x-ws", "application/x-ws",
			"text/scriptlet", "text/xml", "video/x-ms-wvx",
			"application/vnd.adobe.xdp", "text/xml",
			"application/vnd.adobe.xfd", "application/vnd.adobe.xfdf",
			"text/html", "application/vnd.ms-excel", "application/x-xls",
			"application/x-xlw", "text/xml", "audio/scpls", "text/xml",
			"text/xml", "text/xml", "text/xml", "text/xml", "text/xml",
			"application/x-xwd", "application/x-x_b",
			"application/vnd.symbian.install",
			"application/vnd.symbian.install", "application/x-x_t",
			"application/vnd.iphone",
			"application/vnd.android.package-archive",
			"application/x-silverlight-app" };

	/**
	 * 根据内容类型获取扩展名
	 * 
	 * 如果找不到指定内容类型的扩展名则默认为：.*
	 * 
	 * @param contentType
	 * @return
	 */
	public static final String getExtension(String contentType) {
		String extension = EXTENSION[0];
		if (null == contentType || "".equals(contentType)) {
			return extension;
		}
		for (int i = 1, length = CONTENTTYPE.length; i < length; i++) {
			if (CONTENTTYPE[i].equals(contentType.toLowerCase())) {
				extension = EXTENSION[i];
				break;
			}
		}
		return extension;
	}

	/**
	 * 根据扩展名获取内容类型
	 * 
	 * 如果找不到指定扩展名的内容类型则默认为：application/octet-stream
	 * 
	 * @param extension
	 * @return
	 */
	public static final String getContentType(String extension) {
		String contentType = CONTENTTYPE[0];
		if (null == extension || "".equals(extension)) {
			return contentType;
		}
		for (int i = 1, length = EXTENSION.length; i < length; i++) {
			if (EXTENSION[i].equals(extension.toLowerCase())) {
				contentType = CONTENTTYPE[i];
				break;
			}
		}
		return contentType;
	}
}
