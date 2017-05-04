package Footwear;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class RetailTable extends Application {
	RetailTable(){}
	public static FlowPane Retail_Table()
	{
	
	TableView items = new TableView();
	items.setItems(ForRetailCustomer.list);
	
	TableColumn Date = new TableColumn("Date");
	Date.setMinWidth(100);
	Date.setCellValueFactory(new PropertyValueFactory<String, String>("date"));
	
	TableColumn CodeNo = new TableColumn("Code Number");
	CodeNo.setMinWidth(100);
	CodeNo.setCellValueFactory(new PropertyValueFactory<String, String>("codeno"));
	
	TableColumn Brand = new TableColumn("Brand");
	CodeNo.setMinWidth(100);
	CodeNo.setCellValueFactory(new PropertyValueFactory<String, String>("brand"));
	
	TableColumn Quantity = new TableColumn("Quantity");
	CodeNo.setMinWidth(100);
	CodeNo.setCellValueFactory(new PropertyValueFactory<String, String>("quantity"));
	
	items.getColumns().addAll(CodeNo, Brand,Quantity);
	FlowPane panetabel=new FlowPane();
	panetabel.getChildren().add(items);
	panetabel.setAlignment(Pos.CENTER);
	return panetabel;
	}
	public static void main(String[]args){
		
		launch(args);
		
	}
	@Override
	public void start(Stage arg) throws Exception {
		Scene scene=new Scene(Retail_Table());
		arg.setScene(scene);
		arg.show();
	}
	
}
