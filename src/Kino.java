import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Kino implements Serializable {
    private String nazwa;
    private String adres;
    private ArrayList<Seans> seanse;
    private ArrayList<Pracownik> pracownicy;
    private ArrayList<Bilet> bilety;
}
