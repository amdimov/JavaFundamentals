import java.util.Scanner;

public class ComputerStore {
    //https://judge.softuni.bg/Contests/Practice/Index/2517#0
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        double totalCostWithoutVat = 0;
        double totalCost = 0;
        double vatTax = 0;
        while (!input.equals("special") && !input.equals("regular")){
            double currentValue = Double.parseDouble(input);
            if (currentValue > 0){
                totalCostWithoutVat += currentValue;
            }else {
                System.out.println("Invalid price!");
            }
            input = scanner.nextLine();
        }

        if (input.equals("special")){
            vatTax = (double)totalCostWithoutVat*0.20;
            totalCost = totalCostWithoutVat + vatTax;
            totalCost *= 0.90;
        }else{
            vatTax = (double)totalCostWithoutVat*0.20;
            totalCost = totalCostWithoutVat + vatTax;
        }

        if (totalCostWithoutVat > 0){
            System.out.println("Congratulations you've just bought a new computer!");
            System.out.printf("Price without taxes: %.2f$%n", totalCostWithoutVat);
            System.out.printf("Taxes: %.2f$%n", vatTax);
            System.out.println("-----------");
            System.out.printf("Total price: %.2f$%n", totalCost);
        }else{
            System.out.println("Invalid order!");
        }
    }
}
