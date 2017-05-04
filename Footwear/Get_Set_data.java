package Footwear;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.stream.FileImageInputStream;

public class Get_Set_data {
	public void setData(String [][] data) throws IOException{
		try(
				DataOutputStream output=new DataOutputStream(new FileOutputStream("inventoryfile.txt"));){
		for(int i=0;i<data.length;i++){
			for(int j=0;j<11;j++){
				output.writeUTF(data[i][j]);
			}
		}
		}catch(Exception e1){
			System.out.print("Error in setData");
		}

	}
	public static String getDataArray() throws FileNotFoundException, IOException {
		String str="";
		try(DataInputStream input=new DataInputStream(new FileInputStream("inventoryfile.txt"));){
			while(true){
				for(int j=0;j<11;j++){
					str+=input.readUTF()+"#";
				}
				str=str+"@";
			}
			
		}catch(Exception e1){
		System.out.print("Error in getData");
	}
	
	return str;
	

}
	public String setCodeNo(String codeno) throws FileNotFoundException, IOException{
		String str="";
		try(DataInputStream input=new DataInputStream(new FileInputStream("inventoryfile.txt"));){
			while(true){
				input.readUTF();
				if(codeno.equals(input.readUTF())){
					input.readUTF();
					input.readUTF();
					input.readUTF();
					input.readUTF();
					input.readUTF();
					input.readUTF();
					input.readUTF();
					str=input.readUTF();
					input.readUTF();
			
				
				}
			}
		}catch(Exception e1){
			System.out.print("Error in setCodeNO");
		}
		return str;
	}

	public boolean alreadyexit(String codeno) throws FileNotFoundException, IOException{
		boolean exit=false;
		try(DataInputStream input=new DataInputStream(new FileInputStream("inventoryfile.txt"));){
			while(true){
				input.readUTF();
				if(codeno.equals(input.readUTF())){
					exit=true;
					input.readUTF();
					input.readUTF();
					input.readUTF();
					input.readUTF();
					input.readUTF();
					input.readUTF();
					input.readUTF();
					input.readUTF();
					input.readUTF();
			
				
				}
			}
		}catch(Exception e1){
			System.out.print("Error in setCodeNO");
		}
		return exit;
	}
	public boolean exit(String date) throws FileNotFoundException, IOException{
		boolean exit=false;
		try(DataInputStream input=new DataInputStream(new FileInputStream("inventoryfile.txt"));){
			while(true){
				if(date.equals(input.readUTF()))
				{	exit=true;
					input.readUTF();
					input.readUTF();
					input.readUTF();
					input.readUTF();
					input.readUTF();
					input.readUTF();
					input.readUTF();
					input.readUTF();
					input.readUTF();
					input.readUTF();
				
				}
			}
		}catch(Exception e1){
			System.out.print("Error in exit");
		}
		return exit;
	}
}
