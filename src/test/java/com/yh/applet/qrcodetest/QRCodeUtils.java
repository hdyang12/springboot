package com.yh.applet.qrcodetest;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.Binarizer;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.EncodeHintType;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class QRCodeUtils {
	
	/**
	 * 
	 * @param filePath		二维码图片存放位置
	 * @param photoName		二维码图片的名字
	 * @param content		二维码图片的内容
	 */
	public static void createQRCode(String filePath, String photoName, String content){
		createQRCode(filePath, photoName, content, 400, 400);
	}

	/**
	 * 
	 * @param filePath		二维码图片存放位置
	 * @param photoName		二维码图片的名字
	 * @param content		二维码图片的内容
	 * @param width			图像宽度
	 * @param height		图像高度
	 */
	private static void createQRCode(String filePath, String photoName, String content,
		int width, int height) {
		String format = photoName.substring(photoName.lastIndexOf('.') + 1);
		Map<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>();
		// 设置QR二维码的纠错级别（H为最高级别）具体级别信息
		hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
		// 内容所使用编码
		hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
		try {
			// 生成矩阵
			BitMatrix bitMatrix = new MultiFormatWriter().encode(content,
				BarcodeFormat.QR_CODE, width, height, hints);
			Path path = FileSystems.getDefault().getPath(filePath, photoName);
			// 输出图像
			MatrixToImageWriter.writeToPath(bitMatrix, format, path);
			MatrixToImageWriter.writeToPath(bitMatrix, format, path);
		} catch (WriterException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	/**
	 * 
	 * @param logoPath		logo图片
	 * @param qRCodePath	二维码图片
	 */
	public static void addLogo (String logoPath, String qRCodePath) {
		try {
			File logoFile = new File(logoPath);
			File qRCodeFile = new File(qRCodePath);	//需要加在zxing中间的login图片
			StringBuilder filePath = new StringBuilder(qRCodeFile.getPath());
			int index = filePath.lastIndexOf(File.separator);
			filePath.setCharAt(index + 1, filePath.substring(index + 1, index + 2).toUpperCase().charAt(0));
			filePath.insert(index + 1, "new");
			
			/**
			 * 读取二维码图片，并构建绘图对象
			 */
			BufferedImage image = ImageIO.read(qRCodeFile);
			Graphics2D g = image.createGraphics();

			/**
			 * 读取Logo图片
			 */
			BufferedImage logo = scale(logoFile, image.getWidth()/5, image
					.getHeight()/5, true);
			int widthLogo = logo.getWidth(), heightLogo = logo.getHeight();

			// 计算图片放置位置
			int x = (image.getWidth() - widthLogo) / 2;
			int y = (image.getHeight() - logo.getHeight()) / 2;

			// 开始绘制图片
			g.drawImage(logo, x, y, widthLogo, heightLogo, null);
			g.drawRoundRect(x, y, widthLogo, heightLogo, 15, 15);
			// 设置边框为5
			g.setStroke(new BasicStroke(5));
			// 设置边框颜色为白色
			g.setColor(Color.WHITE);
			g.drawRect(x, y, widthLogo, heightLogo);

			g.dispose();

			ImageIO.write(image, "jpeg", new File(filePath.toString()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String getContentFromQRCode(String qRCodePath) {
		BufferedImage image;
		StringBuilder content = new StringBuilder();
		try {
			image = ImageIO.read(new File(qRCodePath));
			LuminanceSource source = new BufferedImageLuminanceSource(image);
			Binarizer binarizer = new HybridBinarizer(source);
			BinaryBitmap binaryBitmap = new BinaryBitmap(binarizer);
			Map<DecodeHintType, Object> hints = new HashMap<DecodeHintType, Object>();
			hints.put(DecodeHintType.CHARACTER_SET, "UTF-8");
			Result result = new MultiFormatReader().decode(binaryBitmap, hints);// 对图像进行解码
			content.append("解析结果 = " + result.toString()).append("\r");
			content.append("二维码格式类型 = " + result.getBarcodeFormat()).append("\r");
			content.append("二维码文本内容 = " + result.getText()).append("\r");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NotFoundException e) {
			e.printStackTrace();
		}
		return content.toString();
	}
	
	/**
	 * 把传入的原始图像按高度和宽度进行缩放，生成符合要求的图标
	 * 
	 * @param srcImageFile
	 *            源文件地址
	 * @param height
	 *            目标高度
	 * @param width
	 *            目标宽度
	 * @param hasFiller
	 *            比例不对时是否需要补白：true为补白; false为不补白;
	 * @throws IOException
	 */
	private static BufferedImage scale(File file, int height, int width,
			boolean hasFiller) throws IOException {
		double ratio = 0.0; // 缩放比例
		BufferedImage srcImage = ImageIO.read(file);
		Image destImage = srcImage.getScaledInstance(width, height,
				BufferedImage.SCALE_SMOOTH);
		// 计算比例
		if ((srcImage.getHeight() > height) || (srcImage.getWidth() > width)) {
			if (srcImage.getHeight() > srcImage.getWidth()) {
				ratio = (new Integer(height)).doubleValue()
						/ srcImage.getHeight();
			} else {
				ratio = (new Integer(width)).doubleValue()
						/ srcImage.getWidth();
			}
			AffineTransformOp op = new AffineTransformOp(AffineTransform
					.getScaleInstance(ratio, ratio), null);
			destImage = op.filter(srcImage, null);
		}
		if (hasFiller) {// 补白
			BufferedImage image = new BufferedImage(width, height,
					BufferedImage.TYPE_INT_RGB);
			Graphics2D graphic = image.createGraphics();
			graphic.setColor(Color.white);
			graphic.fillRect(0, 0, width, height);
			if (width == destImage.getWidth(null))
				graphic.drawImage(destImage, 0, (height - destImage
						.getHeight(null)) / 2, destImage.getWidth(null),
						destImage.getHeight(null), Color.white, null);
			else
				graphic.drawImage(destImage,
						(width - destImage.getWidth(null)) / 2, 0, destImage
								.getWidth(null), destImage.getHeight(null),
						Color.white, null);
			graphic.dispose();
			destImage = image;
		}
		return (BufferedImage) destImage;
	}

}
