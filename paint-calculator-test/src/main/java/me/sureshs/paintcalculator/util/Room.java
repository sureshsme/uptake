package me.sureshs.paintcalculator.util;

/**
 * model to hold room dimension values (length, width and height)
 * 
 * @author suresh
 *
 */
public class Room {

	private String length;
	private String width;
	private String height;

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	@Override
	public String toString() {
		return "Room [length=" + length + ", width=" + width + ", height=" + height + "]";
	}

}
