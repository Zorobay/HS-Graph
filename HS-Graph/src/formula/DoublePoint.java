package formula;

/*
 * ---DoublePoint---
 * This class only exist because I want to be able to return both coordinates
 * at the same time, and the default Point class can only hold int values.
 */

public class DoublePoint {
	private double p1;
	private double p2;
	
	public DoublePoint(double x, double y){
		p1 = x;
		p2 = y;
	}
	
	public double getX(){
		return p1;
	}
	
	public double getY(){
		return p2;
	}
}
