package Footwear;

import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class BalanceSheet {
	public VBox balancesheetpane(){
	Label Date=new Label("Date");
	Label CodeNo1=new Label("Code Number");
	Label brand1=new Label("Brand");
	Label saleprice=new Label("Price");
	Label qty=new Label("Quantity");
	Label charge=new Label("Kyats");
	Date.setFont(new Font(15));
	CodeNo1.setFont(new Font(15));
	brand1.setFont(new Font(15));
	saleprice.setFont(new Font(15));
	charge.setFont(new Font(15));
	qty.setFont(new Font(15));
	HBox box=new HBox(55);
	box.setStyle("-fx-background-color: lightblue");
	box.getChildren().addAll(Date,CodeNo1,brand1,saleprice,qty,charge);
	TextArea txtArea=new TextArea();
	txtArea.setText(""+AddOrderPageCustomer.str);
	
	Label total=new Label("Total");TextField tftotal=new TextField();tftotal.setText(Double.toString(AddOrderPageCustomer.sum));
	Label payment=new Label("Payment");TextField tfpayment=new TextField();
	Label refund=new Label("Refund");TextField tfrefund=new TextField();
	VBox Vbox=new VBox();
	GridPane bottonpane=new GridPane();
	bottonpane.add(total, 0, 0);bottonpane.add(tftotal, 1, 0);	
	bottonpane.add(payment, 0, 1);bottonpane.add(tfpayment, 1, 1);
	tfpayment.setOnAction(et->{
		tfrefund.setText(Double.toString((Double.parseDouble(tfpayment.getText())-AddOrderPageCustomer.sum)));
		bottonpane.add(refund, 0, 2);bottonpane.add(tfrefund, 1, 2);
	});
	
	
	//Pane panepay=new Pane();
	Vbox.getChildren().addAll(box,txtArea,bottonpane);
	return Vbox;
	}

}
