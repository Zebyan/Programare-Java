package TemaLaborator;

public class Imprimanta extends Echipament {
    private int ppm;
    private String rezolutie;
    private int p_car;
    private Tiparire tiparire;

    public Imprimanta(String denumire, int nr_inv, double pret, String zona_mag, Status status,
                      int ppm, String rezolutie, int p_car, Tiparire tiparire) {
        super(denumire, nr_inv, pret, zona_mag, status);
        this.ppm = ppm;
        this.rezolutie = rezolutie;
        this.p_car = p_car;
        this.tiparire = tiparire;
    }

    public void setTiparire(Tiparire tiparire) {this.tiparire = tiparire;}

    @Override
    public String toString() {
        return "Imprimanta: " + super.toString() + "PPM: " + ppm + ", DPI: " + rezolutie + ", Pagini/Cartus: " + p_car + ", Tiparire: " + tiparire;
    }

    }
