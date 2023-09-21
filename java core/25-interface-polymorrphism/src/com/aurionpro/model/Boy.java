package com.aurionpro.model;

public class Boy implements IMannerable, IEmotionable{


	 @Override
	  public void welcomeGreet() {   
		 System.out.println("welcomeGreet");
	     }
	  @Override
	  public void departGreet() {   
		  System.out.println("departGreet");
	     }
	  @Override
	  public void laugh() {  

		  System.out.println("laugh");
	  }
	  @Override
	  public void cry() {

		  System.out.println("cry");
	  }
}
