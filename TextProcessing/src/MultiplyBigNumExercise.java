import java.util.Scanner;

public class MultiplyBigNumExercise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String bigNum = scanner.nextLine().replaceFirst("^0+", "");
        int multiplier = Integer.parseInt(scanner.nextLine());

        if (multiplier == 0){
            System.out.println(0);
            return;
        }
        StringBuilder result = new StringBuilder();

        int carry = 0;

        for (int i = bigNum.length()-1; i >= 0; i--) {
            int getValueOfChar = Character.getNumericValue(bigNum.charAt(i));
            int tempResult = getValueOfChar * multiplier + carry;

            if (i == 0){
                result.insert(0, tempResult);
            }else{
                int firstDigit = tempResult % 10;
                carry = tempResult / 10;
                result.insert(0, firstDigit);
            }
        }
        System.out.println(result);
    }
}
