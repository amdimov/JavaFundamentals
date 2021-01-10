import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Shift {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> list = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
//        list.add(0, list.get(list.size()-1));
//        list.remove(list.size()-1);

        //shift(list, 2, "right");

        //shiftLoop(list);
        shift(list, 2, "right");


        for (int j :
                list) {
            System.out.print(j + " ");
        }
    }

    public static List<Integer> shift(List<Integer> list, int steps, String direction){
        List<Integer> test = new ArrayList<>();
        if (direction.equals("right")){
            for (int i = 0; i < steps; i++) {
                list.add(0, list.get(list.size()-1));
                list.remove(list.size()-1);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            test.add(i, list.get(i));
        }
        return test;
    }

    public static List<Integer> shiftLoop(List<Integer> list){

        //make temp variable to hold last element
        int temp = list.get(list.size()-1);

        //make a loop to run through the array list
        for(int i = list.size()-1; i > 0; i--)
        {
            //set the last element to the value of the 2nd to last element
            list.set(i,list.get(i-1));
        }
        //set the first element to be the last element
        list.set(0, temp);

        return list;
    }
}
