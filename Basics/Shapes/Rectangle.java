/**
 * Auto Generated Java Class.
 */
public class Rectangle implements Shape {
  
  private double length;
  private double width;
  
  public double getArea(){
    return this.length*this.width;
  }
  
  public String getShapeType(){
    return "Rectangle";
  }
  
  public Rectangle(){
    this.width = 0.0;
    this.length = 0.0;
  }
  
  public Rectangle(double width, double length){
    this.width = width;
    this.length = length;
  }
  
  public double getLength(){ //Accessor
    return this.length;
  }
  
  public double getWidth(){ //Accessor
    return this.width;
  }
  
  public void setLength(double length){ //Mutator
    this.length = length;
  }
  
  public void setWidth(double width){ //Mutator
    this.width = width;
  }
  
  public String toString(){
    return "Rectangle: Width: " + this.width + " length: " + this.length + " Area: " + this.length*this.width;
  }
  
}
