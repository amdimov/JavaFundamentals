import java.text.DecimalFormat;
import java.util.Scanner;

public class FactorialDivision {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstFact = Integer.parseInt(scanner.nextLine());
        int secondFact = Integer.parseInt(scanner.nextLine());
        System.out.printf("%.2f", findAndDivideFactorial(firstFact, secondFact));

    }
    public static double findAndDivideFactorial(double first, double second){
        double divided;
        if (first != 0 && first != 1) {
            for (double i = first; i >= 1; i--) {
                if (i - 1 == 0) {
                    break;
                }
                first *= i - 1;
            }
        }else {
            first = 1;
        }
        if (second != 0 && second != 1) {
            for (double i = second; i >= 1; i--) {
                if (i - 1 == 0) {
                    break;
                }
                second *= i - 1;
            }
        }else {
            second = 1;
        }
        if (first >= second) {
            return divided = first / second;
        }else {
            return divided = second / first;
        }
        //System.out.printf("%.2f", divided);
    }
}
