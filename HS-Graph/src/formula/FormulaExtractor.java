package formula;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import main.GraphField;

public class FormulaExtractor {
	
	final private static String REG_PARTS = "[+-]?\\s*([a-zA-Z]|(\\d+\\.?\\d*[a-zA-Z]?))(\\^[-]?\\d+\\.?\\d*)?(?=[+-]?\\s*|$)";
	final private static String REG_POLY = "[+-]?\\s*([a-zA-Z]|(\\d+\\.?\\d+[a-zA-Z]?))(\\^[-]?\\d+)?";
	final private static String REG_CONSTANT = "[+-]?\\s*\\d+(?:\\.\\d+)?(?=[-+\\s]|$)";
	
	public static void setFormula(String form){ //Function to be called from HS-Graph. "form" is what the user inputted to the program.
		GraphField.setArrayOfComponents(generateComponentArray(form));
	}
	
	/*
	 *generateComponentArray: 
	 *Instead of an array of strings, 
	 *this outputs an array of objects of type Component
	 *that represent the components of the formula
	 */
	private static List<Component> generateComponentArray(String form){ 
		List<String> arrayOfParts = generateArrayOfParts(form);			
		List<Component> list = new ArrayList<Component>();							  
		
		for(int i = 0; i < arrayOfParts.size(); i++){
			switch (getType(arrayOfParts.get(i))) {
				case "CON": 
					list.add(new Constant(arrayOfParts.get(i)));
					break;
				case "POL":
					list.add(new Polynomial(arrayOfParts.get(i)));
					break;
			}
		}
		
		return list;
	}
	
	private static List<String> generateArrayOfParts(String form){ //Separates the different parts of the input formula
		
		Pattern pattern = Pattern.compile(REG_PARTS);
		Matcher matcher = pattern.matcher(form);
		List<String> arrayOfParts = new ArrayList<String>();
		
		while(matcher.find()){
			if(matcher.group() != null){
				arrayOfParts.add(matcher.group().trim().replaceAll("\\s", ""));
				System.out.println("Found: " + matcher.group().trim().replaceAll("\\s", "") + " at [" + matcher.start() + "," + matcher.end() + "]");
				//For debug purpose
			}
		}
		System.out.println("Length of array of parts: " + arrayOfParts.size());
		return arrayOfParts;
	}
	
	private static String getType(String part){
		if(part.matches(REG_CONSTANT))
			return "CON";
		else
			return "POL";
	}
	
	
}
