import java.util.Scanner;
public class counter{
 public static void main(String args[]){
  int amt,r2000=0,r500=0,r200=0,r100=0,count=0;
  Scanner sc = new Scanner(System.in);
  System.out.println("Enter withdrawal amount :");
  amt = sc.nextInt();
  while (amt >= 2000){
  r2000 = amt / 2000;
  amt = amt % 2000;
  System.out.print("\nTwo Thousand :"+r2000);
  break;
  }
  while (amt >= 500){
  r500 = amt / 500;
  amt = amt % 500;
  System.out.print("\nFive Hundred :"+r500);
  break;
  }
  while (amt >= 200){
  r200 = amt / 200;
  amt = amt % 200;
  System.out.print("\nTwo Hundred :"+r200);
  break;
  }
  while (amt >= 100){
  r100 = amt / 100;
  amt = amt % 100;
  System.out.print("\nHundred :"+r100);
  break;
  }
  }
}