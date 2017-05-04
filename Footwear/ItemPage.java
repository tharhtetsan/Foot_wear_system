package Footwear;

import java.awt.Scrollbar;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.print.attribute.Size2DSyntax;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArrayBase;
import javafx.collections.ObservableList;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import Footwear.*;

public class ItemPage extends Application{
	static List<Inventory> InventoryData = new ArrayList<>();
	//static StringBuilder str = new StringBuilder();
		public FlowPane itempage() throws FileNotFoundException, IOException{
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
							resultInventorydata[i][10])
							);		
					
			}
	
		  ObservableList<Inventory> list =FXCollections.observableArrayList(InventoryData);
		// for table view for items
		TableView items = new TableView();
		items.setItems(list);
		Label label=new Label("\t\t\t\t\t\t\t Items Page");
		label.setFont(new Font(20));;
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
		
		TableColumn profit = new TableColumn("Gross Profit");
		profit.setMinWidth(100);
		profit.setCellValueFactory(new PropertyValueFactory<Inventory, Double>("profit"));
		
		

		items.getColumns().addAll(CodeNo, Category, Brand, Size, Color, oriprice, saleprice,profit);
		/*items.setMaxHeight(600);
		items.setMaxWidth(605);*/
		items.setStyle("-fx-color:lightblue");
		// end of table view
		// button pane
		VBox pane=new VBox();
		pane.getChildren().addAll(label,items);
		pane.setStyle("fx-background-color:pink");
		FlowPane paneforall = new FlowPane();
		paneforall.getChildren().addAll(pane);
		paneforall.setAlignment(Pos.CENTER);
		

		// add button action

		return paneforall;

	}

			public static void main(String[]args){
		launch(args);
	}

	
	@Override
	public void start(Stage primary) throws Exception {
		Scene scene=new Scene(itempage());
		primary.setScene(scene);
		primary.show();
		
		
		
	}

}
