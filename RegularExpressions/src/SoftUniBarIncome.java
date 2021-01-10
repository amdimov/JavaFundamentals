import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SoftUniBarIncome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //^%(?<name>[A-Z][a-z]+)%([^<%|>$]*?)?<(?<product>\w+)>([^<%|>$]*?)?\|([^<%|>$]*?)?(?<quantity>[\d]+)([^<%|>$]*?)?\|([^<%|>$]*?)?(?<price>[\d]+[.]?[\d]*)\$$
        String regex = "^%(?<name>[A-Z][a-z]+)%([^%|$.]*)*?<(?<product>\\w+)>([^%|$.]*)*?\\|([^%|$.]*)*?(?<quantity>\\d+)([^%|$.]*)*?\\|([^%|$.]*)*?(?<price>[\\d]+\\.?\\d*)\\$$";
        String input = scanner.nextLine();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        double totalIncome = 0.0;
        while (!input.equals("end of shift")){
            if (matcher.find()){
                String name = matcher.group("name");
                String product = matcher.group("product");
                int quantity = Integer.parseInt(matcher.group("quantity"));
                double price = Double.parseDouble(matcher.group("price"));
                double income = (quantity * price);
                System.out.printf("%s: %s - %.2f%n",name, product,quantity * price);
                totalIncome += income;
            }
            input = scanner.nextLine();
            matcher = pattern.matcher(input);
        }
        System.out.printf("Total income: %.2f", totalIncome);
    }
}
