import java.util.Scanner;

public class StrongNumber6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int factNum = Integer.parseInt(input);
        int factorial = 0;
        int charSwap = 0;
        for (int i = 0; i < input.length(); i++) {
            charSwap = Character.getNumericValue(input.charAt(i));
            for (int j = charSwap; j >= 2; j--) {
                charSwap *= j-1;
            }
            if (!(charSwap == 0)) {
                factorial += charSwap;
            }else {
                factorial++;
            }
        }

        if (factorial == factNum){
            System.out.println("yes");
        }else {
            System.out.println("no");
        }

    }
}
