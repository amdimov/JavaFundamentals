import java.util.*;
import java.util.stream.Collectors;

public class MagicCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> availableCardsList = Arrays.stream(scanner.nextLine().split(":")).map(Object::toString).collect(Collectors.toList());
        List<String> myDeck = new ArrayList<>();

        String[] input = scanner.nextLine().split("\\s+");
        String command = input[0];

        while (!command.equals("Ready")){
            //TODO
            if (command.equals("Add")){
                String cardName = input[1];
                if (availableCardsList.contains(cardName)){
                    myDeck.add(cardName);
                }else {
                    System.out.println("Card not found.");
                }
            }else if(command.equals("Insert")){
                String cardName = input[1];
                int insertIndex = Integer.parseInt(input[2]);
                if (availableCardsList.contains(cardName) && insertIndex >= 0 && insertIndex <= myDeck.size()-1){
                    myDeck.add(insertIndex, cardName);
                }else{
                    System.out.println("Error!");
                }
            }else if(command.equals("Remove")){
                String cardName = input[1];
                boolean isCardFound = false;
                for (int i = 0; i < myDeck.size(); i++) {
                    if (myDeck.get(i).equals(cardName)){
                        isCardFound = true;
                        myDeck.remove(i);
                        break;
                    }
                }
                if (!isCardFound){
                    System.out.println("Card not found.");
                }
            }else if(command.equals("Swap")){
                String cardOne = input[1];
                String cardTwo = input[2];
                if (myDeck.contains(cardOne) && myDeck.contains(cardTwo)) {
                    int indexCardOne = myDeck.indexOf(cardOne);
                    int indexCardTwo = myDeck.indexOf(cardTwo);
                        String cardTwoHolder = cardTwo;
                        myDeck.set(indexCardTwo, cardOne);
                        myDeck.set(indexCardOne, cardTwoHolder);

                }
            }else if(command.equals("Shuffle")){
                Collections.reverse(myDeck);
            }
            //GET NEW INPUT
            input = scanner.nextLine().split("\\s+");
            command = input[0];
        }
        for (String n :
                myDeck) {
            System.out.print(n+" ");
        }


    }
}
