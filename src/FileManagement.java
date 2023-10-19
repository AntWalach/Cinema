import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileManagement {
    public void saveFile(String filename, String daneDoZapisu) throws IOException {
        FileWriter f = new FileWriter(filename);
        BufferedWriter out = new BufferedWriter(f);
        out.write(daneDoZapisu);
        out.close();
    }
}
