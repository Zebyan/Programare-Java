package TemaLaborator;

public class SistemCalcul extends Echipament{
    private String tip_mon;
    private double vit_proc;
    private int c_hdd;
    private SistemOperare sistem_operare;

    public SistemCalcul(String denumire, int nr_inv, double pret, String zona_mag, Status status,
                        String tip_mon, double vit_proc, int c_hdd, SistemOperare sistem_operare) {
        super (denumire, nr_inv, pret, zona_mag, status);
        this.tip_mon = tip_mon;
        this.vit_proc = vit_proc;
        this.c_hdd = c_hdd;
        this.sistem_operare = sistem_operare;
    }
    public void setSistemOperare(SistemOperare sistem_operare) {
        this.sistem_operare = sistem_operare;
    }
    @Override
    public String toString() {
        return "Sistem de Calcul: " + super.toString() + "Tip monitor: " + tip_mon +
                ", Viteza procesor: " + vit_proc + ", Capacitate HDD: " + c_hdd + ", Sistem de operare: " + sistem_operare;
    }
    }
