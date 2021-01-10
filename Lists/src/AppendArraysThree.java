import java.util.Scanner;

public class AppendArraysThree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputString = scanner.nextLine().split("\\|");
        String result = "";
        for (int i = inputString.length-1; i >= 0; i--) {
            String[] currentArray = inputString[i].split("\\s+");
            for (int j = 0; j < currentArray.length; j++) {
                if (!currentArray[j].equals(""))
                result += currentArray[j] + " ";
            }
        }
        result = result.trim();
        System.out.println(result);


    }
}
