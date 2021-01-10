import java.util.Scanner;

public class ZigZagArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        int[] arrayOne = new int[n];
        int[] arrayTwo = new int[n];
        
        String line;

        for (int i = 0; i < n; i++) {
            line = scanner.nextLine();
            String[] lineToArray = line.split("\\s+");
            //Shorted solution would --- String[] line = scanner.nextLine().split("\\s+");
            //Then it won't be necessary to create new variable

            if (i % 2 == 0){
                arrayOne[i] = Integer.parseInt(lineToArray[0]);
                arrayTwo[i] = Integer.parseInt(lineToArray[1]);
            }else{
                arrayOne[i] = Integer.parseInt(lineToArray[1]);
                arrayTwo[i] = Integer.parseInt(lineToArray[0]);
            }
        }

        for (int arrayOneLine :
                arrayOne) {
            System.out.print(arrayOneLine + " ");
        }
        System.out.println();

        for (int arrayTwoLine :
                arrayTwo) {
            System.out.print(arrayTwoLine + " ");
        }
    }
}
