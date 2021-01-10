import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//https://regex101.com/r/BHN1mw/2
public class Furniture {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String regex = ">>(?<furniture>[A-Za-z]+)<<(?<price>[\\d]+\\.?[\\d]+)!(?<quantity>[\\d]+)";
        Pattern pattern = Pattern.compile(regex);
        String text = scanner.nextLine();
        double totalCost = 0.0;
        List<String> listOfFurniture = new ArrayList<>();
        while (!text.equals("Purchase")){

            Matcher matcher = pattern.matcher(text);
            if (matcher.find()) {
                double currentPrice = Double.parseDouble(matcher.group("price"));
                int currentQuantity = Integer.parseInt(matcher.group("quantity"));
                totalCost += currentPrice * currentQuantity;
                listOfFurniture.add(matcher.group("furniture"));
                //System.out.println(matcher.group("furniture") + ": " + totalCost);
            }
            text = scanner.nextLine();
        }
        System.out.println("Bought furniture:");
        for (String n :
                listOfFurniture) {
            System.out.println(n);
        }
        System.out.printf("Total money spend: %.2f", totalCost);




    }
}
