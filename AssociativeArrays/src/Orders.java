import java.util.*;

public class Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<Double>> productsMap = new LinkedHashMap<>();

        String[] input = scanner.nextLine().split("\\s+");
        String declaration = input[0];


        while (!declaration.equals("buy")){
            //TODO
            double productPrice = Double.parseDouble(input[1]);
            double productVolume = Double.parseDouble(input[2]);

            List<Double> priceAndQuantity = productsMap.get(declaration);
            if (priceAndQuantity == null){
                priceAndQuantity = new ArrayList<>();
                productsMap.put(declaration, priceAndQuantity);
                priceAndQuantity.add(productPrice);
                priceAndQuantity.add(productVolume);
            }else {
                priceAndQuantity.set(0, productPrice);
                double oldVolume = priceAndQuantity.get(1);
                priceAndQuantity.set(1, oldVolume + productVolume);

            }

            input = scanner.nextLine().split("\\s+");
            declaration = input[0];
        }

//        for (Map.Entry<String, List<Double>> n :
//                productsMap.entrySet()) {
//            System.out.print(n.getKey() + " -> ");
//            for (int j = 0; j < n.getValue().size(); j++) {
//                if (j == 0) {
//                    System.out.printf("%.2f ", n.getValue().get(j));
//                }else {
//                    System.out.printf("%.0f ", n.getValue().get(j));
//                }
//            }
//            System.out.println();
//        }
        for (Map.Entry<String, List<Double>> n :
                productsMap.entrySet()) {
            double price = 0.0;
            double quantity = 0.0;
            double totalPrice = 0.0;
            System.out.print(n.getKey() + " -> ");
            for (int j = 0; j < n.getValue().size(); j++) {
                if (j == 0) {
                    price =  n.getValue().get(j);
                }else {
                    quantity = n.getValue().get(j);
                }
            }
            totalPrice = price * quantity;
            System.out.printf("%.2f%n", totalPrice);
        }


    }
}
