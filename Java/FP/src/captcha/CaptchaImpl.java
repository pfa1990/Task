package captcha;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class CaptchaImpl {

	private static final Integer MAX_LONG = 10;
	private static final Integer MAX_WIDTH = 300;
	private static final Integer MAX_HEIGHT = 300;
	private static final Integer DEFAULT_WIDTH = 250;
	private static final Integer DEFAULT_HEIGHT = 90;
	private String value;
	private String filename;
	private Integer width, height;
	private Random trnd = new Random();

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		if (value.length() <= 0 || value.length() >= MAX_LONG)
			throw new IllegalArgumentException("Catpcha.setValue: longitud de"
					+ " cadena no comprendida entre 0.." + MAX_LONG);
		this.value = value;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String fn) {
		this.filename = fn;
	}

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer w) {
		if (w < 0 || w > MAX_WIDTH)
			throw new IllegalArgumentException("Catpcha.setWidth: valor no "
					+ "comprendido entre 0.." + MAX_WIDTH);
		this.width = w;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer h) {
		if (h < 0 || h > MAX_HEIGHT)
			throw new IllegalArgumentException("Catpcha.setHeight: valor no "
					+ "comprendido entre 0.." + MAX_HEIGHT);
		this.height = h;
	}

	public CaptchaImpl(String value) {
		setValue(value);
		setFilename(value + ".jpg");
		setWidth(250);
		setHeight(90);
	}

	public CaptchaImpl(String value, String fileName) {
		setValue(value);
		setFilename(fileName);
		setWidth(DEFAULT_WIDTH);
		setHeight(DEFAULT_HEIGHT);
	}

	public CaptchaImpl(String value, String fileName, Integer width,
					   Integer height) {
		setValue(value);
		setFilename(fileName);
		setWidth(width);
		setHeight(height);
	}

	public void createJPG() {
		Color back = new Color(255, 255, 255);
		Color cfont = new Color(0, 0, 255);
		Font tfont = new Font("SansSerif", 1, 25);
		BufferedImage bufImage = new BufferedImage(getWidth(), getHeight(),
				BufferedImage.TYPE_INT_RGB);
		Graphics g = bufImage.createGraphics();
		g.setColor(back);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(cfont);
		
		for (int i = 0; i < 15; i++) // Generamos algo de ruido aditivo
			g.drawLine(trnd.nextInt(getWidth()), trnd.nextInt(getHeight()),
					trnd.nextInt(getWidth()), trnd.nextInt(getHeight()));
		g.setColor(cfont);
		g.setFont(tfont);
		g.drawString(getValue(), getWidth() / 4, getHeight() / 2);
		g.setColor(back);
		
		for (int i = 0; i < 20; i++) // Generamos algo de ruido substractivo
			g.drawLine(trnd.nextInt(getWidth()), trnd.nextInt(getHeight()),
					trnd.nextInt(getWidth()), trnd.nextInt(getHeight()));
		File file = new File(getFilename());
		
		try {
			file.createNewFile();
			ImageIO.write(bufImage, "jpg", file);
		} catch (IOException oops) {
			oops.printStackTrace();
		}
	}
}
