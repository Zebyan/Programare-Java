package Ex2;

import java.time.LocalDate;

public class Produs {
    //membrii
    private String denumire;
    private double pret;
    private int cantitate;
    private LocalDate dataExpirarii;

    //constructor
    Produs(String denumire, double pret, int cantitate, LocalDate dataExpirarii) {
        this.denumire = denumire;
        this.pret = pret;
        this.cantitate = cantitate;
        this.dataExpirarii = dataExpirarii;
    }
    //metode get
    public String getDenumire() {return denumire;}
    public double getPret() {return pret;}
    public int getCantitate() {return cantitate;}
    public LocalDate getDataExpirarii() {return dataExpirarii;}

    //metode set
    public void setDenumire(String denumire) {this.denumire = denumire;}
    public void setPret(double pret) {this.pret = pret;}
    public void setCantitate(int cantitate) {this.cantitate = cantitate;}
    public void setDataExpirarii(LocalDate dataExpirarii) {this.dataExpirarii = dataExpirarii;}

    @Override
    public String toString() {
        return "Produs: " + denumire +
                ", Pret: " + pret +
                ", Cantitate: " + cantitate +
                ", DataExpirarii: " + dataExpirarii;
    }



}
