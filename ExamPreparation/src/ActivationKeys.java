import java.util.Scanner;

public class ActivationKeys {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder activationCode = new StringBuilder(scanner.nextLine());

        String input = scanner.nextLine();
        String[] commands = input.split(">>>");

        while (!commands[0].equals("Generate")){
            String mainCommand = commands[0];
            switch (mainCommand){
                case "Contains":
                    String searchQueryString = commands[1];
                    if (activationCode.toString().contains(searchQueryString)){
                        System.out.printf("%s contains %s%n", activationCode, searchQueryString);
                    }else {
                        System.out.println("Substring not found!");
                    }
                    break;
                case "Flip":
                    String upperOrLower = commands[1];
                    int indexFrom = Integer.parseInt(commands[2]);
                    int toIndex = Integer.parseInt(commands[3]);

                    String substringToUpperLower = activationCode.substring(indexFrom, toIndex);

                    if (upperOrLower.equals("Upper")){
                        activationCode = new StringBuilder(activationCode.toString()
                                .replace(substringToUpperLower, substringToUpperLower.toUpperCase()));
                        System.out.println(activationCode);
                    }else if (upperOrLower.equals("Lower")){
                    activationCode = new StringBuilder(activationCode.toString()
                            .replace(substringToUpperLower, substringToUpperLower.toLowerCase()));
                    System.out.println(activationCode);
                    }
                    break;
                case "Slice":
                    int startIndex = Integer.parseInt(commands[1]);
                    int endIndex = Integer.parseInt(commands[2]);

                    activationCode.delete(startIndex, endIndex);
                    System.out.println(activationCode);
                    break;
                default:
                    break;
            }
            input = scanner.nextLine();
            commands = input.split(">>>");
        }
        System.out.println("Your activation key is: " + activationCode);
    }
}
