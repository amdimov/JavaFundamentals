import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FancyBarcodes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String regexBarcode = "^@[#]+[A-Z][A-Za-z0-9]{4,}[A-Z]@[#]+$";
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String inputBarcode = scanner.nextLine();

            if (inputBarcode.matches(regexBarcode)){
                StringBuilder productGroup = new StringBuilder();
                boolean isThereDigit = false;
                for (int j = 0; j < inputBarcode.length(); j++) {
                    char currentChar = inputBarcode.charAt(j);
                    if (Character.isDigit(currentChar)){
                        productGroup.append(currentChar);
                        isThereDigit = true;
                    }
                }
                if (!isThereDigit) {
                    productGroup.append("00");
                }
                System.out.println("Product group: " + productGroup.toString());
            }else {
                System.out.println("Invalid barcode");
            }

        }

    }
}
