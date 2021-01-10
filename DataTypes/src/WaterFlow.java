import java.util.Scanner;

public class WaterFlow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfPortions = Integer.parseInt(scanner.nextLine());
        final int tankCapacity = 255;
        int litersInTank = 0;
        int waterPortion = 0;
        for (int i = 0; i < numOfPortions; i++) {
            waterPortion = Integer.parseInt(scanner.nextLine());
            if (litersInTank + waterPortion > tankCapacity){
                System.out.println("Insufficient capacity!");
            }else {
                litersInTank += waterPortion;
            }
        }
        System.out.println(litersInTank);
    }
}
