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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class AddOrderPageCustomer extends Application {
	static StringBuilder str=new StringBuilder();
	static double sum=0;
	static String[] Categories = { "Athletic Shoes", "Boots", "Casual Shoes", "Dress Shoes", "Sandals", "Slippers" };
	static String[] maxnum = { "41" };
	static String[] mininum = { "35" };
	static Label lbmini = new Label();
	static Label lbmax = new Label();
	static Label lbcat = new Label();
	static String Stcolor;
	static TextField tfqty = new TextField();
	static String ordervalue;
	static String[] updateinventory=new String[11];

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
		Label quantity = new Label("Qunatity:");
		TextField tfbrand = new TextField();
		DatePicker pickDate=new DatePicker();
		
		
		
		
		VBox lbbox = new VBox(21);
		lbbox.getChildren().addAll(getDate,codeNo, category, brand, color,  quantity);

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
		tfbox.getChildren().addAll(pickDate,tfcodeno, categorybox, tfbrand, colorbox,  tfqty);
		Black.setOnAction(e->{
			Black.isSelected();
			Stcolor = "Black";
		});
		White.setOnAction(e->{
			White.isSelected();
			Stcolor = "White";
		});
		//Brown.setOnAction(e->
		Brown.setOnAction(e->{
			Brown.isSelected();
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
			Stcolor="Other";
		});
		Button calculate = new Button("Calculate");
		Button reset = new Button("Reset");
		HBox button = new HBox(5);
		button.getChildren().addAll(calculate, reset);
		pane.add(lbbox, 0, 0);
		pane.add(tfbox, 1, 0);
		pane.add(button, 0, 1);
		
		FlowPane pane1=new FlowPane();
		pane1.getChildren().add(pane);
		pane1.setAlignment(Pos.TOP_LEFT);
		pane1.setOrientation(Orientation.HORIZONTAL);
		reset.setOnAction(e->{
			tfcodeno.clear();
			tfbrand.clear();
			tfqty.clear();
		});
	//for add data to inventory or sale data
		String[] Sale=new String[11];
		calculate.setOnAction(e->{
			
			pane1.setAlignment(Pos.TOP_LEFT);
			pane1.setOrientation(Orientation.HORIZONTAL);
			try {
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
							int amount=Integer.parseInt(InventoryData[i][9])-Integer.parseInt(tfqty.getText().toString().trim());
							System.out.println(amount);
							InventoryData[i][9]=amount+"";
							
						}
							
					}
					gsdata.setData(InventoryData);
					
					
				}else{
					JOptionPane.showMessageDialog(null, "Invalid","Invalid items",0);
				} 
				
				
				String resultInventorydata[][]=TwoDarrayformfile.readInventorydata();
					for(int i=0;i<resultInventorydata.length;i++){
				if(resultInventorydata[i][1].equals(tfcodeno.getText())&&resultInventorydata[i][2].equals(DisplayCat(categories.indexOf(categorybox.getValue())))&&resultInventorydata[i][3].equals(tfbrand.getText()))
				{
					int oriqty=Integer.parseInt(resultInventorydata[i][9]);
					int saleqty=Integer.parseInt(tfqty.getText());
						if(oriqty>saleqty)
						{
							Sale[0]=pickDate.getValue().toString();
							Sale[1]=resultInventorydata[i][1];
							Sale[2]=resultInventorydata[i][2];
							Sale[3]=resultInventorydata[i][3];
							Sale[4]=resultInventorydata[i][4];
							Sale[5]=resultInventorydata[i][5];
							Sale[6]=resultInventorydata[i][6];
							Sale[7]=resultInventorydata[i][7];
							Sale[8]=resultInventorydata[i][8];
							Sale[9]=tfqty.getText();
							Sale[10]=resultInventorydata[i][10];
							System.out.print(Sale[8]);
							String charge=Double.toString(Double.parseDouble(Sale[8])*Integer.parseInt(Sale[9]));
							str.append(Sale[0]+"\t\t\t\t"+Sale[1]+"\t\t\t\t"+Sale[2]+"\t\t\t"+Sale[8]+"\t\t\t"+Sale[9]+"\t\t\t"+charge+"\n");
							sum=sum+Double.parseDouble(charge);
					
						}DataOutputStream output = new DataOutputStream(new FileOutputStream("salefile.txt", true));

					for (int k = 0; k < 11; k++) {
						output.writeUTF(Sale[k]);
					
						System.out.print(Sale[k]);
					}
					output.close();
				}
				
				
					
			}		
					
		
					
			}catch(NullPointerException e1){
				JOptionPane.showMessageDialog(null, "Invalid","Invalid items",0);
			}
			catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			
});
		/*BalanceSheet balance=new BalanceSheet();
		pane1.getChildren().add(balance.balancesheetpane())	;
		//pane1.getChildren().clear();
		*/
		
		
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
