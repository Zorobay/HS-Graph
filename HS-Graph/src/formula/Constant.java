package formula;

public class Constant extends Component{
	
	double value;
	
	public Constant(String function) {
		value = Double.parseDouble(function);
	} 
	
	public double getValue(double x){
		return value;
	}
}