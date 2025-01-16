package TemaLaborator;

public class Copiator extends Echipament {
    private int p_ton;
    private Format format;

    public Copiator(String denumire, int nr_inv, double pret, String zona_mag, Status status,
                    int p_ton, Format format) {
        super(denumire, nr_inv, pret, zona_mag, status);
        this.p_ton = p_ton;
        this.format = format;
    }
    public void setFormat(Format format) {this.format = format;}

    @Override
    public String toString() {
        return "Copiator: " + super.toString() + "Pagini/Toner: " + p_ton + " Format: " + format;
    }

    }
