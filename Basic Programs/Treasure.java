import java.util.Scanner;
class Treasure{
 public static void main (String [] args){

  Scanner sc = new Scanner(System.in);
  
  System.out.println("Enter Left or Right");
  String leftRight = sc.nextLine();
  if(leftRight.equalsIgnoreCase("left")){
	  System.out.println("Enter Swin or Wait");
      String swimWait = sc.nextLine();
	  if(swimWait.equalsIgnoreCase("Wait")){
      System.out.println("Enter red , yellow or blue");
      String whichDoor = sc.nextLine();
		  switch(whichDoor){
		  case "red":
            System.out.println("eaten by beast game over");
            break;
      case "yellow":
			      System.out.println("You win");
            break;
      case "blue":
            System.out.println("burned by fire game over");
            break;
			default:
			       System.out.println("invalid");
		        };
          }
	  else{	  
        System.out.println("Attacked by trout Game Over.");
        }
      }
  else{	  
   System.out.println("Fall into a hole Game Over");
   }
 }  
}
