import java.util.Scanner;

public class TopNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = Integer.parseInt(scanner.nextLine());
        findTopNumber(input);
    }
    public static void findTopNumber(int num){
        for (int i = 1; i <= num; i++) {
            if (checkIfContainsOddNum(i) && checkIfDigDivisibleOfEight(i)){
                System.out.println(i);
            }
        }
    }
    public static boolean checkIfDigDivisibleOfEight(int num){
        String numToString = Integer.toString(num);
        int indexholder;
        int sumOfDigits = 0;
        for (int i = 0; i < numToString.length(); i++) {
            indexholder = Character.getNumericValue(numToString.charAt(i));
            sumOfDigits += indexholder;
        }
        if (sumOfDigits % 8 ==0){
            return true;
        }
        return false;
    }
    public static boolean checkIfContainsOddNum(int num){
        String numToString = Integer.toString(num);
        int indexholder;
        for (int i = 0; i < numToString.length(); i++) {
            indexholder = Character.getNumericValue(numToString.charAt(i));
            if (indexholder % 2 != 0){
                return true;
            }
        }
        return false;
    }
}
