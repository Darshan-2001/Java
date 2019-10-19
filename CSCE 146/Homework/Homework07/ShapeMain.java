import java.io.*;

import java.util.*;

public class ShapeMain{
     public static int index;

     public static void main(String args[]) throws Exception {

          ArrayList<Shape> obj = new ArrayList<Shape>();
          File file = new File("shapeFile.txt");
          Scanner sfile = new Scanner(file);
          String names[] = new String[50];
          int count = 0;
          int i = 0;
          if (file.exists()){
              i = 0;

              // if file is open

              while (sfile.hasNextLine()) {
                   // get each line from the file
                   names[i] = sfile.nextLine();
                   i++;
              }
              count = i;
          }
          else{
              System.out.println("Sorry! Can not open the file.\n");
          }

          // close the file
          sfile.close();
          // loop till end of the length of the file
          for (int j = 0; j < count; j++){
              // if the line contains SQUARE call ComputeSquare function
              if (names[j].toUpperCase().contains("RECTANGLE")){
                   Rectangle r = new Rectangle();
                   r.calcRectangle(names[j]);
                   obj.add(r);
              }
              // if the line contains CIRCLE call ComputeCircle function
              else if (names[j].toUpperCase().contains("CIRCLE")){
                   Circle c = new Circle();
                   c.calcCircle(names[j]);
                   obj.add(c);
              }
              // if the line contains CUBE call ComputeCube function
              else if (names[j].toUpperCase().contains("RIGHT TRIANGLE")){
                   RightTriangle rt = new RightTriangle();
                   rt.calcRightTriangle(names[j]);
                   obj.add(rt);
              }
              // if the line contains other than object names display the
              // invalid statement
              else
                   System.out.println();
          }

          LinkedBSTree LBST = new LinkedBSTree();
          //adding Shapes to the BinarySearchTree
          System.out.println("Display all values: ");
          for (int k = 0; k < obj.size(); k++){
              LBST.insert(obj.get(k));          
          }
         //printing the pre-order
          System.out.println("Printing pre-order: ");
          LBST.printPreOrder();
          System.out.println("\n");

           //printing the in-order
          System.out.println("Printing in-order: ");
          LBST.printInOrder();
          System.out.println("\n");

          //printing the post-order
          System.out.println("Printing post-order: ");
          LBST.printPostOrder();
          System.out.println("\n");

          //printing the maximum area
          System.out.println("The maximum area is: " + getMaxArea(obj));
          System.out.println("\n");

         

          //deleting the specified shape

          System.out.println("Deleting: "+obj.get(4).toString());
          LBST.delete(obj.get(4));
          System.out.println("\n");
          System.out.println("Printing pre-order: ");
          LBST.printPreOrder();
          System.out.println("\n");

     }
     //getMaxArea method gets the Maximum area from the list

     public static double getMaxArea(ArrayList<Shape> s){
          double max = s.get(0).getArea();
          int i;
          for (i = 0; i < s.size(); i++){
              if (s.get(i).getArea() > max){
                   max = s.get(i).getArea();
              }
          }
          return max;

     }

}