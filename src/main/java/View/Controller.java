package View;



import Model.storeModel;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.StringConverter;
import javafx.util.converter.NumberStringConverter;

public class Controller {

	storeModel model;
	
	public void setModel(storeModel newModel)
	{
		model = newModel;
		
		StringConverter<Number> fmt = new NumberStringConverter();
		Bindings.bindBidirectional(countLabel.textProperty(), 
				model.getNum(), fmt);
	}
	
	
	private double getAmt() {
		
		String val = numberTextField.textProperty().get();
		double amt = 0;
		
		
		amt = Double.parseDouble(val);
		
		return amt;
	}
		
		@FXML
	    private TextField numberTextField;

	    @FXML
	    private Label countLabel;

	    @FXML
	    void onAddClick(ActionEvent event) {
	    	double val = getAmt();
	    	model.addMoney(val);
	    }

	    @FXML
	    void onSubtractClick(ActionEvent event) {
	    	double val = getAmt();
	    	model.addMoney(-1 * val);
	    }

}

