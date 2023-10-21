import java.io.*;
import java.util.List;

public class FileManagement {

    void saveData(Object object, String dataFilePath) {
        try {
            FileOutputStream fos = new FileOutputStream(dataFilePath);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(object);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Object loadData(String dataFilePath) throws IOException, ClassNotFoundException {
        try (FileInputStream fis = new FileInputStream(dataFilePath);
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            return ois.readObject(); // Wczytaj obiekt z pliku i zwróć go
        }
    }

}




