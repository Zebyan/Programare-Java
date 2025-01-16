package Ex2;

public class SetTobe extends InstrumentMuzical {
    private TipTobe tipTobe;
    private int nr_tobe;
    private int nr_inele;

    public SetTobe(String producator, double pret, TipTobe tipTobe, int nr_tobe, int nr_inele) {
        super(producator, pret);
        this.tipTobe = tipTobe;
        this.nr_tobe = nr_tobe;
        this.nr_inele = nr_inele;
    }

    @Override
    public String toString() {
        return super.toString() + "TipTobe: " + tipTobe + ", Numar Tobe: "+nr_tobe+", Numar Inele: "+nr_inele;
    }
}
