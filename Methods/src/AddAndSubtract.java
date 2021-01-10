import java.util.Scanner;

public class AddAndSubtract {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        addAndSubtractPrinter(scanner);

    }

    public static void addAndSubtractPrinter(Scanner scanner){
        int first = Integer.parseInt(scanner.nextLine());
        int second = Integer.parseInt(scanner.nextLine());
        int subtractor = Integer.parseInt(scanner.nextLine());

        System.out.println(addAndSubtractInt(first, second, subtractor));
    }
    public static int addAndSubtractInt(int first, int second, int subtractor){
        return (first + second) - subtractor;
    }
}
