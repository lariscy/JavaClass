package cl11;

public class Circle implements Measurable {

	private double radius;
	
	public Circle() {
		this(Measurable.DEFAULT_SIZE);
	}

	public Circle(double radius) {
		this.radius = radius;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		if (radius > 0)
			this.radius = radius;
		else
			this.radius = Measurable.DEFAULT_SIZE;
	}

	@Override
	public double getPerimeter() {
		return 2 * Math.PI * this.getRadius();
	}

	@Override
	public double getArea() {
		return Math.PI * Math.pow(this.getRadius(), 2);
	}

}
