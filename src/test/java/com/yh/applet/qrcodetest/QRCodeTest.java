package com.yh.applet.qrcodetest;

import org.junit.Test;

public class QRCodeTest {

	/**
	 * 生成二维码图片;放置在D盘根目录
	 */
	@Test
	public void createQRCodeTest() {
		String filePath = "D://";
		String photoName = "zxing.png";
		String content = "http://weixin.qq.com/r/moNieu7EoLPfraoZ99aI";
		QRCodeUtils.createQRCode(filePath, photoName, content);
		System.out.println("二维码生成了");
	}

	/**
	 * 给二维码图片添加logo
	 * 
	 * @param qrPic
	 * @param logoPic
	 */
	@Test
	public void addLogoTest() {
		String logoPath = "D://logo.jpg";
		String qRCodePath = "D://zxing.jpg";
		QRCodeUtils.addLogo(logoPath, qRCodePath);
		System.out.println("logo 二维码生成了");
	}

	/**
	 * 解析二维码图像得到内容
	 */
	@Test
	public void getContentTest () {
		// 解析的图像的路径
		String qRCodePath = "D://zxing.jpg";
		System.out.println(QRCodeUtils.getContentFromQRCode(qRCodePath));
	}
}
