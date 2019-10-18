/**
 * Auto Generated Java Class.
 */
public class Circle implements Shape {
  
  private double radius;
  
  public double getArea(){
    return Math.PI*radius*radius;
  }
  
  public String getShapeType(){
    return "Circle";
  }
  
  public Circle() { 
    this.radius = 0.0;
  }
  
  public Circle(double radius) { 
    this.radius = radius;
  }
  
  public double getRadius(){ //Accessor
    return this.radius;
  }
  
  public void setRadius(double radius){ //Mutator
    this.radius = radius;
  }
  
   public String toString(){
    return "Circle: Radius: " + this.radius + " Area: " + Math.PI*this.radius*this.radius;
  }

}
