
public class BMICalculator {


	private int bmi;

	public double calculateBMI(Person peron) {S
		double bmi = calculateBMI(weight, height);
		return weight / (height * height);
	}

	public static String BodyType(Person person) {         
		if (bmi < 18.5) {
        return "Underweight";         
        } 
	else if (bmi >= 18.5 && bmi < 25) {
        return "Normal weight";         
        } 
	else if (bmi >= 25 && bmi < 30) {
        return "Overweight";         
        } 
	else {
        return "Obese";         
        }

  }
}
