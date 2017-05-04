package Footwear;

import java.awt.Scrollbar;
import java.awt.TextField;
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
import javafx.scene.Node;
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
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import Footwear.*;

public class SaleItemPage extends Application{


	
	static double totalprofit=0;
	
	static List<Sale> showSaleData = new ArrayList<>();
	
	public FlowPane salepane() throws FileNotFoundException, IOException, NumberFormatException{
		//To check the data fromthe ItemData ArrayList
		System.out.println("In SalePane's Form");
		String resultSaledata[][]=TwoDarrayformfile.readSaledata();
		showSaleData.clear();
		for (int i = 0; i < resultSaledata.length; i++) {

			showSaleData.add(new Sale(
						resultSaledata[i][0],
						resultSaledata[i][1],
						resultSaledata[i][2],
						resultSaledata[i][3], 
						resultSaledata[i][4],
						resultSaledata[i][5],
						resultSaledata[i][6], 
						resultSaledata[i][7],
						resultSaledata[i][8],
						resultSaledata[i][9],
						resultSaledata[i][10])
						);		
				
		}
		//totalprofit+=Double.parseDouble(profit1)*Double.parseDouble(sale_qty);
		
		ObservableList<Sale> list =FXCollections.observableArrayList(showSaleData);
		Label label=new Label("\t\t\t\t\t\t\t\tSale Items Page");
		label.setFont(new Font(20));;
		// for table view for items
		TableView items = new TableView();
		items.setItems(list);
		
		TableColumn date = new TableColumn("Date");
		date.setMinWidth(100);
		date.setCellValueFactory(new PropertyValueFactory<Sale, String>("date"));

		
	
		TableColumn CodeNo = new TableColumn("Code Number");
		CodeNo.setMinWidth(100);
		CodeNo.setCellValueFactory(new PropertyValueFactory<Sale, String>("codeno"));

		TableColumn Category = new TableColumn("Type");
		Category.setMinWidth(100);
		Category.setCellValueFactory(new PropertyValueFactory<Sale, String>("type"));

		TableColumn Brand = new TableColumn("Brand");
		Brand.setMinWidth(100);
		Brand.setCellValueFactory(new PropertyValueFactory<Sale, String>("brand"));

		TableColumn Size = new TableColumn("Size");
		Size.setMinWidth(100);
		// for mini and max
		TableColumn minisize = new TableColumn("Minimun");
		minisize.setMinWidth(100);
		minisize.setCellValueFactory(new PropertyValueFactory<Sale, String>("minsize"));
		TableColumn maxsize = new TableColumn("Maximum");
		maxsize.setMinWidth(100);
		maxsize.setCellValueFactory(new PropertyValueFactory<Sale, String>("maxsize"));
		Size.getColumns().addAll(minisize, maxsize);

		TableColumn Color = new TableColumn("Color");
		Color.setMinWidth(100);
		Color.setCellValueFactory(new PropertyValueFactory<Sale, String>("color"));

		TableColumn oriprice = new TableColumn("Original Price");
		oriprice.setMinWidth(100);
		oriprice.setCellValueFactory(new PropertyValueFactory<Sale, String>("oriprice"));

		TableColumn saleprice = new TableColumn("Sale Price");
		saleprice.setMinWidth(100);
		saleprice.setCellValueFactory(new PropertyValueFactory<Sale, String>("saleprice"));
		
		TableColumn quantity = new TableColumn("Qunatity");
		quantity.setMinWidth(100);
		quantity.setCellValueFactory(new PropertyValueFactory<Sale, String>("quantity"));
		
		


		items.getColumns().addAll(date,CodeNo, Category, Brand, Size, Color, oriprice, saleprice,quantity);
		items.setStyle("-fx-color:lightblue");
		// end of table view
		// button pane
		/*Label tfprofit = new Label();
		tfprofit.setStyle("-fx-background-color:lightblue");
		tfprofit.setFont(new Font(15));
		*/
		HBox box=new HBox(20);
		Button btnprofit=new Button("Total profit");
		box.getChildren().addAll(btnprofit);
		VBox paneforall = new VBox(10);
		
		/*btnprofit.setOnAction(e->{
			tfprofit.setText(Double.toString(totalprofit));
			
			
		});*/
		paneforall.getChildren().addAll(label,items);
		
		FlowPane pane=new FlowPane();
		pane.getChildren().add(paneforall);
		pane.setAlignment(Pos.CENTER);
		return pane;

	}

public static void main(String[]args){
	launch(args);
}

@Override
public void start(Stage arg) throws Exception {
	// TODO Auto-generated method stub
	Scene scene=new Scene(salepane());
	arg.setScene(scene);
	arg.show();
	
}
	
	

}
