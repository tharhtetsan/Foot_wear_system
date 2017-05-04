package Footwear;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ForRetailCustomer extends Application{
	static String[] resultretail =null;
	static double sum=0;
	static List<Retail> balance=new ArrayList<>();
	static ObservableList<Retail> list;
	static StringBuilder str=new StringBuilder();
	public static FlowPane RetailPane(){
	Label Date=new Label("Date");
	Label codeno=new Label("Code Number");
	Label brand=new Label("Brand");
	Label quantity=new Label("Quantity");
	DatePicker pickDate=new DatePicker();
	TextField tfcodeno=new TextField();
	TextField tfbrand=new TextField();
	TextField tfquantity=new TextField();
	VBox lbpane=new VBox(16);
	lbpane.getChildren().addAll(Date,codeno,brand,quantity);
	VBox tfpane=new VBox(5);
	tfpane.getChildren().addAll(pickDate,tfcodeno,tfbrand,tfquantity);
	Button add=new Button(" Add ");
	Button reset=new Button("Reset");
	GridPane pane=new GridPane();
	pane.setHgap(5);
	pane.setVgap(5);
	pane.add(lbpane, 0, 0);
	pane.add(tfpane, 1, 0);
	pane.add(add, 0, 1);pane.add(reset, 1, 1);
	
	FlowPane paneall=new FlowPane();
	paneall.getChildren().add(pane);
	paneall.setAlignment(Pos.CENTER);
	
	add.setOnAction(e->{
		try {
		String resultInventorydata[][]=TwoDarrayformfile.readInventorydata();
		
		for (int i = 0; i < InventroyPage.InventoryData.size(); i++){
			
			if(resultInventorydata[i][1].equals(tfcodeno.getText())){
				/*balance.add(new Retail(pickDate.getValue().toString(),
						InventroyPage.InventoryData.get(i).getCodeno(),
						InventroyPage.InventoryData.get(i).getBrand(),
						InventroyPage.InventoryData.get(i).getSaleprice(),
						tfquantity.getText(),Double.toString(Double.parseDouble(resultretail[3])*Integer.parseInt(resultretail[4]))));*/
				resultretail[0]=pickDate.getValue().toString();
				resultretail[1]=resultInventorydata[i][1];
				resultretail[2]=resultInventorydata[i][2];
				resultretail[3]=resultInventorydata[i][3];
				resultretail[4]=resultInventorydata[i][4];
				resultretail[5]=resultInventorydata[i][5];
				resultretail[6]=resultInventorydata[i][6];
				resultretail[7]=resultInventorydata[i][7];
				resultretail[8]=resultInventorydata[i][8];
				resultretail[9]=tfquantity.getText();
				resultretail[10]=resultInventorydata[i][10];
				
				
				resultretail[0]=pickDate.getValue().toString();
				resultretail[1]=InventroyPage.InventoryData.get(i).getCodeno();
				resultretail[2]=InventroyPage.InventoryData.get(i).getBrand();
				resultretail[3]=InventroyPage.InventoryData.get(i).getSaleprice();
				resultretail[4]=tfquantity.getText();
				resultretail[5]=Double.toString(Double.parseDouble(resultretail[3])*Integer.parseInt(resultretail[4]));
				
				
				
			}
			str.append(resultretail[0]+"\t\t\t\t"+resultretail[1]+"\t\t\t\t"+resultretail[2]+"\t\t\t"+resultretail[3]+"\t\t\t"+resultretail[4]+"\t\t\t"+resultretail[5]+"\n");
				sum=sum+Double.parseDouble(resultretail[3])*Integer.parseInt(resultretail[4]);
				System.out.print(resultretail);
		}//end of for
		
	
		
		
		System.out.print(str);
		list= FXCollections.observableArrayList(balance);
		paneall.getChildren().add(RetailTable.Retail_Table());
		}//end of try
		catch (IOException e2) {
			e2.printStackTrace();
		}
	});
	reset.setOnAction(e->{
		tfcodeno.clear();
		tfbrand.clear();
		tfquantity.clear();
	});
	return paneall;
	}
public static void main(String[]args){
	launch(args);
}
@Override
public void start(Stage arg) throws Exception {
	Scene scene=new Scene(RetailPane());
	arg.setScene(scene);
	arg.show();
	
}
}
