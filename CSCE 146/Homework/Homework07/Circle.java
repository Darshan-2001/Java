
public class Circle implements Shape {
	private double radius;
	private String shapeName;
	
	public double getArea() {
		return (this.radius * this.radius)*Math.PI;
	}
	
	public Circle() {
		this.radius = 0.0;
		this.shapeName = "";
	}
	
	public Circle(String shapeName, double aRadius) {
		this.shapeName = shapeName;
		this.radius = aRadius;
	}
	
	public void calcCircle(String aString) {
		String[] names = new String[10];
		names = aString.split("\t");
		shapeName = names[0];
		radius = Double.parseDouble(names[1]);
		setRadius(radius);
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	public String toString() {
		return shapeName + " Radius " + radius + " Area " + getArea();
	}

}
