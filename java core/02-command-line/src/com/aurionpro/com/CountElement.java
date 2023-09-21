package com.aurionpro.com;

public class CountElement {

	public static void main(String[] args) {
    int sum=0,c=0;
	for (int i = 0; i < args.length; i++) {
		for (int j = 0; j < args.length; j++) {
			
			if(Integer.parseInt(args[i]) == Integer.parseInt(args[i])){
			c++;
			sum=c;
			}
		}
	System.out.println(sum);
		
		}
	}
	

}
