import java.util.Scanner;

public class TopIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        int leftHolder;
        int rightHolder;
        int bestNum = Integer.MIN_VALUE;
        for (int i = 0; i < input.length; i++) {
            leftHolder = Integer.parseInt(input[i]);
            if (i != input.length-1) {
                rightHolder = Integer.parseInt(input[i + 1]);
            }else {
                rightHolder = 0;
            }
            if (leftHolder > rightHolder){
                System.out.print(leftHolder + " ");
            }
        }
    }
}
