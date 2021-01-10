import java.util.Scanner;

public class CommonElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input1 = scanner.nextLine();
        String input2 = scanner.nextLine();

        String[] input1ToArray = input1.split("\\s+");
        String[] input2ToArray = input2.split("\\s+");
        String[] commonElements = new String[input2ToArray.length];

        int counter = 0;

        for (int i = 0; i < input2ToArray.length; i++) {
            for (int j = 0; j < input1ToArray.length; j++) {
                if (input2ToArray[i].equals(input1ToArray[j])){
                    commonElements[counter] = input2ToArray[i];
                    counter++;
                }
            }
        }

        //This is second solution by making new array.
        //The original and required solution is by just printing the equal number
        for (String common :
                commonElements) {
            if (common != null)
            System.out.print(common + " ");
        }

    }
}
