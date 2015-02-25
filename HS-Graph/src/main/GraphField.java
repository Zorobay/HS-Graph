package main;
import java.awt.Point;
import java.util.List;

import formula.*;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class GraphField {

	final private static  Canvas canvas = new Canvas();
	private static Function[] listOfFunctions;
	private static Color axisColor = Color.BLACK;

	public static void initialize(int w, int h){
		canvas.setWidth(w);
		canvas.setHeight(h);
		paintAxis();
	}
	public static void paintCanvas(){ //Simply paints the canvas from far left to right
		clearCanvas();
		for(int functionIndex = 0; functionIndex < listOfFunctions.length; functionIndex++){ //iterate through function array
			for(double x = -(canvas.getWidth()/2); x <= canvas.getWidth() / 2; x++){ //iterate through x values for that function
				drawLine(x, listOfFunctions[functionIndex]);
			}
		}
	}

	private static void drawLine(double x, Function func) {
		getGC2D().setStroke(func.getGraphColor());
		List<Component> compList = func.getComponentArray();

		double fstY = 0;
		double fstX = x;
		double sndY = 0;
		double sndX = x + 1;

		for(int i = 0; i < compList.size(); i++){ //Add value of all components for x-value i to get FIRST y value
			fstY += compList.get(i).getValue(fstX);
			System.out.println("x: " + fstX + " y: " + fstY); //For debug purpose
		}

		for(int i = 0; i < compList.size(); i++){ //Add value of all components for x-value i to get SECOND y value
			sndY += compList.get(i).getValue(sndX);
		}

		DoublePoint p1 = toCanvasCoordinates(fstX, fstY);
		DoublePoint p2 = toCanvasCoordinates(sndX, sndY);

		//Paint line between first and second y value
		getGC2D().strokeLine(p1.getX(), p1.getY(), p2.getX(), p2.getY()); 
	}

	public static void clearCanvas(){ //clears the canvas and repaints the axis
		getGC2D().clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
		paintAxis();
	}

	private static void paintAxis() {
		getGC2D().setStroke(axisColor);
		getGC2D().strokeLine(canvas.getWidth() / 2, canvas.getHeight(), canvas.getWidth() / 2, 0); // Vertical y axis
		getGC2D().strokeLine(0, canvas.getHeight() / 2, canvas.getWidth(), canvas.getHeight() / 2); // Horizontal x axis
	}


	/*
	 *Converts to conventional coordinates, from (-x to x) to (0 to x).
	 *This enables us to specify a coordinate using using negative x and y values
	 *and the function interprets that in terms of coordinates for the canvas where
	 *there are no negative x and y values, they simply start at 0.
	 */
	private static DoublePoint toCanvasCoordinates(double x, double y){
		double xCord = canvas.getWidth() / 2 + x;
		double yCord = (int)canvas.getHeight() / 2 - y;
		return new DoublePoint(xCord, yCord);
	}

	public static Canvas getCanvas() {
		return canvas;
	}

	private static GraphicsContext getGC2D(){
		return canvas.getGraphicsContext2D();
	}

	public static void setFunctionArray(Function[] func){
		listOfFunctions = func;
	}
	
	public static void setAxisColor(Color col){
		axisColor = col;
		paintAxis();
	}
}
