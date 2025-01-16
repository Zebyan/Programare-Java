package TemaLaborator;

import java.io.Serializable;
//https://www.baeldung.com/java-serialization
public class Echipament implements Serializable {
    protected String denumire;
    protected int nr_inv;
    protected double pret;
    protected String zona_mag;
    protected Status status;

    public Echipament(String denumire, int nr_inv, double pret, String zona_mag, Status status) {
        this.denumire = denumire;
        this.nr_inv = nr_inv;
        this.pret = pret;
        this.zona_mag = zona_mag;
        this.status = status;
    }

    public void setStatus(Status status) {this.status = status;}

    @Override
    public String toString() {
        return denumire + ", Numar Inventar: " + nr_inv + ", Pret:" + pret + ", Zona " + zona_mag + ", Status: " + status + ", ";
    }
}
