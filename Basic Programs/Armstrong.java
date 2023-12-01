import java.util.Scanner;
public class Armstrong {
    public static void main(String[] args) {
        int number, temp, remainder, result = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number");
	    number = sc.nextInt();
        temp = number;
        while (temp != 0)
        {
            remainder = temp % 10;
            result += Math.pow(remainder, 3);
            temp = temp / 10;
        }
        if(result == number){
            System.out.println(number + " is an Armstrong number.");
			}
        else{
            System.out.println(number + " is not an Armstrong number.");
			}
    }
}