import java.io.*;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        //Kino kino = new Kino("Cinema");
        Seans obj = new Seans("Fast & Furious", "5-1-2023", "15:00",5, 5);
        obj.changingSeatStatus('C', 2);
        obj.displaySeatsMap();



//        try {
//            File myObj = new File("filename.dat");
//            if (myObj.createNewFile()) {
//                System.out.println("File created: " + myObj.getName());
//            } else {
//                System.out.println("File already exists.");
//            }
//
//            if (myObj.length() != 0) {
//                try {
//                    FileInputStream file = new FileInputStream(myObj);
//                    ObjectInputStream in = new ObjectInputStream(file);
//
//                    // Method for deserialization of object
//                    kino = (Kino) in.readObject();
//
//                    in.close();
//                    file.close();
//
//                    System.out.println("Object has been deserialized ");
//                } catch (IOException ex) {
//                    System.out.println("IOException is caught");
//                }
//            }
//        } catch (IOException e) {
//            System.out.println("An error occurred.");
//            e.printStackTrace();
//        }
    }
}