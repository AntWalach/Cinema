import java.io.*;
import java.util.HashMap;

//public class Main {
//
//    public static void main(String[] args) throws IOException, ClassNotFoundException {
//
//        //Kino kino = new Kino("Cinema");
//        Seans obj = new Seans("Fast & Furious", "5-1-2023", "15:00", 5, 5);
//        Seans obj1 = new Seans("The Matrix", "5-1-2023", "15:00", 6, 6);
//        obj.changingSeatStatus('C', 2);
//        obj.displaySeatsMap();
//
//        Klient klient = new Klient("Kowalski", "Jan", "jankowalski@gmail.com", "123456789");
//        Klient klient1 = new Klient("Nowak", "Karol", "karol@gmail.com", "123456789");
//        klient.makeReservation(obj, 2);
//        klient.makeReservation(obj1, 1);
//        klient1.makeReservation(obj, 1);
//        System.out.println(klient);
//        //System.out.println(klient1);


        //System.out.println("\n");
        //System.out.println("\n");
        //System.out.println("\n");


        //System.out.println(obj);



   // }
//}
//////////////////////////////////
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Kino kino = null;
        FileManagement fileManagement = new FileManagement();

        // Sprawdź, czy dane kina zostały zapisane w pliku "kino.dat" i wczytaj je
        try {
            kino = (Kino) fileManagement.loadData("kino.dat");
        } catch (IOException e) {
            System.out.println("Błąd odczytu danych z pliku: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Błąd deserializacji danych: " + e.getMessage());
        }

        if (kino == null) {
            ArrayList<Seans> seansList = new ArrayList<>();
            seansList.add(new Seans("Movie 1", "2023-10-22", "18:00", 5, 10));
            seansList.add(new Seans("Movie 2", "2023-10-22", "20:00", 6, 8));
            kino = new Kino("My Cinema", "123 Main St", seansList, new ArrayList<>());
        }

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Zarezerwuj miejsca");
            System.out.println("2. Wyjście");

            int choice = scanner.nextInt();

            if (choice == 1) {

                System.out.println("Dostępne seanse:");
                ArrayList<Seans> seansList = kino.getSeans();

                for (int i = 0; i < seansList.size(); i++) {
                    System.out.println((i + 1) + ". " + seansList.get(i).getTitle());
                }

                System.out.print("Wybierz numer seansu: ");
                int seansChoice = scanner.nextInt();
                Seans selectedSeans = seansList.get(seansChoice - 1);

                System.out.print("Ilość biletów: ");
                int numberOfTickets = scanner.nextInt();

                System.out.println("Dane klienta:");
                System.out.print("Imię: ");
                String name = scanner.next();
                System.out.print("Nazwisko: ");
                String surname = scanner.next();
                System.out.print("Email: ");
                String email = scanner.next();
                System.out.print("Numer telefonu: ");
                String phone = scanner.next();


                Klient klient = new Klient(name, surname, email, phone);
                klient.makeReservation(selectedSeans, numberOfTickets);

                ArrayList<Klient> clients = kino.getClients();
                clients.add(klient);


                selectedSeans.displaySeatsMap();

                fileManagement.saveData(kino, "kino.dat");

            } else if (choice == 2) {
                System.out.println("Dziękujemy za skorzystanie z naszej aplikacji!");
                break;
            } else if (choice == 3) {
                System.out.println(kino.getSeans());

            }
        }
    }
}
