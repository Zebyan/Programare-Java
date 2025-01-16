package Ex1;

import java.util.*;
import java.io.*;

public class MainApp {
    public static void main(String[] args) {
        //Lista
        List<Parabola> parabole = new ArrayList<>();

        //Citire din fisier
        try(BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\magda\\Desktop\\UPT III\\PJ\\Laboratoare\\Lab3\\src\\Ex1\\in.txt"))){
            String linie;
            while((linie = reader.readLine()) != null){
                String[] coeficienti = linie.split(" ");
                int a = Integer.parseInt(coeficienti[0]);
                int b = Integer.parseInt(coeficienti[1]);
                int c = Integer.parseInt(coeficienti[2]);
                parabole.add(new Parabola(a, b, c));
            }
        }
        catch(IOException e){
            System.out.println("Eroare la citirea fisierului!!" + e.getMessage());
            return;
        }

        //afisare parabole si varfuri
        for(Parabola p : parabole){
            System.out.println(p);
            double[] varf = p.varfParabola();
            System.out.println("Varf: ("+ varf[0] + ", " + varf[1] + ")");
        }

        //afisarea mijlocului si lungimii
        Parabola p1 = parabole.get(0);
        Parabola p2 = parabole.get(1);

        double[] mijloc = Parabola.mijlocSegmentStatic(p1, p2);
        System.out.println("Mijlocul segmentului dintre doua parabole: ("+ mijloc[0] + ", " + mijloc[1] + ")");
        double lungime = Parabola.lungimeSegmentStatic(p1,p2);
        System.out.println("Lungimea segmentului dintre parabole: " + lungime);
    }

}
