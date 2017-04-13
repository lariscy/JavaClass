package cl11;

public class Square extends Rectangle {
	
	public Square(){
		this(Measurable.DEFAULT_SIZE);
	}
	
	public Square(double sideLength){
		super(sideLength, sideLength);
	}
	
	public double getSide(){
		return this.getLength();
	}
	
	public void setSide(int sideLength){
		this.setLength(sideLength);
		this.setWidth(sideLength);
	}

}
