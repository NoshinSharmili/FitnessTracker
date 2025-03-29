import java.util.Scanner;

// BMI Calculator
public class BMICalculator {
    public static void calculateBMI() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your weight (kg): ");
        double weight = scanner.nextDouble();
        System.out.print("Enter your height (m): ");
        double height = scanner.nextDouble();
        double bmi = weight / (height * height);
        System.out.printf("Your BMI is: %.2f\n", bmi);

        if (bmi < 18.5) {
            System.out.println("You are underweight. Consider gaining weight in a healthy manner.");
        } else if (bmi >= 18.5 && bmi < 24.9) {
            System.out.println("You have a normal weight. Keep up the healthy lifestyle!");
        } else if (bmi >= 25 && bmi < 29.9) {
            System.out.println("You are overweight. Consider adopting a healthier diet and exercise routine.");
        } else {
            System.out.println("You are obese. It is recommended to consult a health professional for guidance.");
        }
    }
}
