package Ex1;

import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.core.type.TypeReference;


public class MainApp {
    public static void main(String[] args) throws Exception {
        File fisierJson = new File("C:\\Users\\magda\\Desktop\\UPT III\\PJ\\Laboratoare\\Lab7\\src\\main\\resources\\carti.json");
        ObjectMapper mapper = new ObjectMapper();
        Map<Integer,Carte> carti = mapper.readValue(fisierJson, new TypeReference<Map<Integer, Carte>>() {});

        //1.Afisare carti
        System.out.println("Colectia de carti:");
        carti.forEach((id,carte)-> System.out.println("ID: " + id + ", " + carte));

        //2Stergere carte
        carti.remove(3);
        System.out.println("Dupa stergere:");
        carti.forEach((id,carte)-> System.out.println("ID: " + id + ", " + carte));

        //3.Adaugare carte
        var carteNoua = new Carte ("Crima si Pedeapsa", "Fyodor Dostoevsky", 1866);
        carti.putIfAbsent(3, carteNoua);
        System.out.println("Dupa adaugare: ");
        carti.forEach((id,carte)-> System.out.println("ID: " + id + ", " + carte));

        //4.Salveaza in fisier
        mapper.writeValue(fisierJson, carti);

        //5.Creaza un Set cu cartile lui Yuval Noah Harari
        var cartiHarari = carti.values().stream()
                .filter(carte-> "Yuvah Noah Harari".equals(carte.autorul()))
                .collect(Collectors.toSet());
        System.out.println("Cartile lui Harari: ");
        cartiHarari.forEach(System.out::println);

        //6.Afisarea cartilor ordonate dupa titlu
        System.out.println("Cartile ordonate dupa titlu: ");

    }
}
