import java.io.InputStream;
import java.util.Scanner;

public class AddAndSubtractWithObject {
    public static void main(String[] args) {
        addAndSubtractPrinter(System.in);
    }

    public static void addAndSubtractPrinter(InputStream system){
        Scanner scanner = new Scanner(system);
        int first = Integer.parseInt(scanner.nextLine());
        int second = Integer.parseInt(scanner.nextLine());
        int subtractor = Integer.parseInt(scanner.nextLine());

        System.out.println(addAndSubtractInt(first, second, subtractor));
    }
    public static int addAndSubtractInt(int first, int second, int subtractor){
        return (first + second) - subtractor;
    }
}
