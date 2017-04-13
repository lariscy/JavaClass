package cl11;

import java.util.Arrays;

public class MeasurableDriver {
	
	private static Measurable r1 = new Rectangle();
	private static Measurable r2 = new Rectangle(4.0, 5.0);
	
	private static Measurable c1 = new Circle();
	private static Measurable c2 = new Circle(3.0);
	
	private static Measurable s1 = new Square();
	private static Measurable s2 = new Square(5.0);
	
	private static Measurable[] measurables = {r1, r2, c1, c2, s1, s2};
	
	public static void main(String[] args){
		Arrays.stream(measurables)
				.forEach(MeasurableDriver::display);
	}

	private static void display(Measurable m) {
		System.out.println(
				"Perimeter = " + m.getPerimeter() +
				", Area = " + m.getArea());
		if (m instanceof Square){
			System.out.println("side = " + ((Square) m).getSide());
		}
	}

}
