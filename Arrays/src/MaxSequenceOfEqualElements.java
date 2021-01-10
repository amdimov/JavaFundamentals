import javax.swing.plaf.IconUIResource;
import java.util.Arrays;
import java.util.Scanner;

public class MaxSequenceOfEqualElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] input = Arrays.stream(scanner.nextLine().split("\\s")).mapToInt(e->Integer.parseInt(e)).toArray();

        int maxSequence = 0;
        int firstIndex = 0;
        for (int i = 0; i < input.length; i++) {
            int counter = 0;
            for (int j = i; j < input.length; j++) {
                if (input[i] == input[j]){
                    counter++;
                    if (counter > maxSequence){
                        firstIndex = i;
                        maxSequence = counter;
                    }
                }else {
                    break;
                }
            }
        }

        for (int i = firstIndex; i < maxSequence + firstIndex; i++) {
            System.out.print(input[i] + " ");
        }
    }
}
