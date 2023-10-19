import java.io.Serializable;
import java.util.HashMap;

public class Seans implements Serializable {
    String tytul;
    String dzien;
    String godzina;
    String ograniczeniaWiekowe;
    HashMap<Character,HashMap<Integer,Boolean>> liczbaMiejsc;
}
