package Ex2;

import java.util.Random;

public class Vers {
    private String vers;
    public Vers(String vers) {
        this.vers = vers;
    }

    public String getVers() {
        return vers;
    }

    int getNumarCuvinte() {
        String [] cuvinte = vers.trim().split("\\s+");
        return cuvinte.length;
    }

    public int getNumarVocale() {
        int numarVocale = 0;
        String vocale = "aeiouAEIOU";
        for (char c : vocale.toCharArray()) {
            if(vocale.indexOf(c) >= 0) {
                numarVocale++;
            }
        }
        return numarVocale;
    }

    public boolean verificareGrupare (String grupare) {
        return vers.trim().endsWith(grupare);
    }

    public String majuscule(){
        Random rand = new Random();
        double numarRandom = rand.nextDouble();
        if(numarRandom < 0.1) {
            return vers.toUpperCase();
        }
        return vers;
    }

    public String versNou (String grupare) {
        String linie = majuscule();
        int numarCuvinte = getNumarCuvinte();
        int numarVocale = getNumarVocale();

        linie += " (Cuvinte: " + numarCuvinte + ", Vocale: " + numarVocale + ")";
        if (verificareGrupare(grupare)) {
            linie += " *";
        }
        return linie;
    }



}
