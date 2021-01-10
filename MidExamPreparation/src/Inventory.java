import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Inventory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> itemsInput = Arrays.stream(scanner.nextLine().split(", ")).map(Object::toString).collect(Collectors.toList());
        String[] inputCommands = scanner.nextLine().split(" - ");
        while (!inputCommands[0].equals("Craft!")){
            String command = inputCommands[0];
            String item = inputCommands[1];
            //TODO
            if (command.equals("Collect") && !itemsInput.contains(item)){
                itemsInput.add(item);
            }else if(command.equals("Drop") && itemsInput.contains(item)){
                itemsInput.remove(item);
            }else if(command.equals("Combine Items")) {
                String[] combineItems = item.split(":");
                String oldItem = combineItems[0];
                String newItem = combineItems[1];
                if (itemsInput.contains(oldItem)){
                    itemsInput.add(itemsInput.indexOf(oldItem)+1, newItem);
                }
            }else if(command.equals("Renew") && itemsInput.contains(item)){
                String oldItemPosition = item;
                itemsInput.remove(item);
                itemsInput.add(oldItemPosition);
            }
            inputCommands = scanner.nextLine().split(" - ");
        }
        System.out.println(String.join(", ", itemsInput));
    }
}
