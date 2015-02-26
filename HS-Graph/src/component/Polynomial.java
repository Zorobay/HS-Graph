package component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polynomial implements Component{
	
	final private static String REG_COEFFICIENT = "[+-]?\\s*(\\d+\\.?\\d*)?(?=[a-zA-Z])";
	final private static String REG_EXPONENT = "(?<=\\^)[+-]?((\\d+\\.\\d+)|(\\d*))";
	double coefficient;
	double exp;

	public Polynomial(String function){
		setCoefficient(function);
		setExp(function);
	}
	
	public double getValue(double x){
		System.out.println("Exponent: " + exp); //For debug purpose
		return coefficient*Math.pow(x, exp);
	}
	
	private void setCoefficient(String function){ //Finds the coefficient part of the input string function
		Pattern pattern = Pattern.compile(REG_COEFFICIENT);
		Matcher matcher = pattern.matcher(function);
		
		if(matcher.find()){
			String gr = matcher.group();
			System.out.println("group: " + "(" + gr + ")");
			if(gr.equals("+") || gr.equals("") | gr == null){
				coefficient = 1.0;
			}
			else if(gr.equals("-")){
				coefficient = -1.0;
			}
			else{
				coefficient = Double.parseDouble(gr);
			}
		}
		else{
			coefficient = 1.0;
		}
	}
	
	private void setExp(String function){ //finds the exponent part of the input string function
		Pattern pattern = Pattern.compile(REG_EXPONENT);
		Matcher matcher = pattern.matcher(function);
		
		if(matcher.find()){
			String gr = matcher.group();
			System.out.println("Exponent gr: " + gr); //For debug purpose
			if(gr == null | gr == " " | gr == ""){
				exp = 1.0;
			}	
			else{
				exp = Double.parseDouble(matcher.group());
			}
		}
		else{
			exp = 1.0;
		}
	}
}
