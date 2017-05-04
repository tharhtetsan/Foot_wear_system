package Footwear;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Test {
	public static void main(String[]args) throws FileNotFoundException, IOException{
		
		String s="LL-1";
		Get_Set_data getdata=new Get_Set_data();
		if(getdata.alreadyexit(s)){
			String input=getdata.getDataArray();
			String[] AllInventoryData = input.split("@");
			
		String[][]	InventoryData = new String[AllInventoryData.length][11];
			for (int i = 0; i <AllInventoryData.length; i++) {
				String line[] = AllInventoryData[i].split("#");
				for (int j = 0; j < 11; j++) {
					InventoryData[i][j] = line[j];
				}
			}
			for(int i=0;i<InventoryData.length;i++){
				if(InventoryData[i][1].equals(s)){
					int amount=Integer.parseInt(getdata.setCodeNo(s).toString().trim())+Integer.parseInt(InventoryData[i][10]);
					InventoryData[i][10]=amount+"";
					
				}
					
			}
			getdata.setData(InventoryData);
		System.out.print(getdata.setCodeNo(s));
	}

	}}

