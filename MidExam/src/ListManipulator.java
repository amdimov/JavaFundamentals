import java.util.Scanner;

public class ListManipulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //TODO change the input
        String[] names = scanner.nextLine().split(", "); //scanner.nextLine().split(", ");

        String[] input = scanner.nextLine().split("\\s+");
        String command = input[0];
        int numOfBlacklists = 0;
        int numOfErrors = 0;

        while (!command.equals("Report")){
            //NOTE Blacklist
            if (command.equals("Blacklist")){
                String blacklistName = input[1];
                boolean doesTheNameExist = false;
                for (int i = 0; i < names.length; i++) {
                    if (blacklistName.equals(names[i])){
                        names[i] = "Blacklisted";
                        doesTheNameExist = true;
                        break;
                    }
                }
                if (doesTheNameExist){
                    System.out.println(blacklistName + " was blacklisted.");
                    numOfBlacklists++;
                }else{
                    System.out.println(blacklistName + " was not found.");
                }
            //ERROR
            }else if(command.equals("Error")){
                int index = Integer.parseInt(input[1]);
                if (index >= 0 && index <= names.length-1) {
                    String errorName = names[index];
                    if (!names[index].equals("Blacklisted") && !names[index].equals("Lost")) {
                        names[index] = "Lost";
                        System.out.println(errorName + " was lost due to an error.");
                        numOfErrors++;
                    }
                }
            }else if(command.equals("Change")){
                int index = Integer.parseInt(input[1]);
                String newName = input[2];
                if (index >= 0 && index <= names.length-1){
                    System.out.println(names[index] + " changed his username to " + newName+".");
                    names[index] = newName;
                }

            }
            input = scanner.nextLine().split("\\s+");
            command = input[0];
        }

        System.out.println("Blacklisted names: " + numOfBlacklists);
        System.out.println("Lost names: " + numOfErrors);
        for (int i = 0; i < names.length; i++) {
            if (i != names.length-1) {
                System.out.print(names[i] + " ");
            }else {
                System.out.print(names[i]);
                System.out.println();
            }
        }

    }
}
