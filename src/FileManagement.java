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

            return ois.readObject();
        }
    }


    void saveToFile(String fileName, String data) throws IOException {
        FileWriter f = new FileWriter(fileName);
        BufferedWriter out = new BufferedWriter(f);
        out.write(data);
        out.close();
    }

    String readFile(String fileName) throws IOException {
        FileInputStream f = new FileInputStream(fileName);
        DataInputStream in = new DataInputStream(f);
        BufferedReader r = new BufferedReader(new InputStreamReader(in));
        String strLine = "";
        StringBuilder data = new StringBuilder();
        while ((strLine = r.readLine()) != null)
            data.append(strLine).append("\n");
        in.close();
        return data.toString();
    }






}




