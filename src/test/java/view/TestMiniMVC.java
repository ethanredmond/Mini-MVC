package view;


import java.io.IOException;

import org.testfx.assertions.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import Main.Main;
import Model.storeModel;
import View.Controller;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

@ExtendWith(ApplicationExtension.class)
public class TestMiniMVC {

	@Start
	private void start(Stage stage)
	{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("../View/adder.fxml"));

		try
		{
			BorderPane view = loader.load();
			Controller cont = loader.getController();
			cont.setModel(new storeModel());
			
			Scene s = new Scene(view);
			stage.setScene(s);
			stage.show();
			
		} 
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void enterAmt(FxRobot robot, String amt)
	{
		robot.clickOn("#amountText");
		robot.write(amt);
	}
	
	private void checkNum(FxRobot robot, String num)
	{
		Assertions.assertThat(robot.lookup("#amtLabel")
				.queryAs(Label.class)).hasText(num);
	}
	
	private void checkAddNum(FxRobot robot, String before, String change, String after)
	{
		checkNum(robot, before);
		enterAmt(robot, change);
		robot.clickOn("#addButton");
		checkNum(robot, after);
	}
	
	private void checkSubtractNum(FxRobot robot, String before, String change, String after)
	{
		checkNum(robot, before);
		enterAmt(robot, change);
		robot.clickOn("#subtractButton");
		checkNum(robot, after);
	}
	
	@Test
	public void testButtons(FxRobot robot)
	{
		
		checkAddNum(robot, "0", "10", "10");
		checkAddNum(robot, "10", "-20", "-10");
		checkAddNum(robot, "-10", "10", "0");
		checkSubtractNum(robot, "0", "20", "-20");
		checkSubtractNum(robot, "-20", "10", "-30");

	}
	
	
}
