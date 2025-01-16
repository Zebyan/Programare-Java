package Ex2;

public class Chitara extends InstrumentMuzical {
    private TipChitara tipChitara;
    private int nr_corzi;

    public Chitara (String producator, double pret, TipChitara tipChitara, int nr_corzi) {
        super(producator, pret);
        this.tipChitara = tipChitara;
        this.nr_corzi = nr_corzi;
    }

    @Override
    public String toString() {
        return super.toString() + "Tip Chitara: "+tipChitara+", Nr Corzi: "+nr_corzi;
    }
}
