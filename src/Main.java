import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Kino kino = new Kino();

        try {
            File myObj = new File("filename.dat");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }

            if (myObj.length() != 0) {
                try {
                    FileInputStream file = new FileInputStream(myObj);
                    ObjectInputStream in = new ObjectInputStream(file);

                    // Method for deserialization of object
                    kino = (Kino) in.readObject();

                    in.close();
                    file.close();

                    System.out.println("Object has been deserialized ");
                } catch (IOException ex) {
                    System.out.println("IOException is caught");
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }




        /*
        // tworzymy obiekt klasy ObjectOutputStream do zapisywania do pliku
        ObjectOutputStream wy = new ObjectOutputStream(new FileOutputStream(".\\pracownik.dat"));

        // tworzymy obiekt klasy Pracownik, który chcemy zapisać
        Pracownik henryk = new Pracownik("Henryk", "Kowalski", "Kowal@wp.pl");

        // no i zapisujemy
        wy.writeObject(henryk);
        wy.writeObject(new Pracownik("Henryk2", "Kowalski2", "Kowal2@wp.pl"));
        wy.close();
        //----------- a teraz odczyt -------------------------------------------

        // tworzymy obiekt klasy ObjectInputStream do odczytywania z pliku
        ObjectInputStream we = new ObjectInputStream(new FileInputStream(".\\pracownik.dat"));

        // odczytujemy z pliku; (Pracownik) - to rzutowanie z Object na Pracownik
        Pracownik p1 = (Pracownik) we.readObject();

        // i ładnie na konsolę wyrzucamy wynik
        System.out.println(p1);
        Pracownik p2 = (Pracownik)we.readObject();
        System.out.println(p2);
        we.close();*/
    }
}