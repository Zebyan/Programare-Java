package lab8;

import java.sql.*;
import java.util.*;


public class MainApp {
    public static void main(String[] args) {
        try (Connection connection = BazaDate.getConnection()) {
            Scanner scanner = new Scanner(System.in);
            MetodePersoane metodePersoane = new MetodePersoane(connection);
            MetodeExcursii metodeExcursii = new MetodeExcursii(connection);

            while (true) {
                System.out.println("---Meniu---");
                System.out.println("1.Adauga Persoana");
                System.out.println("2.Adauga Excursie");
                System.out.println("3.Afiseaza toate excursiile unei Persoane");
                System.out.println("4.Afisarea excursiilor unei persoane");
                System.out.println("5.Afisarea persoanelor care au fost la o destinatie");
                System.out.println("6.Afisarea persoanelor care au fost in excursie intr-un anumit an");
                System.out.println("7.Sterge Excursie");
                System.out.println("8.Sterge persoana");
                System.out.println("0.Iesire");
                System.out.println("Alegeti una dintre optiuni: ");
                int option = scanner.nextInt();
                switch (option) {
                    case 1 -> {
                        System.out.println("Numele: ");
                        String persoana = scanner.next();
                        System.out.println("Varsta: ");
                        int varsta = Integer.parseInt(scanner.next());
                        scanner.nextLine();
                        try{
                            metodePersoane.adaugaPersoana(persoana, varsta);
                        }
                        catch(Exception e){
                            System.out.println(e.getMessage());
                        }
                    }
                    case 2 -> {
                        System.out.println("Id-ul persoanei care a fost in excursie: ");
                        int idPersoane = scanner.nextInt();
                        System.out.println("Destinatia: ");
                        String destinatie = scanner.next();
                        System.out.println("Anul: ");
                        int anul = Integer.parseInt(scanner.next());
                        try {
                            metodeExcursii.adaugaExcursii(idPersoane, destinatie, anul);
                        }
                        catch(Exception e){
                            System.out.println(e.getMessage());
                        }
                    }
                    case 3->{

                        try {
                            metodePersoane.afisareExcursiiPersoana();
                        }
                        catch(Exception e){
                            System.out.println(e.getMessage());
                        }
                    }
                    case 4 -> {
                        System.out.println("Numele: ");
                        String nume = scanner.next();
                        try{
                            metodeExcursii.afisareExcursiiPersoana(nume);
                        }
                        catch(Exception e){
                            System.out.println(e.getMessage());
                        }
                    }
                    case 5 -> {
                        System.out.println("Destinatie: ");
                        String destinatie = scanner.next();
                        try {
                            metodeExcursii.afiseazaPersoaneDestinatie(destinatie);
                        }
                        catch(Exception e){
                            System.out.println(e.getMessage());
                        }
                    }
                    case 6 ->{
                        System.out.println("Anul: ");
                        int anul = Integer.parseInt(scanner.next());
                        try{
                            metodeExcursii.afiseazaPersoaneAn(anul);
                        }
                        catch(Exception e){
                            System.out.println(e.getMessage());
                        }
                    }
                    case 7 -> {
                        System.out.println("Id excursie: ");
                        int idPersoane = scanner.nextInt();
                        try {
                            metodeExcursii.stergeExcursie(idPersoane);
                        }
                        catch(Exception e){
                            System.out.println(e.getMessage());
                        }
                    }
                    case 8 -> {
                        System.out.println("Id: ");
                        int id = Integer.parseInt(scanner.next());
                        scanner.nextLine();
                        try{
                            metodePersoane.stergePersoana(id);
                        }
                        catch (Exception e){
                            System.out.println(e.getMessage());
                        }
                    }
                    case 0 -> {return;}
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
