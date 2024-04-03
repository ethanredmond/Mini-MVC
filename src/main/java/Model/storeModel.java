package Model;

import javafx.beans.property.SimpleDoubleProperty;


public class storeModel {

	
	public storeModel() {
		
	}
	
	SimpleDoubleProperty num = new SimpleDoubleProperty();

	public SimpleDoubleProperty getNum()
	{
		return num;
	}
	
	
	public void addMoney(double amt) {
		num.set(num.get() + amt);
	}

	
	
	
}
