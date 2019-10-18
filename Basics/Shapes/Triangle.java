/**
 * Auto Generated Java Class.
 */
public class Triangle implements Shape {
  
  private double base;
  private double height;
  
  public double getArea(){
    return 0.5*base*height;
  }
  
  public String getShapeType(){
    return "Triangle";
  }
  
  public Triangle() { //Default constructor
   this.base = 0.0;
   this.height = 0.0;
   
  }
  
  public Triangle(double base, double height) { 
   this.base = base;
   this.height = height;
   
  }
  
  public double getBase(){ //Accessor
    return this.base;
  }
  
  public double getHeight(){ //Accessor
    return this.height;
  }
  
  public void setBase(double base){ //Mutator
    this.base = base;
  }
  
  public void setHeight(double height){ //Mutator
    this.height = height;
  }
  
   public String toString(){
    return "Triangle: Base: " + this.base + " Height: " + this.height + " Area: " + 0.5*this.base*this.height;
  }
  
  
}
