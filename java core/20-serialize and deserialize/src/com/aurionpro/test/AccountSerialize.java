package com.aurionpro.test;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import com.aurionpro.model.Account;

public class AccountSerialize {
	public static void main(String args[]){    
		  try{  
			 Account acc = new Account(1,"rohit",200000) ;
			 FileOutputStream file =new FileOutputStream("D:\\java\\serial\\file.txt");    
			 ObjectOutputStream out=new ObjectOutputStream(file);  
			 out.writeObject(acc); 
			 out.close();    
			 file.close();
			 System.out.println("success");    
			  }catch(Exception e){
				  System.out.println(e);}    
			 }    
		  
		  

}
