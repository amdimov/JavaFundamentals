import java.util.Scanner;

public class VendingMachine7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String coingsInputString = "";
        double totalCoins = 0.0;
        double coins = 0.0;
        while (true){
            coingsInputString = scanner.nextLine().toLowerCase();
            if (coingsInputString.equals("start")){
                break;
            }else{
                coins = Double.parseDouble(coingsInputString);
            }
            if (coins == 0.1 || coins == 0.20 || coins == 0.50 || coins == 1 || coins == 2){
                totalCoins += coins;
            }else {
                System.out.printf("Cannot accept %.2f%n", coins);
            }
        }
        String productInput;

        double totalCost = 0.0;
        boolean checkTheProduct = false;
        while (true){
            double price = 0.0;
            productInput = scanner.nextLine();
            switch (productInput){
                case "Nuts":
                    price = 2.0;
                    checkTheProduct = true;
                    break;
                case "Water":
                    price = 0.70;
                    checkTheProduct = true;
                    break;
                case "Crisps":
                    price = 1.50;
                    checkTheProduct = true;
                    break;
                case "Soda":
                    price = 0.80;
                    checkTheProduct = true;
                    break;
                case "Coke":
                    price = 1;
                    checkTheProduct = true;
                    break;
            }
            totalCost += price;
            if (productInput.equals("End")){
                break;
            }
            if (totalCost > totalCoins){
                System.out.println("Sorry, not enough money");
                totalCost -= price;
            }else if (totalCoins >= totalCost && checkTheProduct){
                System.out.printf("Purchased %s%n", productInput);
            }else{
                System.out.println("Invalid product\n");
            }
        }
        System.out.printf("Change: %.2f%n", totalCoins - totalCost);
    }
}
