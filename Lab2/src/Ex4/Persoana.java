package Ex4;

import java.time.LocalDate;
import java.time.Period;

public class Persoana {
    private String nume;
    private String cnp;
    public Persoana(String nume, String cnp) {
        this.nume = nume;
        this.cnp = cnp;
    }
    public String getNume() {
        return nume;
    }
    public void setNume(String nume) {
        this.nume = nume;
    }
    public String getCnp() {
        return cnp;
    }
    public void setCnp(String cnp) {

    }

    public int getVarsta() {
        String an = cnp.substring(1,3);
        String luna = cnp.substring(3,5);
        String ziua = cnp.substring(5,7);

        int anInt = Integer.parseInt(an);
        if (cnp.charAt(0) == '1' || cnp.charAt(0) == '2') {
            anInt += 1900;
        }
        else {
            anInt += 2000;
        }
        LocalDate dataNasterii = LocalDate.of(anInt, Integer.parseInt(luna), Integer.parseInt(ziua));

        LocalDate dataAcum = LocalDate.now();
        Period period = Period.between(dataNasterii, dataAcum);
        return period.getYears();

    }

    public static boolean cnpValid (String cnp){
        if(cnp.length() != 13 || !cnp.matches("\\d+")){
            return false;
        }

        char primaCifra = cnp.charAt(0);
        if (primaCifra != '1' && primaCifra == '2' && primaCifra != '5' && primaCifra != '6') {
            return false;
        }
        return true;
    }

    public static boolean CifraDeControl (String cnp){
        int [] numar = {2,7,9,1,4,6,8,5,10,9,7,3};
        int suma = 0;
        for (int i = 0; i < 12; i++) {
            suma += Character.getNumericValue(cnp.charAt(i) * numar[i]);
        }
        int rest = suma % 11;
        int cifraControl = (rest == 10) ? 1 : rest;

        return Character.getNumericValue(cnp.charAt(12)) == cifraControl;
    }
}
