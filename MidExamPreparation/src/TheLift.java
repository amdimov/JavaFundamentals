import java.util.Scanner;

public class TheLift {
    //https://judge.softuni.bg/Contests/Practice/Index/2517#1
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int peopleOnQueue = Integer.parseInt(scanner.nextLine());
        String[] liftState = scanner.nextLine().split("\\s+");
        int[] listStateParsed = parseStringInputArray(liftState);
        boolean areThereEmptySpots = true;
        for (int i = 0; i < listStateParsed.length; i++) {
            for (int j = listStateParsed[i]; j < 4; j++) {
                if (peopleOnQueue != 0){
                    listStateParsed[i]++;
                    peopleOnQueue--;
                    if (listStateParsed[listStateParsed.length-1] == 4){
                        areThereEmptySpots = false;
                    }
                }else {
                    break;
                }
            }
        }

        if(peopleOnQueue == 0){
            if (areThereEmptySpots){
                System.out.println("The lift has empty spots!");
            }
            for (int n :
                    listStateParsed) {
                System.out.print(n + " ");
            }
        }else{
            System.out.printf("There isn't enough space! %d people in a queue!%n", peopleOnQueue);
            for (int n :
                    listStateParsed) {
                System.out.print(n + " ");
            }

        }




    }

    public static int[] parseStringInputArray(String[] array){
        int[] arrayParsedToInt = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            arrayParsedToInt[i] = Integer.parseInt(array[i]);
        }
        return arrayParsedToInt;
    }
}
