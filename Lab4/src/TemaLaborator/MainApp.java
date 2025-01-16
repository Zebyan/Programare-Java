
 package TemaLaborator;

import java.util.*;
import java.io.*;

public class MainApp {
    public static void main(String[] args) {
        GestionareEchipament echipamente = new GestionareEchipament();
        echipamente.citireFisier("C:\\Users\\magda\\Desktop\\UPT III\\PJ\\Laboratoare\\Lab4\\electronice.txt");

        Scanner sc = new Scanner(System.in);

        //meniu
        while(true){
            System.out.println("\n___Meniu___");
            System.out.println("1. Afiseaza toate echipamentele");
            System.out.println("2. Afiseaza imprimantele");
            System.out.println("3. Afiseaza copiatoarele");
            System.out.println("4. Afiseaza sisteme de calcul");
            System.out.println("5. Modifica statusul unui echipament");
            System.out.println("6. Setarea unui mod de scriere pentru o imprimanta");
            System.out.println("7. Setarea unui format de copiere pentru copiatoare");
            System.out.println("8. Instalarea unui sistem de operare");
            System.out.println("9. Afisarea echipamentelor vandute");
            System.out.println("10. Serializare");
            System.out.println("11. Deserializare");
            System.out.println("0. Iesire");
            System.out.print("Alegeti o optiune:");
            int opt = sc.nextInt();
            sc.nextLine();

            switch(opt){
                case 1 -> echipamente.afisareEchipament();
                case 2 -> echipamente.afisareImprimanta();
                case 3 -> echipamente.afisareCopiator();
                case 4 -> echipamente.afisareSistemCalcul();
                case 5 -> {
                    System.out.print("Introduceti numar de inventar: ");
                    int inventar = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Introduceți noua stare (achizitionat, expus, vandut)");
                    String statusNou = sc.nextLine();
                    echipamente.modificareStare(inventar, Status.valueOf(statusNou));
                }
                case 6 -> {
                    System.out.print("Introduceti numar de inventar: ");
                    int inventar = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Introduceti mod scriere pentru o imprimanta: ");
                    String mod = sc.nextLine();
                    echipamente.setareTiparire(inventar, Tiparire.valueOf(mod));
                }
                case 7 -> {
                    System.out.print("Introduceti noul format de scriere pentru copiatoare:");
                    String formatScriere = sc.nextLine();
                    echipamente.setareFormat(Format.valueOf(formatScriere));
                }
                case 8 -> {
                    System.out.print("Introduceti numar de inventar: ");
                    int inventar = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Introduceti sistemul de operare care va fi instalat: ");
                    String operare = sc.nextLine();
                    echipamente.instalareSistemOperare(inventar, SistemOperare.valueOf(operare));
                }
                case 9 -> echipamente.afisareVandut();
                case 10 -> {
                    echipamente.serializare(echipamente.getEchipamente());
                }
                case 11 -> {
                    echipamente.deserializare();
                }

                case 0 ->{
                    System.out.print("Iesire...");
                    return;
                }
                default -> System.out.println("Optiune invalida");
            }
        }
    }
}
