package cl11;

public class Rectangle implements Measurable {
	
	private double length;
	private double width;
	
	public Rectangle() {
		this(Measurable.DEFAULT_SIZE, Measurable.DEFAULT_SIZE);
	}

	public Rectangle(double length, double width) {
		this.setLength(length);
		this.setWidth(width);
	}

	public double getLength() {
		return length;
	}
	
	public void setLength(double length) {
		if (length > 0)
			this.length = length;
		else
			this.length = Measurable.DEFAULT_SIZE;
	}
	
	public double getWidth() {
		return width;
	}
	
	public void setWidth(double width) {
		if (width > 0)
			this.width = width;
		else
			this.width = Measurable.DEFAULT_SIZE;
	}

	@Override
	public double getPerimeter() {
		return 2 * (width + length);
	}

	@Override
	public double getArea() {
		return width * length;
	}

}
