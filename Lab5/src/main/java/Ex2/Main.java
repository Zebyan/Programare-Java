package Ex2;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final int LUNGIME_COALA = 2800;
    private static final int LATIME_COALA = 2070;

    public static void main(String[] args) {
        List<Mobilier> mobilier = citesteMobilierDinJson("mobilier.json");

        // Afișează colecția de mobilier
        System.out.println("Colecția de mobilier:");
        mobilier.forEach(System.out::println);

        // Afișează plăcile care compun fiecare piesă
        System.out.println("\nPiese de mobilier și plăcile care le compun:");
        mobilier.forEach(m -> {
            System.out.println(m.getNume() + ":");
            m.getPlaci().forEach(System.out::println);
        });

        // Caracteristicile plăcilor pentru o piesă dată
        System.out.println("\nCaracteristicile plăcilor pentru birou:");
        afiseazaPlacilePentruMobilier(mobilier, "birou");

        // Calcul estimativ al colilor de PAL
        System.out.println("\nNumăr estimativ de coli de PAL pentru birou:");
        System.out.println(calculeazaColiPal(mobilier, "birou") + " coli");
    }

    public static List<Mobilier> citesteMobilierDinJson(String filename) {
        List<Mobilier> listaMobilier = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            JSONArray jsonArray = new JSONArray(sb.toString());

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject objMobilier = jsonArray.getJSONObject(i);
                String nume = objMobilier.getString("nume");
                JSONArray jsonPlaci = objMobilier.getJSONArray("placi");

                List<Placa> placi = new ArrayList<>();
                for (int j = 0; j < jsonPlaci.length(); j++) {
                    JSONObject objPlaca = jsonPlaci.getJSONObject(j);
                    String descriere = objPlaca.getString("descriere");
                    int lungime = objPlaca.getInt("lungime");
                    int latime = objPlaca.getInt("latime");
                    Placa.Orientare orientare = Placa.Orientare.valueOf(objPlaca.getString("orientare").toUpperCase());
                    JSONArray jsonCanturi = objPlaca.getJSONArray("canturi");
                    boolean[] canturi = new boolean[4];
                    for (int k = 0; k < jsonCanturi.length(); k++) {
                        canturi[k] = jsonCanturi.getBoolean(k);
                    }
                    int nrBucati = objPlaca.getInt("nr_bucati");

                    placi.add(new Placa(descriere, lungime, latime, orientare, canturi, nrBucati));
                }
                listaMobilier.add(new Mobilier(nume, placi));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listaMobilier;
    }

    public static void afiseazaPlacilePentruMobilier(List<Mobilier> mobilier, String numeMobilier) {
        mobilier.stream()
                .filter(m -> m.getNume().equalsIgnoreCase(numeMobilier))
                .flatMap(m -> m.getPlaci().stream())
                .forEach(System.out::println);
    }

    public static int calculeazaColiPal(List<Mobilier> mobilier, String numeMobilier) {
        int totalArie = mobilier.stream()
                .filter(m -> m.getNume().equalsIgnoreCase(numeMobilier))
                .flatMap(m -> m.getPlaci().stream())
                .mapToInt(placa -> placa.getLungime() * placa.getLatime() * placa.getNrBucati())
                .sum();

        int ariaColii = LUNGIME_COALA * LATIME_COALA;
        return (int) Math.ceil((double) totalArie / ariaColii);
    }
}

