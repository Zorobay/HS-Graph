
package function;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import component.Component;
import component.Constant;
import component.Polynomial;

import main.GraphField;

public class FormulaExtractor {
	
	final private static String REG_PARTS = "[+-]?\\s*([a-zA-Z]|(\\d+\\.?\\d*[a-zA-Z]?))(\\^[-]?\\d+\\.?\\d*)?(?=[+-]?\\s*|$)";
	final private static String REG_POLY = "[+-]?\\s*([a-zA-Z]|(\\d+\\.?\\d+[a-zA-Z]?))(\\^[-]?\\d+)?";
	final private static String REG_CONSTANT = "[+-]?\\s*\\d+(?:\\.\\d+)?(?=[-+\\s]|$)";
	
	public static List<Component> getComponentList(String func){
		return generateComponentList(func);
	}
	
	/*
	 *generateComponentArray: 
	 *Instead of an array of strings, 
	 *this outputs an array of objects of type Component
	 *that represent the components of the formula
	 */
	private static List<Component> generateComponentList(String func){ 
		List<Component> componentList = new ArrayList<Component>();
		List<String> listOfParts = generateListOfParts(func);								  
		
		for(int i = 0; i < listOfParts.size(); i++){
			switch (getType(listOfParts.get(i))) {
				case "CON": 
					System.out.println("Matched constant! (pos: " + i + ")");
					componentList.add(new Constant(listOfParts.get(i)));
					break;
				case "POL":
					componentList.add(new Polynomial(listOfParts.get(i)));
					break;
			}
		}
		
		return componentList;
	}
	
	private static List<String> generateListOfParts(String func){ //Separates the different parts of the input formula
		
		Pattern pattern = Pattern.compile(REG_PARTS);
		Matcher matcher = pattern.matcher(func);
		List<String> listOfParts = new ArrayList<String>();
		
		while(matcher.find()){
			if(matcher.group() != null){
				listOfParts.add(matcher.group().trim().replaceAll("\\s", "")); //add found part to list and remove all space characters
				System.out.println("Found: " + matcher.group().trim().replaceAll("\\s", "") + " at [" + matcher.start() + "," + matcher.end() + "]");
				//For debug purpose
			}
		}
		System.out.println("Length of array of parts: " + listOfParts.size());
		return listOfParts;
	}
	
	private static String getType(String part){
		if(part.matches(REG_CONSTANT))
			return "CON";
		else
			return "POL";
	}
	
	
}
