package Ex2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        String numeFisierIntrare = "C:\\Users\\magda\\Desktop\\UPT III\\PJ\\Laboratoare\\Lab2\\src\\Ex2\\cantec_in.txt";
        String numeFisierIesire = "C:\\Users\\magda\\Desktop\\UPT III\\PJ\\Laboratoare\\Lab2\\src\\Ex2\\cantec_out.txt";
        Scanner scan = new Scanner(System.in);
        System.out.print("Introduceti o grupare de litere:" );
        String grupareLitere = scan.nextLine();

        try{
            BufferedReader br = new BufferedReader(new FileReader(numeFisierIntrare));
            List<Vers> versuri = new ArrayList<Vers>();
            String linie;

            while ((linie = br.readLine()) != null){
                versuri.add(new Vers(linie));
            }
            br.close();

            BufferedWriter bw = new BufferedWriter(new FileWriter(numeFisierIesire));

            for (Vers vers : versuri){
                String versFinal = vers.versNou(grupareLitere);
                bw.write(versFinal);
                bw.newLine();
            }
            bw.close();
            System.out.println("Fisier de iesire generat!");
        }
        catch (IOException e){
            System.out.println("Eroare la citirea fisierului: " + e.getMessage());
        }
    }
}
