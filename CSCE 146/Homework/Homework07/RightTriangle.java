
public class RightTriangle implements Shape {
	private double side1;
	private double side2;
	private String shapeName;
	
	public double getArea(){
		return (1/2)*this.side1*this.side2;
	}
	
	public RightTriangle() {
		this.shapeName = "";
		this.side1 = 0.0;
		this.side2 = 0.0;
	}
	
	public RightTriangle(String aName, double aSide1, double aSide2) {
		this.shapeName = aName;
		this.side1 = aSide1;
		this.side2 = aSide2;
	}
	
	public void calcRightTriangle(String aString) {
		String[] names = new String[20];
		names = aString.split("\t");
		shapeName = names[0];
		side1 = Double.parseDouble(names[1]);
		side2 = Double.parseDouble(names[2]);
	}

	public double getSide1() {
		return side1;
	}

	public void setSide1(double side1) {
		this.side1 = side1;
	}

	public double getSide2() {
		return side2;
	}

	public void setSide2(double side2) {
		this.side2 = side2;
	}
	
	public String toString() {
		return shapeName + " Side 1: " + this.side1 + " Side 2: " + this.side2 + " Area: " + getArea();
	}
}
