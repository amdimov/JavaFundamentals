import java.util.Scanner;

public class MultiplyBigNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String bigNum = scanner.nextLine().replaceFirst("^0+", "");
        int multiplier = Integer.parseInt(scanner.nextLine());
        StringBuilder finalNum = new StringBuilder();
        int carry = 0;
        if (multiplier == 0){
            System.out.println(0);
            return;
        }
        for (int i = bigNum.length()-1; i >= 0 ; i--) {
            int getValueOfChar = Character.getNumericValue(bigNum.charAt(i));
            int resultOfChar = getValueOfChar * multiplier + carry;
            if (i == 0){
                finalNum.insert(0, resultOfChar);
            }else {
                int firstDigit = resultOfChar % 10;
                carry = resultOfChar / 10;
                finalNum.insert(0, firstDigit);
            }
        }
        System.out.println(finalNum);
    }
}
