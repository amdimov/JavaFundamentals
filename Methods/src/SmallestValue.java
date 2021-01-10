import java.util.Scanner;

public class SmallestValue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        int c = Integer.parseInt(scanner.nextLine());

        getSmallInt(a, b, c);
    }

    public static void getSmallInt(int firstValue, int secondValue, int thirdValue){
        int smallestValue;
        if (firstValue > secondValue){
            smallestValue = secondValue;
        }else {
            smallestValue = firstValue;
        }
        if (smallestValue > thirdValue){
            smallestValue = thirdValue;
        }

        System.out.println(smallestValue);
    }
}
