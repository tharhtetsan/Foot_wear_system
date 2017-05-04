package Footwear;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.converter.DateTimeStringConverter;

public class InventroyPage extends Application{
	static List<Inventory> InventoryData = new ArrayList<>();
	
	
	public FlowPane pane() throws FileNotFoundException, IOException,NumberFormatException{
		String resultInventorydata[][]=TwoDarrayformfile.readInventorydata();
		InventoryData.clear();
		for (int i = 0; i < resultInventorydata.length; i++) {
			
			
				InventoryData.add(new Inventory(
						resultInventorydata[i][0],
						resultInventorydata[i][1],
						resultInventorydata[i][2],
						resultInventorydata[i][3], 
						resultInventorydata[i][4],
						resultInventorydata[i][5],
						resultInventorydata[i][6], 
						resultInventorydata[i][7],
						resultInventorydata[i][8],
						resultInventorydata[i][9],
						resultInventorydata[i][10]
								)
						);		
				
		}
		
		ObservableList<Inventory> list =FXCollections.observableArrayList(InventoryData);
		Label label=new Label("\t\t\t\t\t\t\tInventory Items Page");
		label.setFont(new Font(20));;
		// for table view for items
		TableView items = new TableView();
		items.setItems(list);
		TableColumn date = new TableColumn("Date");
		date.setMinWidth(100);
		date.setCellValueFactory(new PropertyValueFactory<Inventory, String>("date"));

	
		TableColumn CodeNo = new TableColumn("Code Number");
		CodeNo.setMinWidth(100);
		CodeNo.setCellValueFactory(new PropertyValueFactory<Inventory, String>("codeno"));

		TableColumn Category = new TableColumn("Type");
		Category.setMinWidth(100);
		Category.setCellValueFactory(new PropertyValueFactory<Inventory, String>("type"));

		TableColumn Brand = new TableColumn("Brand");
		Brand.setMinWidth(100);
		Brand.setCellValueFactory(new PropertyValueFactory<Inventory, String>("brand"));

		TableColumn Size = new TableColumn("Size");
		Size.setMinWidth(100);
		// for mini and max
		TableColumn minisize = new TableColumn("Minimun");
		minisize.setMinWidth(100);
		minisize.setCellValueFactory(new PropertyValueFactory<Inventory, Integer>("minsize"));
		TableColumn maxsize = new TableColumn("Maximum");
		maxsize.setMinWidth(100);
		maxsize.setCellValueFactory(new PropertyValueFactory<Inventory, Integer>("maxsize"));
		Size.getColumns().addAll(minisize, maxsize);

		TableColumn Color = new TableColumn("Color");
		Color.setMinWidth(100);
		Color.setCellValueFactory(new PropertyValueFactory<Inventory, String>("color"));

		TableColumn oriprice = new TableColumn("Original Price");
		oriprice.setMinWidth(100);
		oriprice.setCellValueFactory(new PropertyValueFactory<Inventory, Integer>("oriprice"));

		TableColumn saleprice = new TableColumn("Sale Price");
		saleprice.setMinWidth(100);
		saleprice.setCellValueFactory(new PropertyValueFactory<Inventory, Integer>("saleprice"));
		
		TableColumn quantity = new TableColumn("Qunatity");
		quantity.setMinWidth(100);
		quantity.setCellValueFactory(new PropertyValueFactory<Inventory, Integer>("quantity"));



		items.getColumns().addAll(date,CodeNo, Category, Brand, Size, Color, oriprice, saleprice,quantity);
		/*items.setMaxHeight(600);
		items.setMaxWidth(605);*/
		items.setStyle("-fx-color:lightblue");
		// end of table view
		// button pane
		VBox pane=new VBox(5);
		pane.getChildren().addAll(label,items);
		
		FlowPane paneforall = new FlowPane();
		
	
		paneforall.getChildren().addAll(pane);
		paneforall.setAlignment(Pos.CENTER);
		

		// add button action

		return paneforall;

	}

			public static void main(String[]args){
		launch(args);
	}

	
		
		//To check the data from 2D array
		/*System.out.println("The value of 2D array from file");
		for (int i=0;i<ItemsData1.length;i++){
			for(int j=0;j<ItemsData1[i].length;j++){
				System.out.println(ItemsData1[i][j]);
			}
		}*/
		
		
		
	
	@Override
	public void start(Stage primary) throws Exception {
		Scene scene=new Scene(pane());
		primary.setScene(scene);
		primary.show();
		
		
		
	}

}
