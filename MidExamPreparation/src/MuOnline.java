import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MuOnline {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] rooms = scanner.nextLine().split("\\|");
        int playerHealth = 100;
        int playerBitcoins = 0;
        boolean winTheGame = true;
        String[]inRoomCommands;
        int bestRoom = 0;
        for (int i = 0; i < rooms.length; i++) {
            inRoomCommands = rooms[i].split("\\s+");
            String command = inRoomCommands[0];
            int valueOfCommand = Integer.parseInt(inRoomCommands[1]);

            if(command.equals("potion")){
                if (playerHealth + valueOfCommand > 100){
                    valueOfCommand = 100 - playerHealth;
                }
                playerHealth += valueOfCommand;
                System.out.printf("You healed for %d hp.%n", valueOfCommand);
                System.out.printf("Current health: %d hp.%n", playerHealth);
            }else if(command.equals("chest")){
                playerBitcoins+=valueOfCommand;
                System.out.printf("You found %d bitcoins.%n", valueOfCommand);
            }else {
                playerHealth -=valueOfCommand;
                if (playerHealth > 0){
                    System.out.printf("You slayed %s.%n", command);
                }else {
                    System.out.printf("You died! Killed by %s.%n", command);
                    System.out.printf("Best room: %d%n", i+1);
                    winTheGame = false;
                    break;
                }
            }

            //System.out.println(command +"---"+valueOfCommand);
        }
        if (winTheGame){
            System.out.printf("You've made it!%nBitcoins: %d%nHealth: %d", playerBitcoins, playerHealth);
        }

    }
}
