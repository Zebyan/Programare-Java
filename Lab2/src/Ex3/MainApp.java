package Ex3;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduceti sirul initial: ");
        String sirInitial = sc.nextLine();
        System.out.println("Introduceti sirul care va fi adaugat: ");
        String sirAdaugat = sc.nextLine();
        System.out.println("Introduceti pozitia la care se va insera sirul: ");
        String pozitia = sc.nextLine();
        StringBuilder sb = new StringBuilder(sirInitial);
        sb.insert(Integer.parseInt(pozitia), sirAdaugat);
        System.out.println("Sirul dupa inserare: " + sb.toString());

        System.out.println("Introduceti pozitia de la care se va sterge: ");
        String sterge = sc.nextLine();

        System.out.println("Introduceti numarul de caractere sterse: ");
        String numarCaractere = sc.nextLine();

        sb.delete(Integer.parseInt(sterge), Integer.parseInt(numarCaractere));
        System.out.println("Sirul dupa stergere: " + sb.toString());

    }
}
