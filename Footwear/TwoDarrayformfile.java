package Footwear;

import java.io.FileNotFoundException;
import java.io.IOException;

public class TwoDarrayformfile {
	static String[][] InventoryData;
	static String[][] SaleData;
	//create 2darray of inventory data
	public static String[][] readInventorydata() throws FileNotFoundException, IOException 
	{
		
	
		String input = ReadDataFromFile.getInventoryArray();
		String[] AllInventoryData = input.split("@");

		InventoryData = new String[AllInventoryData.length][11];
		for (int i = 0; i <AllInventoryData.length; i++) {
			String line[] = AllInventoryData[i].split("#");
			for (int j = 0; j < 11; j++) {
				InventoryData[i][j] = line[j];
			}
		}
		return InventoryData;
	}
	//create 2darray of sale data
	public static String[][] readSaledata() throws FileNotFoundException, IOException 
	{
		
	
		String input = ReadDataFromFile.getSaleArray();
		String[] AllSaleData = input.split("!");

		SaleData = new String[AllSaleData.length][11];
		for (int i = 0; i <AllSaleData.length; i++) {
			String line[] = AllSaleData[i].split(",");
			for (int j = 0; j < 11; j++) {
				SaleData[i][j] = line[j];
			}
		}
		return SaleData;
	}
	public static void main(String[]args) throws FileNotFoundException, IOException{
		System.out.print(readInventorydata());
		System.out.print(readSaledata());
		
	}
	
}

