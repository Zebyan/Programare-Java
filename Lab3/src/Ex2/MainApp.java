package Ex2;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class MainApp {
    public static void main(String[] args) {
        //lista
        List<Produs> produse = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\magda\\Desktop\\UPT III\\PJ\\Laboratoare\\Lab3\\src\\Ex2\\produse.csv"))) {
            String line;
            while ((line = br.readLine()) != null){
                String[] data = line.split(",");
                String denumire = data[0].trim();
                double pret = Double.parseDouble(data[1].trim());
                int cantitate = Integer.parseInt(data[2].trim());
                LocalDate dataExpirarii = LocalDate.parse(data[3].trim());
                produse.add(new Produs(denumire, pret, cantitate, dataExpirarii));
            }
        } catch (Exception e) {
            System.out.println("Eroare la citirea fisierului! "+e.getMessage());
            return;
        }
        //meniu interactiv
        while(true){
            System.out.println("\nMeniu:");
            System.out.println("1. Afisarea produselor");
            System.out.println("2. Afisarea produselor expirate");
            System.out.println("3. Vanzarea unui produs");
            System.out.println("4. Afisarea produselor cu cel mai mic pret");
            System.out.println("5. Salvati produsele care au un pret mai mic decat cel precizat");
            System.out.println("6. Iesire");
            System.out.println("Selectati o optiune: ");
            int opt = sc.nextInt();
            sc.nextLine();

            switch(opt){
                case 1:
                    produse.forEach(System.out::println);
                    break;

                case 2:
                    LocalDate acum = LocalDate.now();
                    for (Produs produs : produse) {
                        if (produs.getDataExpirarii().isBefore(acum)) {
                            System.out.println(produs);
                        }
                    }
                    break;
                case 3:
                    System.out.println("Introduceti produsul:");
                    String denumire = sc.nextLine();
                    System.out.println("Introduceti cantitatea: ");
                    int cantitateVanduta = sc.nextInt();
                    boolean exista = false;

                    for (Produs produs : produse) {
                        if(produs.getDenumire().equals(denumire)){
                            exista = true;
                            if(produs.getCantitate() >= cantitateVanduta){
                                produs.setCantitate(produs.getCantitate() - cantitateVanduta);
                                System.out.println("Vanzare realizata!");
                                if (produs.getCantitate() == 0){
                                    produse.remove(produs);
                                }
                            }
                            else{
                                System.out.println("Cantitate insuficienta pe stoc!");
                            }
                            break;
                        }
                    }
                    if(!exista){
                        System.out.println("Produsul nu exista!");
                    }
                    break;
                    case 4:
                        //https://www.jrebel.com/blog/java-streams-in-java-8
                        double pretMinim = produse.stream().mapToDouble(Produs::getPret).min().orElse(Double.NaN);
                        produse.stream().filter(p -> p.getPret() == pretMinim).forEach(System.out::println);
                        break;
                    case 5:
                        System.out.println("Introduceti pretul maxim pentru produse: ");
                        double valoareMaxima = sc.nextInt();

                        List<Produs> produseFiltrate = produse.stream().filter(p -> p.getPret() < valoareMaxima).collect(Collectors.toList());

                        try (BufferedWriter bw = Files.newBufferedWriter(Paths.get("produse_filtrate.txt"))){
                            for (Produs produs : produseFiltrate) {
                                bw.write(produs.toString());
                                bw.newLine();
                            }
                            System.out.println("Produsele au fost salvate cu succes!");
                        }
                        catch(IOException e){
                            System.out.println("Eroare la salvarea produselor!" + e.getMessage());
                            return;
                        }
                        break;
                        case 6:
                            return;
                        default:
                            System.out.println("Optiune invalida!. Incercati din nou.");
                }
        }
    }
}
