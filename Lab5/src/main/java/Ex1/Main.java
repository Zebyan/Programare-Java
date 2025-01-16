package Ex1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class Main {
    public static void scriere(List<PerecheNumere> lista) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("perechi.json"))) {
            writer.write("[");
            for (int i = 0; i < lista.size(); i++) {
                PerecheNumere pereche = lista.get(i);
                writer.write("{\"numar1\": " + pereche.getNumar1() + ", \"numar2\": " + pereche.getNumar2() + "}");
                if (i < lista.size() - 1) {
                    writer.write(",");
                }
            }
            writer.write("]");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<PerecheNumere> citire() {
        List<PerecheNumere> lista = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("perechi.json"))) {
            StringBuilder json = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                json.append(line.trim());
            }
            String content = json.toString();
            content = content.substring(1, content.length() - 1); // Eliminăm parantezele pătrate
            String[] perechi = content.split("\\},\\{");
            for (String pereche : perechi) {
                pereche = pereche.replace("{", "").replace("}", "").replace("\"", "");
                String[] valori = pereche.split(", ");
                int numar1 = Integer.parseInt(valori[0].split(": ")[1]);
                int numar2 = Integer.parseInt(valori[1].split(": ")[1]);
                lista.add(new PerecheNumere(numar1, numar2));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public static void main(String[] args) {
        List<PerecheNumere> lista = new ArrayList<>();
        lista.add(new PerecheNumere(8, 13));
        lista.add(new PerecheNumere(15, 20));
        lista.add(new PerecheNumere(21, 34));

        // Scriere în fișier JSON
        scriere(lista);

        // Citire din fișier JSON
        List<PerecheNumere> listaCitita = citire();
        System.out.println("Lista citită din fișier:");
        listaCitita.forEach(System.out::println);
    }
}

