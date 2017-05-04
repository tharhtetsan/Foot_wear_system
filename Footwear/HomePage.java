package Footwear;

import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class HomePage extends Application{

	public static void main(String[] args) {
		launch(args);
	

	}

	@Override
	public void start(Stage stage) throws Exception {
		Image image=new Image("File:D:/Second Term/Project/photos/photo.jpg");
		Image image2=new Image("File:D:/Second Term/Project/photos/photo1.jpg");
		ImageView imageview=new ImageView(image);
		imageview.setFitHeight(70);
		imageview.setFitWidth(90);
		ImageView imageview1=new ImageView(image2);
		imageview1.setFitHeight(70);
		imageview1.setFitWidth(90);
		HBox panetop=new HBox(5); 
		Label name=new Label("Footwear Gallery");
		 name.setFont(Font.font("Courier New", FontWeight.BOLD, 35));
	     panetop.getChildren().addAll(imageview,name,imageview1);
		FlowPane paneFortitle = new FlowPane();
		paneFortitle.setAlignment(Pos.TOP_CENTER);
	    Hyperlink text=new Hyperlink("Welcome!!");
	    text.setFont(Font.font("Courier New", FontWeight.BOLD, 50));
	    paneFortitle.getChildren().addAll(panetop,text);
	    
		
	    BorderPane BTpane=new BorderPane();
	    BTpane.setTop(paneFortitle);
		
		BorderPane bpane=new BorderPane();
	

		Button items    =new Button("     Items Page      ");
		Button saleitem=new Button("Sale Item Page");
		Button remainitem   =new Button("Inventory Items Page");
		Button ordercustom=new Button("Customer Order");
		Button ordercompany=new Button("Company Order");
		HBox hbox=new HBox(5);
		hbox.getChildren().addAll(ordercustom,ordercompany,saleitem,remainitem,items);
		
		FlowPane pane=new FlowPane();
		pane.getChildren().add(paneFortitle);
		pane.setAlignment(Pos.CENTER);
		//bpane.setTop(hbox);
		bpane.setTop(pane);
		
		text.setOnAction(e->{
				bpane.getChildren().clear();
		    	//bpane.setTop(paneFortitle);
		    	bpane.setTop(hbox);
	    	
			
		});
			
			
			
			
			
			
			ordercompany.setOnAction(ordercom->{
				bpane.setTop(hbox);
				
				
				bpane.getChildren().clear();
		    	bpane.setTop(hbox);
		    	AddOrderPageCompany ordercompany1=new AddOrderPageCompany();
		    	bpane.setCenter(ordercompany1.PaneOrderAdd());
				
			});
			ordercustom.setOnAction(ordercust->{
				AddOrderPageCustomer ordercustomer1=new AddOrderPageCustomer();
				try {
					
					bpane.setCenter(ordercustomer1.PaneOrderAdd());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			});
			
		
		
    	items.setOnAction(e-> {
	    	bpane.getChildren().clear();
	    	bpane.setTop(hbox);
	    	ItemPage itemstable= new ItemPage();
	    	try {
				bpane.setCenter(itemstable.itempage());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			 });
    	/*balancesheet.setOnAction(e->{
    		bpane.getChildren().clear();
	    	bpane.setTop(hbox);
	    	ForBalanceSheet balance=new ForBalanceSheet();
			bpane.setLeft(balance.pane());
	    
    	});*/
    	remainitem.setOnAction(e->{
    	
	    	bpane.setTop(hbox);
	    	InventroyPage inventory=new InventroyPage();
    		try {
				bpane.setCenter(inventory.pane());
				
				
			} catch (NumberFormatException | IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    	});
		saleitem.setOnAction(e->{
			bpane.setTop(hbox);
	    	SaleItemPage sale=new SaleItemPage();
    		try {
				bpane.setCenter(sale.salepane());
				
			} catch (NumberFormatException | IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    
			
		});
	
		
		
		//BorderPane paneadd=new BorderPane();
		/*items.setOnAction(e->{
			//Stage stageadd=new Stage();
	
				BTpane.getChildren().clear();
				AddItemsPage itemstable= new AddItemsPage();
				BTpane.setTop(paneFortitle);
				BTpane.setCenter(description);
				BTpane.setLeft(BT1);
				description.setAlignment(itemstable.paneadditempage(),Pos.BASELINE_LEFT);
				
				
		});
	*/	
		/*balancesheet.setOnAction(e->{
			BTpane.getChildren().clear();
			ForBalanceSheet balance=new ForBalanceSheet();
			 BTpane.setTop(paneFortitle);
			BTpane.setCenter(description);
			description.getChildren().clear();
			description.setLeft(balance.pane());
		});
		remainitem.setOnAction(e->{
			BTpane.getChildren().clear();
			InventroyPage inventory=new InventroyPage();
			 BTpane.setTop(paneFortitle);
			BTpane.setCenter(description);
			description.getChildren().clear();
			try {
				description.setLeft(inventory.pane());
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		saleitem.setOnAction(e->{
			BTpane.getChildren().clear();
			SaleItemPage sale=new SaleItemPage();
			 BTpane.setTop(paneFortitle);
			BTpane.setCenter(description);
			description.getChildren().clear();
			try {
				description.setLeft(sale.salepane());
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		});
		*/
		Scene scene=new Scene(bpane,1600,700);
		stage.setScene(scene);
		stage.show();
	

		
	}

}
