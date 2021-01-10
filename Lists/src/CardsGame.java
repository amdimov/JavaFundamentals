import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CardsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> firstPlayerDeck = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> secondPlayerDeck = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        int steps = 0;
        int firstPlayerPoints = 0;
        int secondPlayerPoints = 0;
        int winner = 0;

        while (firstPlayerDeck.size() != 0 && secondPlayerDeck.size() != 0){
            int i = 0;

            if (firstPlayerDeck.get(i) > secondPlayerDeck.get(i)){
                firstPlayerPoints += (firstPlayerDeck.get(i) + secondPlayerDeck.get(i));
                firstPlayerDeck.add(firstPlayerDeck.size(), firstPlayerDeck.get(i));
                firstPlayerDeck.add(firstPlayerDeck.size(), secondPlayerDeck.get(i));
                firstPlayerDeck.remove(i);
                secondPlayerDeck.remove(i);
            }else if(secondPlayerDeck.get(i) > firstPlayerDeck.get(i)){
                secondPlayerPoints += (firstPlayerDeck.get(i) + secondPlayerDeck.get(i));
                secondPlayerDeck.add(secondPlayerDeck.size(), secondPlayerDeck.get(i));
                secondPlayerDeck.add(secondPlayerDeck.size(), firstPlayerDeck.get(i));
                firstPlayerDeck.remove(i);
                secondPlayerDeck.remove(i);
            }else {
                secondPlayerDeck.remove(i);
                firstPlayerDeck.remove(i);
            }
        }
        if (firstPlayerPoints > secondPlayerPoints){
            for (int n :
                    firstPlayerDeck) {
                winner += n;
            }
            System.out.println("First player wins! Sum: "+winner);
        }else{
            for (int n :
                    secondPlayerDeck) {
                winner += n;
            }
            System.out.println("Second player wins! Sum: "+winner);
        }
    }
}
