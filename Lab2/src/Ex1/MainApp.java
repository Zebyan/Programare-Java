package Ex1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        String numeFisier = "C:\\Users\\magda\\Desktop\\UPT III\\PJ\\Laboratoare\\Lab2\\src\\Ex1\\judete_in.txt";
        try{
            BufferedReader br = new BufferedReader(new FileReader(numeFisier));
            String linie;
            StringBuilder continutFisier = new StringBuilder();

            while ((linie = br.readLine()) != null) {
                continutFisier.append(linie).append("\n");
            }
            br.close();

            String[] judete = continutFisier.toString().split("\n");
            Arrays.sort(judete);
            System.out.println("Judete ordonate alfabetic: ");
            for (String judet : judete){
                System.out.println(judet);
            }

            Scanner sc = new Scanner(System.in);
            System.out.print("Introduceti judetul: ");
            String judetCautat = sc.nextLine();
            sc.close();
            int pozitie = Arrays.binarySearch(judete, judetCautat);

            if (pozitie >= 0){
                System.out.println("Judetul "+ judetCautat + " se afla pe pozitia " + pozitie);
            }
            else{
                System.out.println("Judetul " + judetCautat + " NU EXISTA!");
            }
        }
        catch (IOException e){
            System.out.println("Eroare la citirea fișierului: " + e.getMessage());
        }
    }
}
