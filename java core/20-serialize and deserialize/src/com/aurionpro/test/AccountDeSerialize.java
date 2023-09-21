package com.aurionpro.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.aurionpro.model.Account;

public class AccountDeSerialize {
	public static void main(String args[]){    
		try {
			 FileInputStream file=new FileInputStream("D:\\java\\serial\\file.txt");
			 ObjectInputStream in= new ObjectInputStream(file);
			 Account acc=(Account)in.readObject();
			 System.out.println(acc);
			 in.close();
			 file.close();
			 }
			 catch(Exception e){
			  e.printStackTrace();
			  
			 }
	}
}
