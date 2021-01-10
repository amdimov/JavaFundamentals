import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class OrderByAge {
    private static class NamesData {
        public String getName() {
            return name;
        }

        public String getId() {
            return id;
        }

        public int getAge() {
            return age;
        }

        String name;
        String id;
        int age;

        public NamesData(String name, String id, int age) {
            this.name = name;
            this.id = id;
            this.age = age;
        }

        @Override
        public String toString() {
            return String.format("%s with ID: %s is %d years old.",
                    getName(), getId(), getAge());
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<NamesData> namesDataList = new ArrayList<>();
        String[] input =scanner.nextLine().split("\\s+");

        while (!input[0].equals("End")){
            NamesData names = new NamesData(input[0], input[1], Integer.parseInt(input[2]));
            namesDataList.add(names);
            //
            input = scanner.nextLine().split("\\s+");
        }
        namesDataList.stream()
                .sorted(Comparator.comparingInt(NamesData::getAge))
                .forEach(System.out::println);

    }


}
