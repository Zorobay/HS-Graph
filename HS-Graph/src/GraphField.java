import java.awt.Point;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class GraphField {

	final Canvas canvas = new Canvas();
	int m = 0;
	int c = 0;

	public GraphField(int x, int y) {
		canvas.setWidth(x);
		canvas.setHeight(y);
		paintAxis();
	}

	public void paintCanvas(){
		//Paint from origo in positive direction
		for(double i = -(canvas.getWidth()/2); i <= canvas.getWidth() / 2; i++){
			System.out.println(i + "  " + m + "  " + c);
			drawLine(canvas.getGraphicsContext2D(), (int)i);
		}
	}

	private void drawLine(GraphicsContext gc, int x) {
		gc.setFill(Color.BLACK);
		Point coord = toCanvasCoordinates(x, m * x + c);
		Point coord2 = toCanvasCoordinates(x + 1, m * (x + 1) + c);
		gc.strokeLine(coord.getX(), coord.getY(), coord2.getX(), coord2.getY());
	}

	private void paintAxis() {
		canvas.getGraphicsContext2D().strokeLine(canvas.getWidth() / 2, canvas.getHeight(), canvas.getWidth() / 2, 0); // Vertical y axis
		canvas.getGraphicsContext2D().strokeLine(0, canvas.getHeight() / 2, canvas.getWidth(), canvas.getHeight() / 2); // Horizontal x axis
	}
	
	private Point toCanvasCoordinates(int x, int y){ //Converts to conventional coordinates (-x to x) to (0 to x), same with y
		int xCord = (int)canvas.getWidth() / 2 + x;
		int yCord = (int)canvas.getHeight() / 2 - y;
		return new Point(xCord, yCord);
	}
	public Canvas getCanvas() {
		return canvas;
	}

	public void setm(int m) {
		this.m = m;
	}

	public void setc(int c) {
		this.c = c;
	}
}
