import java.util.Scanner;
import java.text.DecimalFormat;
class Currency_Convert{
 public static void main(String[] args){
 double rupee,dollar,euro,option;
 DecimalFormat f = new DecimalFormat("##.##");
	Scanner sc = new Scanner(System.in);
	System.out.println("\nEnter the option\n1:Rupees\n2:Dollar\n3:Euro\n"); 
	option=sc.nextInt();
	if(option == 1)
	{
	System.out.println("Enter amount in rupees:");
	rupee = sc.nextFloat();
	dollar = rupee / 82;
	System.out.println("Dollar : "+f.format(dollar));
	euro = rupee / 89;
	System.out.println("Euro : "+f.format(euro));
	}
	else if (option == 2)
	{
	System.out.println("Enter amount in dollar:");
	dollar = sc.nextFloat();
	rupee = dollar * 82;
	System.out.println("Rupees : "+f.format(rupee));
	euro = dollar * 0.91;
	System.out.println("Euro : "+f.format(euro));
	}
	else if(option == 3)
	{
	System.out.println("Enter amount in Euro:");
	euro = sc.nextFloat();
	rupee = euro * 89;
	System.out.println("Rupees : "+f.format(rupee));
	dollar = euro * 1.09;
	System.out.println("Dollar : "+f.format(dollar));
	}
	else
		System.out.println("Invalid Code!");
	}
}