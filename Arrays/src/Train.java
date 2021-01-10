import java.util.Scanner;

public class Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] wagon = new int[Integer.parseInt(scanner.nextLine())];
        int sum = 0;
        for (int i = 0; i < wagon.length; i++) {
            wagon[i] = Integer.parseInt(scanner.nextLine());
            sum += wagon[i];
        }

        for (int wagons : wagon) {
            System.out.print(wagons + " ");
        }
        System.out.println();
        System.out.println(sum);
    }
}
