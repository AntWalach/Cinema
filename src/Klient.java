import javax.sound.midi.Soundbank;
import java.io.Serializable;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Klient implements Serializable {
    private String surname;
    private String name;
    private String email;
    private String phone;

    private List<Seans> reservations;


    public Klient(String surname, String name, String email, String phone) {
        this.surname = surname;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.reservations = new ArrayList<>();
    }

    public void makeReservation(Seans seans, int numberOfTickets) {
        Scanner scanner = new Scanner(System.in);
        int ticketsBought = 0;

        System.out.println("Select an empty seat. ");
        seans.displaySeatsMap();

        while (ticketsBought < numberOfTickets) {
            System.out.print("Choose row: ");
            String rowSelectString = scanner.next();
            char rowSelect = rowSelectString.charAt(0);

            System.out.print("Choose seat in row " + rowSelect + " :");
            int seatSelect = scanner.nextInt();

            if (seans.isOccupied(rowSelect, seatSelect)) {
                seans.changingSeatStatus(rowSelect, seatSelect);
                System.out.println("Ticket purchased for row " + rowSelect + ", seat " + seatSelect);
                reservations.add(seans);
                ticketsBought++;
            } else {
                System.out.println("The place is taken. Choose another place...");
            }

            if (ticketsBought < numberOfTickets) {
                System.out.println("You can buy " + (numberOfTickets - ticketsBought) + " more tickets.");
            }
        }
    }

    @Override
    public String toString() {
        return "Klient{" +
                "surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", reservations=" + reservations +
                '}';
    }

}
