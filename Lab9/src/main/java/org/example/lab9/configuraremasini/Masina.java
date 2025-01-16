package org.example.lab9.configuraremasini;


public class Masina {
    private String nr_inmatriculare;
    private String marca;
    private int an_fabricatie;
    private String culoare;
    private int km;
    public Masina(){};
    public Masina(String nr_inmatriculare,String marca, int an_fabricatie, String culoare, int km){
        this.nr_inmatriculare=nr_inmatriculare;
        this.marca = marca;
        this.an_fabricatie = an_fabricatie;
        this.culoare = culoare;
        this.km = km;
    }

    public String getNr_inmatriculare() {return nr_inmatriculare;}
    public String getMarca() {return marca;}
    public int getAn_fabricatie() {return an_fabricatie;}
    public String getCuloare() {return culoare;}
    public int getKm() {return km;}

    @Override
    public String toString() {
        return nr_inmatriculare+", "+", "+marca+", "+", "+culoare+", "+", "+km;
    }

}
