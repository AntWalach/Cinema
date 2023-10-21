import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Kino implements Serializable {
    private String name;
    private String address;
    private ArrayList<Seans> seans;
    private ArrayList<Pracownik> employees;

    //private ArrayList<Bilet> tickets;

    public Kino(String name, String address, ArrayList<Seans> seans) {
        this.name = name;
        this.address = address;
        this.seans = seans;
    }
}
