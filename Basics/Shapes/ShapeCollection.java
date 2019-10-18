**
 * Auto Generated Java Class.
 */
public class ShapeCollection {
  private static final int maxShapes = 100; //max amount of shapes that can be added
  private Shape[] shapes = new Shape[maxShapes]; //array of shapes
  
  public ShapeCollection() { 
    shapes = new Shape[maxShapes];
  }
  
  public Shape[] getShape(){
    return this.shapes;
  }
  
  public void addShape(Shape shape){ //method to add shape
  
    for(int i=0; i<shapes.length; i++){
      if(shapes[i] == null){
        shapes[i] = shape;
        return;
      }
    }
  }
  
  private void sortShapes(){ //method to sort shapes
    for (int i = 0; i < shapes.length; i++){
      for (int j = i+1; j < shapes.length; j++){
        if(shapes[i] != null && shapes[j] != null){
          if (shapes[i].getArea() > shapes[j].getArea()){ //insertion sort based on area
            Shape temp = shapes[i];
            shapes[i] = shapes[j];
            shapes[j] = temp;
            return;
          }
        }
      }
    }
  }
  
  public void removeShape(String type, double area){ //method to remove shapes
    
    for(int i=0; i<shapes.length; i++){
      if(shapes[i] != null && shapes[i].getShapeType().equalsIgnoreCase(type) && shapes[i].getArea() == area){
        shapes[i] = null;
        return;
      }
    }
    System.out.println("The specified Shape was not found");
  }
  
  public void printShapes(){ //method to print shapes
    
    
    System.out.println("Current Collection of Shapes");
    
    sortShapes();
    for(int i=0; i<shapes.length; i++){
      if(shapes[i] != null){
        System.out.println(shapes[i]);
      }
    }
  }
  
} 
