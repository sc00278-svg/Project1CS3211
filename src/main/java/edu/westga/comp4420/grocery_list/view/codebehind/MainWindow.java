package edu.westga.comp4420.grocery_list.view.codebehind;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Modality;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import java.io.IOException;

import edu.westga.comp4420.grocery_list.model.FinancialValueType;
import edu.westga.comp4420.grocery_list.model.FinancialValueItem;
import edu.westga.comp4420.grocery_list.Main;

/**
 * CodeBehind To Handle Processing for the MainWindow
 *
 * @author	sc00278
 * @version Fall 2026
 */
public class MainWindow {   
	@FXML 
	private ListView<FinancialValueItem> groceryItems;
	@FXML 
	private AnchorPane guiPane;
    @FXML
    private TextField name;
    @FXML
    private TextField value;
    @FXML
    private ComboBox<FinancialValueType> valueType;
    @FXML
    private Label errorLabel;

	@FXML
	void addItem(ActionEvent event) {
//		try {
//			FXMLLoader loader = new FXMLLoader();
//			loader.setLocation(Main.class.getResource(Main.ADD_ITEM_WINDOW_RESOURCE));
//			loader.load();
//			Parent parent = loader.getRoot();
//			Scene scene = new Scene(parent);
//			Stage addItemStage = new Stage();
//			addItemStage.setTitle(Main.WINDOW_TITLE);
//			addItemStage.setScene(scene);
//			addItemStage.initModality(Modality.APPLICATION_MODAL);
//
//			AddItemWindow controller = (AddItemWindow) loader.getController();
//			controller.setItemList(this.groceryItems.getItems());
//
//			addItemStage.showAndWait();
//		} catch (IOException error) {
//			Alert errorBox = new Alert(AlertType.ERROR);
//			errorBox.setContentText("Unable to open add window");
//			errorBox.showAndWait();
//		}

		if (!this.name.getText().trim().isEmpty() && !this.value.getText().trim().isEmpty()) {
			this.errorLabel.setText("");
			String value = this.value.getText().trim();
			this.groceryItems.getItems().add(new FinancialValueItem(this.name.getText().trim(), Double.parseDouble(value), this.valueType.getValue()));
		}
		else {
			this.errorLabel.setText("must have a valid name and dollar amount");
		}
	}
	
	

	@FXML
	void removeItem(ActionEvent event) {
		FinancialValueItem selectedItem = this.groceryItems.getSelectionModel().getSelectedItem();
		if (selectedItem != null) {
			this.groceryItems.getItems().remove(selectedItem);
		}
	}
	
	@FXML
	void initialize() {
		assert this.groceryItems != null : "fx:id=\"groceryItems\" was not injected: check your FXML file 'MainWindow.fxml'.";
		assert this.guiPane != null : "fx:id=\"guiPane\" was not injected: check your FXML file 'MainWindow.fxml'.";
		this.errorLabel.setWrapText(true);
		
		this.valueType.getItems().setAll(FinancialValueType.values());
		this.valueType.getSelectionModel().select(FinancialValueType.expense);
		
		this.value.textProperty().addListener((observable, oldValue, newValue) -> {
			if (!newValue.matches("^\\d*(\\.\\d{0,2})?$")) {
		        this.value.setText(oldValue);
		    }
		});
	}
}
