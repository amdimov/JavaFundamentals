import java.util.Scanner;

public class Bakery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int biscuitsPerDay = Integer.parseInt(scanner.nextLine());
        int numOfWorkers = Integer.parseInt(scanner.nextLine());
        int otherFactoryCapacity =  Integer.parseInt(scanner.nextLine());

        int dailyProduction = biscuitsPerDay * numOfWorkers;
        int monthlyProduction = 0;

        for (int i = 0; i < 30; i++) {
            if (i % 3 != 0){
                monthlyProduction += dailyProduction;
            }else{
                double unUsualProduction = (double)Math.floor(dailyProduction);
                monthlyProduction += (unUsualProduction*0.75);
            }
        }

        double factoryDifference = 0.0;

        if (monthlyProduction > otherFactoryCapacity){

            factoryDifference = (double)(monthlyProduction - otherFactoryCapacity)/otherFactoryCapacity * 100;
            System.out.printf("You have produced %d biscuits for the past month.%n", monthlyProduction);
            System.out.printf("You produce %.2f percent more biscuits.", factoryDifference);
        }else{
            factoryDifference = (double)(otherFactoryCapacity - monthlyProduction)/otherFactoryCapacity * 100;
            System.out.printf("You have produced %d biscuits for the past month.%n", monthlyProduction);
            System.out.printf("You produce %.2f percent less biscuits.", factoryDifference);
        }
        //System.out.println(monthlyProduction);
    }
}
