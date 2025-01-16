package Lab6;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.util.*;
import java.io.*;
import java.time.*;
import java.util.stream.Collectors;

public class MainApp {
    public static void main(String[] args) {
        List<Angajat> angajati = new ArrayList();
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

        try {
            angajati = mapper.readValue(new File("C:\\Users\\magda\\Desktop\\UPT III\\PJ\\Laboratoare\\Lab6\\src\\main\\resources\\angajati.json"),
                    mapper.getTypeFactory().constructCollectionType(List.class, Angajat.class));
        }
        catch (IOException e) {
            System.out.println("Eraore la citirea din fisier" + e.getMessage());
        }
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n---Meniu---");
            System.out.println("1. Afisarea angajatilor");
            System.out.println("2. Afisarea angajatilor cu salariul mai mare de 2500 RON");
            System.out.println("3. Crearea unei liste a sefilor si directorilor din luna aprilie");
            System.out.println("4. Afisarea angajatilor care nu au functie de conducere in ordinea descrescatoare a salariului");
            System.out.println("5. Extragerea unei liste care contine numele angajatilor scrise cu majuscule");
            System.out.println("6. Afisarea doar a salariilor mai mici de 300 RON");
            System.out.println("7. Afisarea datelor primului angajat");
            System.out.println("8. Afisarea salariului mediu, minim, si maxim");
            System.out.println("9. Verificarea daca in firma se afla un angajat pe nume Ion");
            System.out.println("10. Afisarea numarului de persoane care s-au angajat in vara anului precedent");
            System.out.println("0. Iesire...");
            System.out.print("Selectati: ");
            int optiune = scanner.nextInt();
            scanner.nextLine();

            switch (optiune) {
                case 1:
                    angajati.forEach(System.out::println);
                    break;
                case 2:
                    angajati.stream()
                            .filter(angajat->angajat.getSalariul()>2500)
                            .forEach(System.out::println);
                    break;
                case 3:
                    List<Angajat> angajatiConducere = angajati.stream()
                            .filter(angajat -> angajat.getDataAngajarii().getYear() == LocalDate.now().getYear() -1)
                            .filter(angajat -> angajat.getDataAngajarii().getMonth() == Month.APRIL)
                            .filter(angajat -> angajat.getPostul().toLowerCase().contains("sef") || angajat.getPostul().toLowerCase().contains("director"))
                            .collect(Collectors.toList());
                    angajatiConducere.forEach(System.out::println);
                    break;
                case 4:
                    angajati.stream()
                            .filter(angajat -> !(angajat.getPostul().toLowerCase().contains("sef") || angajat.getPostul().toLowerCase().contains("director")))
                            .sorted((a1,a2)-> Float.compare(a1.getSalariul(),a2.getSalariul()))
                            .forEach(System.out::println);
                    break;
                case 5:
                    List<String> numeMajuscule = angajati.stream()
                            .map(angajat -> angajat.getNume().toUpperCase())
                            .collect(Collectors.toList());
                    numeMajuscule.forEach(System.out::println);
                    break;
                case 6:
                    angajati.stream()
                            .filter(angajat -> angajat.getSalariul() < 3000)
                            .map(Angajat::getSalariul)
                            .forEach(System.out::println);
                    break;
                case 7:
                    Optional<Angajat> primulAngajat = angajati.stream()
                            .min((a1,a2) -> a1.getDataAngajarii().compareTo(a2.getDataAngajarii()));
                    primulAngajat.ifPresentOrElse(System.out::println, () ->System.out.println("Nu exista angajati"));
                    break;
                case 8:
                    DoubleSummaryStatistics statisticaSalarii = angajati.stream()
                            .collect(Collectors.summarizingDouble(Angajat::getSalariul));
                    System.out.println(statisticaSalarii.getAverage());
                    System.out.println(statisticaSalarii.getMin());
                    System.out.println(statisticaSalarii.getMax());
                    break;
                case 9:
                    Optional<Angajat> angajatIon = angajati.stream()
                            .filter(angajat -> angajat.getNume().equalsIgnoreCase("Ion"))
                            .findAny();
                    angajatIon.ifPresentOrElse(System.out::println, () -> System.out.println("Nu exista angajat pe nume Ion"));
                    break;
                case 10:
                    int numarAngajati = (int) angajati.stream()
                            .filter(angajat -> angajat.getDataAngajarii().getYear() == LocalDate.now().getYear() - 1)
                            .filter(angajat -> angajat.getDataAngajarii().getMonth().equals(Month.JUNE) ||
                                    angajat.getDataAngajarii().getMonth().equals(Month.JULY)||
                                    angajat.getDataAngajarii().getMonth().equals(Month.AUGUST))
                            //.mapToInt(e->1)
                            .count();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Optiune gresita!");
                    break;
            }
        }
    }
}
