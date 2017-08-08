package com.monarchwang.website.utils.pictures;

import com.alibaba.simpleimage.io.*;
import com.alibaba.simpleimage.io.ByteArrayInputStream;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import lombok.Data;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import org.junit.Test;
import org.springframework.util.ResourceUtils;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.AlphaComposite;
import java.awt.image.BufferedImage;
import java.io.*;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by wanggl on 2017/8/7.
 */
public class PictureUtils {


	/**
	 * 水印文字内容
	 */
	public static final String MARK_TEXT = ("本人测试人员借款贰仟伍佰亿圆整");
	/**
	 * 水印文字类型
	 */
	public static final String FONT_NAME = "微软雅黑";
	/**
	 * 水印文字样式
	 */
	public static final int FONT_STYLE = Font.BOLD;
	/**
	 * 水印文字大小
	 */
	public static final int FONT_SIZE = 60;// 单位:像素
	/**
	 * 水印文字颜色
	 */
	public static final Color FONT_COLOR = Color.BLACK;
	/**
	 * 水印文字透明度
	 */
	public static final float ALPHA = 1.0F;

	private static final int MARGIN_TOP = 69;

	private static final int MARGIN_LEFT = -460;

	private static final int LINE_SPACE = 20;

	private static final int WORD_SPACE = 0;

	private static List<Word> words = new ArrayList<>();

	private static List<Word> otherInfo = new ArrayList<>();

	static {
		words.add(new Word("本人", 0));
		words.add(new Word("斗战胜佛", 1));
		words.add(new Word("，前", 0));
		words.add(new Word("叁", 1));
		words.add(new Word("个月每月需", 0));
		words.add(new Word("付款", 0));
		words.add(new Word("贰佰伍佰叁圆肆角整", 1));
		words.add(new Word("，后", 0));
		words.add(new Word("玖", 1));
		words.add(new Word("个月每月需付款", 0));
		words.add(new Word("壹佰贰拾叁元肆", 1));
		words.add(new Word("角整", 1));
		words.add(new Word("，共付", 0));
		words.add(new Word("拾贰", 1));
		words.add(new Word("期", 0));

		otherInfo.add(new Word("斗战胜佛 身份证号 320321199411054044", 0));
		otherInfo.add(new Word("", -1));
		otherInfo.add(new Word("经办人：施一诺 2017年05月09日", 0));
		otherInfo.add(new Word("", -1));
		otherInfo.add(new Word("QA-lily-test-new", 0));

	}

	@Test
	public void testWatermark() throws IOException {
		Thumbnails.of(ResourceUtils.getFile("classpath:ic_elec_sign_bill.jpg"))
				.watermark(Positions.CENTER, ImageIO.read(ResourceUtils.getFile("classpath:ic_stamp.png")), 1.0f).scale(1.0f)
				.outputQuality(1.0f)
				.toFile("result.jpg");
	}


	@Test
	public void testTextMark() throws Exception {

		Image image = ImageIO.read(ResourceUtils.getFile("classpath:ic_elec_back.jpg"));
		int width = image.getWidth(null);
		int height = image.getHeight(null);

		BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

		Graphics2D g = bufferedImage.createGraphics();
		g.drawImage(image, 0, 0, width, height, null);
		//消除文字锯齿
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		// 设置水印文字颜色
		g.setColor(FONT_COLOR);

		//设置电子借条id
		g.setFont(new Font(FONT_NAME, FONT_STYLE, 90));
		g.drawString("2 2 4 6", 200, 100);

		g.setFont(new Font(FONT_NAME, FONT_STYLE, FONT_SIZE));

		// 设置水印文字透明度
		g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, ALPHA));
		//水印旋转
		g.rotate(Math.toRadians(90), 0, MARGIN_TOP);


		// 设置借条信息
		int startX = MARGIN_TOP;
		int startY = MARGIN_LEFT;
		for (Word word : words) {
			if (word.getColor() == 0) {
				g.setColor(Color.BLACK);
			} else if (word.getColor() == 1) {
				g.setColor(Color.BLUE);
			} else {
				//换行
				startX = MARGIN_TOP;
				startY += (FONT_SIZE + LINE_SPACE);
			}

			//计算是否需要换行
			if (startX + (FONT_SIZE * getTextLength(word.getContent())) + WORD_SPACE > height - 50) {
				startX = MARGIN_TOP;
				startY += (FONT_SIZE + LINE_SPACE);
			}


			g.drawString(word.getContent(), startX, startY);
			startX += (FONT_SIZE * getTextLength(word.getContent())) + WORD_SPACE;
		}

		g.setFont(new Font(FONT_NAME, FONT_STYLE, 30));

		startX = MARGIN_TOP;
		startY += FONT_SIZE;
		//设置用户及经办人信息
		for (Word word : otherInfo) {
			if (word.getColor() == 0) {
				g.setColor(Color.BLACK);
			} else if (word.getColor() == 1) {
				g.setColor(Color.BLUE);
			} else {
				//换行
				startX = MARGIN_TOP;
				startY += LINE_SPACE + 15;
			}
			g.drawString(word.getContent(), startX, startY);
			startX += (FONT_SIZE * getTextLength(word.getContent())) + WORD_SPACE;
		}


		g.dispose();

		//获取bufferedImage的输入流

//		ByteArrayOutputStream bs = new ByteArrayOutputStream();
//		ImageOutputStream imageOutputStream = ImageIO.createImageOutputStream(bs);
//		ImageIO.write(bufferedImage, "jpg", imageOutputStream);
//		InputStream inputStream = new ByteArrayInputStream(bs.toByteArray());


		OutputStream os = new FileOutputStream("result.jpg");
		JPEGImageEncoder en = JPEGCodec.createJPEGEncoder(os);
		en.encode(bufferedImage);
	}

	/**
	 * 功能：获取文本长度。汉字为1:1，英文和数字为2:1
	 */
	private int getTextLength(String text) {
		int length = text.length();
		for (int i = 0; i < text.length(); i++) {
			String s = String.valueOf(text.charAt(i));
			if (s.getBytes().length > 1) {
				length++;
			}
		}
		length = length % 2 == 0 ? length / 2 : length / 2 + 1;
		return length;
	}

}

@Data
class Word {
	private String content;
	private int color;

	public Word(String content, int color) {
		this.content = content;
		this.color = color;
	}

	public Word() {
	}
}
