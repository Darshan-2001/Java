* Written By Prashant Thirumal
 * */

import java.util.*;

public class ShapeFrontEnd{
  
  public static void main(String[] args){
    Scanner kb = new Scanner(System.in);
    
    ShapeCollection collect = new ShapeCollection(); // instance of ShapeCollection to use its methods
    
    int selection = 0;
    
    System.out.println("Welcome to the Shapes collections");
    
    while(selection != 9){ //continually prompt user until user wants to quit
      System.out.println("Enter 1: Add a shape \nEnter 2: Remove a shape \nEnter 9: Quit");
      selection = kb.nextInt();
      
      if(selection==1){
        System.out.println("What type of shape? \nRectangle, Triangle, or Circle?");
        kb.nextLine();
        String type = kb.nextLine();
        
        if(type.equalsIgnoreCase("Rectangle")){
          System.out.println("Enter a length followed by a width");
          double length = kb.nextDouble();
          double width = kb.nextDouble();
          Rectangle rectangle = new Rectangle(length,width);
          collect.addShape(rectangle);
        }
        
        else if(type.equalsIgnoreCase("Triangle")){
          System.out.println("Enter a base followed by a height");
          double base = kb.nextDouble();
          double height = kb.nextDouble();
          Triangle triangle = new Triangle(base, height);
          triangle.getArea();
          collect.addShape(triangle);
        }
        
        else if(type.equalsIgnoreCase("Circle")){
          System.out.println("Enter a radius");
          double radius = kb.nextDouble();
          Circle circle = new Circle(radius);
          circle.getArea();
          collect.addShape(circle);
        }
      }
      
      if(selection == 2){
        System.out.println("Enter the shape type");
        kb.nextLine();
        String type = kb.nextLine();
        System.out.println("Enter an area");
        double area = kb.nextDouble();
        collect.removeShape(type, area);
      }
      
      collect.printShapes();
    }
    kb.close();
  }
}
