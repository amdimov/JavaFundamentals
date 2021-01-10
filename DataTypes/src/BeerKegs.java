import java.util.Scanner;

public class BeerKegs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfKegs = Integer.parseInt(scanner.nextLine());

        String model = "";
        double radius = 0.0;
        double height = 0.0;
        double volume = 0.0;

        double bestVolume = Double.MIN_VALUE;
        String bestModel = "";

        for (int i = 0; i < numOfKegs; i++) {
            model = scanner.nextLine();
            radius = Double.parseDouble(scanner.nextLine());
            height = Double.parseDouble(scanner.nextLine());

            volume = Math.PI*(radius*radius) * height;

            if (volume > bestVolume){
                bestModel = model;
                bestVolume = volume;
            }
        }
        System.out.println(bestModel);
    }
}
