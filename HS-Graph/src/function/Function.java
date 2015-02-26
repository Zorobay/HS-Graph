package function;

import java.util.List;

import component.Component;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.paint.Color;

public class Function {
	private Color graphColor;
	private SimpleStringProperty function;
	private SimpleStringProperty enabled;
	private FormulaExtractor fExt;
	
	public Function(Color col, String func, String enab){
		graphColor = col;
		function = new SimpleStringProperty(func);
		enabled = new SimpleStringProperty(enab);
	}
	
	public List<Component> getComponentArray(){
		return FormulaExtractor.getComponentList(function.get());
	}
	
	public void setGraphColor(Color col){
		graphColor = col;
	}
	
	public Color getGraphColor(){
		return graphColor;
	}
	
	public void setFunction(String func){
		function.set(func);
	}
	
	public String getFunction(){
		return function.get();
	}
	
	public void setEnabled(String enab){
		enabled.set(enab);
	}
	
	public String getEnabled(){
		return enabled.get();
	}
	
	public String toString(){
		return function.get();
	}
}
