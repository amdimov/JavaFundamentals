import java.util.Scanner;

public class ArrayModifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputArray = scanner.nextLine().split("\\s+");
        String[] inputCommand = scanner.nextLine().split("\\s+");
        String command = inputCommand[0];

        while (!command.equals("end")){
            if (command.equals("swap")){
                int index1 = Integer.parseInt(inputCommand[1]);
                int index2 = Integer.parseInt(inputCommand[2]);
                String holder = inputArray[index1];
                    inputArray[index1] = inputArray[index2];
                    inputArray[index2] = holder;
            }else if(command.equals("multiply")){
                int index1 = Integer.parseInt(inputCommand[1]);
                int index2 = Integer.parseInt(inputCommand[2]);
                int result = Integer.parseInt(inputArray[index1])*Integer.parseInt(inputArray[index2]);
                inputArray[index1] = Integer.toString(result);
            }else{
                for (int i = 0; i < inputArray.length; i++) {
                    int decreasedValue = Integer.parseInt(inputArray[i]);
                    decreasedValue--;
                    inputArray[i] = Integer.toString(decreasedValue);
                }
            }
            inputCommand = scanner.nextLine().split("\\s+");
            command = inputCommand[0];
        }

        System.out.println(String.join(", ", inputArray));
    }
}
