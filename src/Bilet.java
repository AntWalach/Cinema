import java.io.Serializable;

public class Bilet implements Serializable {
    Seans seans;
    Klient klient;

    Bilet(Seans seans, Klient klient){
        this.seans = seans;
        this.klient = klient;
    }

    @Override
    public String toString() {
        return "Bilet{" +
                "seans=" + seans +
                ", klient=" + klient +
                '}';
    }
}
