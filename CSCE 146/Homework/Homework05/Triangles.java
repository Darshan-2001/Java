import java.applet.*;
import java.awt.*;
import java.util.*;

public class Triangles extends Applet {
	public static final int STOP = 4;
	private Image display;
	private Graphics drawingArea;

	public void init() {
		int height = getSize().height;
		int width = getSize().width;
		int x = 0;
		int y = 0;
		display = createImage(width,height);
		drawingArea = display.getGraphics();	
		drawTriangleRSU(0,0,width,drawingArea);
		//draw the thing
		drawGasket(0,0,width,drawingArea);

	}

	public void paint(Graphics g) {
		g.drawImage(display, 0, 0, null);
		paint(g);
	}

	public static void drawGasket(int x, int y, int side, Graphics g) {

		int sub = side/2;

		int[] xS = {x+sub*1/2,
				x+sub,
				x+sub*3/2,
				x+sub*1/2}; //It has to connect to first point

		int[] yS = {y+sub,
				y+side,
				y+sub,
				y+sub};//Has to connect to first point

		g.setColor(Color.white);
		g.fillPolygon(xS, yS, xS.length);

		if(sub >= 3) { 
			drawGasket(x+sub*1/2,y,sub,g);
			drawGasket(x,y+sub,sub,g);
			drawGasket(x+sub,y+sub,sub,g);


		}
	}

	public static void drawTriangleRSU(int x, int y, int side, Graphics g) {
		int[] x1S = {x, //First
				x+side/2, //Second
				x+side, //Third
				x}; //It has to connect

		int[] y1S = {y+side, //First
				y, //Second
				y+side, // Third
				y+side}; //It has to connect to the first

		//draw shape
		g.fillPolygon(x1S,y1S,x1S.length);
	}

}

