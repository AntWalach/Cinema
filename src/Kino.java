import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Kino implements Serializable {
    private String name;
    private String address;
    private ArrayList<Seans> seans;
    private ArrayList<Pracownik> employees;

    public ArrayList<Seans> getSeans() {
        return seans;
    }

    private ArrayList<Klient> clients;

    public ArrayList<Klient> getClients() {
        return clients;
    }


    public Kino(String name, String address, ArrayList<Seans> seans, ArrayList<Klient> clients) {
        this.name = name;
        this.address = address;
        this.seans = seans;
        this.clients = clients;
    }
}
