package Footwear;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JOptionPane;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AddOrderPageCompany extends Application {
	static String[] Categories = { "Athletic Shoes", "Boots", "Casual Shoes", "Dress Shoes", "Sandals", "Slippers" };
	static String[] maxnum = { "41" };
	static String[] mininum = {"35" };
	static Label lbmini = new Label();
	static Label lbmax = new Label();
	static Label lbcat = new Label();
	static String Stcolor;
	static TextField tfqty = new TextField();
	static TextField tforiginal = new TextField();
	static String ordervalue;
	static String[] Inventory=new String[11];

public static FlowPane PaneOrderAdd() {

		
		GridPane pane = new GridPane();
		pane.setHgap(5);
		pane.setVgap(5);
		Label getDate=new Label("Date");
		Label codeNo = new Label("Code Number:");
		TextField tfcodeno = new TextField();
		Label category = new Label("Category:");
		Label brand = new Label("Brand:");
		Label size = new Label("Size:");
		Label color = new Label("Color:");
		Label originalprice = new Label("Original Price:");
		Label quantity = new Label("Qunatity:");
		TextField tfbrand = new TextField();
		DatePicker pickDate=new DatePicker();
		
		
		
		
		VBox lbbox = new VBox(21);
		lbbox.getChildren().addAll(getDate,codeNo, category, brand, size, color, originalprice, quantity);

		ComboBox<String> categorybox = new ComboBox<>();
		categorybox.setPrefWidth(200);
		categorybox.setValue("Athletic Shoes");
		ObservableList<String> categories = FXCollections.observableArrayList(Categories);
		categorybox.getItems().addAll(categories);
		categorybox.setOnAction(e -> DisplayCat(categories.indexOf(categorybox.getValue())));

		ComboBox<String> minibox = new ComboBox<>();
		ObservableList<String> sizemini = FXCollections.observableArrayList(mininum);
		minibox.getItems().addAll(sizemini);
		minibox.setOnAction(e -> Displaymininum(sizemini.indexOf(minibox.getValue())));
		//minibox.setValue("25");

		ComboBox<String> maxbox = new ComboBox<>();
		ObservableList<String> sizemax = FXCollections.observableArrayList(maxnum);
		maxbox.getItems().addAll(sizemax);
		maxbox.setOnAction(e -> Displaymax(sizemax.indexOf(maxbox.getValue())));
		//maxbox.setValue("40");

		HBox Size = new HBox(5);
		Size.getChildren().addAll(minibox, maxbox);
		HBox colorbox1 = new HBox(10);
		RadioButton Black = new RadioButton("Black");
		RadioButton White = new RadioButton("White");
		RadioButton Brown = new RadioButton("Brown");
		colorbox1.getChildren().addAll(Black, White, Brown);
		HBox colorbox2 = new HBox(10);
		RadioButton Gray = new RadioButton("Gray");
		RadioButton Red = new RadioButton("Red");
		RadioButton other = new RadioButton("Other");
		colorbox2.getChildren().addAll(Gray, Red, other);
		VBox colorbox = new VBox(5);
		colorbox.getChildren().addAll(colorbox1, colorbox2);
		ToggleGroup group = new ToggleGroup();
		Black.setToggleGroup(group);
		White.setToggleGroup(group);
		Brown.setToggleGroup(group);
		Gray.setToggleGroup(group);
		Red.setToggleGroup(group);
		VBox tfbox = new VBox(10);
		tfbox.getChildren().addAll(pickDate,tfcodeno, categorybox, tfbrand, Size, colorbox, tforiginal, tfqty);
		Black.setOnAction(e->{
			if (Black.isSelected())
			Stcolor = "Black";
		});
		White.setOnAction(e->{
			if (White.isSelected())
			Stcolor = "White";
		});
		//Brown.setOnAction(e->
		Brown.setOnAction(e->{
			if (Brown.isSelected())
			Stcolor = "Brown";
		});
		Gray.setOnAction(e->{
			Gray.isSelected();
			Stcolor = "Gray";
		});
		Red.setOnAction(e->{
			Red.isSelected();
			Stcolor = "Red";
		});
		other.setOnAction(e->{
			other.isSelected();
			Stcolor="Red";
		});
		Button add = new Button("Add");
		Button reset = new Button("Reset");
		HBox button = new HBox(5);
		button.getChildren().addAll(add, reset);
		pane.add(lbbox, 0, 0);
		pane.add(tfbox, 1, 0);
		pane.add(button, 0, 1);
		
		FlowPane pane1=new FlowPane();
		pane1.getChildren().add(pane);
		pane1.setAlignment(Pos.TOP_LEFT);
		pane1.setOrientation(Orientation.HORIZONTAL);
		
	//for add data to inventory or sale data
		reset.setOnAction(e->{
			tfcodeno.clear();
			tfbrand.clear();
			tforiginal.clear();
			tfqty.clear();
			
		});
		add.setOnAction(e->{
		try{
			Get_Set_data gsdata=new Get_Set_data();
			if(gsdata.alreadyexit(tfcodeno.getText())){
				String input=gsdata.getDataArray();
				String[] AllInventoryData = input.split("@");
				System.out.println(AllInventoryData.length);
			String[][]	InventoryData = new String[AllInventoryData.length][11];
				for (int i = 0; i <AllInventoryData.length; i++) {
					String line[] = AllInventoryData[i].split("#");
					for (int j = 0; j < 11; j++) {
						InventoryData[i][j] = line[j];
					}
				}
				for(int i=0;i<AllInventoryData.length;i++){
					if(InventoryData[i][1].equals(tfcodeno.getText())){
						int amount=Integer.parseInt(tfqty.getText().toString().trim())+Integer.parseInt(InventoryData[i][9]);
						System.out.println(amount);
						InventoryData[i][9]=amount+"";
						
					}
						
				}
				gsdata.setData(InventoryData);
				
				
			}else{
			Inventory[0]=pickDate.getValue().toString();
			Inventory[1]=tfcodeno.getText();
			Inventory[2]=DisplayCat(categories.indexOf(categorybox.getValue()));
			Inventory[3]=tfbrand.getText();
			Inventory[4]=Displaymininum(sizemini.indexOf(minibox.getValue()));
			Inventory[5]=Displaymax(sizemax.indexOf(maxbox.getValue()));
			Inventory[6]=Stcolor;
			Inventory[7]=tforiginal.getText();
			Inventory[8]=Double.toString(saleprice(Double.parseDouble(tforiginal.getText())));
			Inventory[9]=tfqty.getText();
			Inventory[10]=Double.toString(profitPrice(Double.parseDouble(tforiginal.getText())));
			
	
				DataOutputStream output = new DataOutputStream(new FileOutputStream("inventoryfile.txt", true));

				for (int i = 0; i < 11; i++) {
					output.writeUTF(Inventory[i]);
				
				}
				output.close();
			}
			}catch(NullPointerException e1){
				JOptionPane.showMessageDialog(null, "Invalid","Invalid items",0);
			}
		catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
});
		
		return pane1;
}

	

public static void main(String[]args){
	launch(args);
}
private static String Displaymininum(int indexOf) {
	// TODO Auto-generated method stub
	lbmini.setText(mininum[indexOf]);
	return lbmini.getText();
}

private static String Displaymax(int indexOf) {
	// TODO Auto-generated method stub
	lbmax.setText(maxnum[indexOf]);
	return lbmax.getText();
}

private static String DisplayCat(int indexOf) {
	// TODO Auto-generated method stub
	lbcat.setText(Categories[indexOf]);
	return lbcat.getText();
}
@Override
public void start(Stage arg1) throws Exception {
	Scene scene=new Scene(PaneOrderAdd());
	arg1.setScene(scene);
	arg1.show();
	
}
public static double saleprice(double origin) {
	double sale;
	sale = origin + (origin * 20 / 100);

	return sale;
}
private static double profitPrice(double parseDouble) {
	// TODO Auto-generated method stub
	double profit=parseDouble* 20/100;
	return profit;
}

}
