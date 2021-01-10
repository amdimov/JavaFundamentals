import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClassExLecture {
    static class Reservation{
        String holderName;
        String phoneNum;
        int seats;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Reservation> reservations = new ArrayList<>();
        String input = scanner.nextLine();

        while (!input.equals("end")){
            String[] namesAndSeats = input.split("\\s+");
            String holder = namesAndSeats[0];
            String phone = namesAndSeats[1];
            int seats = Integer.parseInt(namesAndSeats[2]);

            Reservation r = new Reservation();
            r.holderName = holder;
            r.phoneNum = phone;
            r.seats = seats;

            reservations.add(r);

            input = scanner.nextLine();
        }

        String guestName = scanner.nextLine();
        int reseravtionIndex = -1;

        for (int i = 0; i < reservations.size(); i++) {
            Reservation guestList = reservations.get(i);
            if (guestName.equals(guestList.holderName)){
                reseravtionIndex = i;
            }
        }
        if (!(reseravtionIndex == -1)){
            System.out.println(reservations.get(reseravtionIndex).seats);
        }else{
            System.out.println("Sorry, no such name in the list!");
        }

    }
}
