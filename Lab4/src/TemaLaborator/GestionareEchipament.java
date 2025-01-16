package TemaLaborator;

import java.util.*;
import java.io.*;

public class GestionareEchipament {
    private static String Fisier_Serializare = "echip.bin";

    private List<Echipament> echipamente = new ArrayList<>();
    //citirea din fisier:
    public void citireFisier(String numeFisier){
        try (BufferedReader br = new BufferedReader(new FileReader(numeFisier))){
            String linie;
            while((linie = br.readLine()) != null){
                String[] camp = linie.split(";");
                String denumire = camp[0];
                int nr_inv = Integer.parseInt(camp[1]);
                double pret = Double.parseDouble(camp[2]);
                String zona_mag = camp[3];
                Status status = Status.valueOf(camp[4]);
                String tip = camp[5].toLowerCase();
                switch(tip){
                    case "imprimanta" -> {
                        int ppm = Integer.parseInt(camp[6]);
                        String rezolutie = camp[7];
                        int p_car = Integer.parseInt(camp[8]);
                        Tiparire tiparire = Tiparire.valueOf(camp[9].toLowerCase());
                        echipamente.add(new Imprimanta(denumire,nr_inv,pret,zona_mag,status,ppm,rezolutie,p_car,tiparire));
                    }
                    case "copiator" -> {
                        int p_ton = Integer.parseInt(camp[6]);
                        Format format = Format.valueOf(camp[7]);
                        echipamente.add(new Copiator(denumire,nr_inv,pret,zona_mag,status,p_ton,format));
                    }
                    case "sistem de calcul" -> {
                        String tip_mon = camp[6];
                        double vit_proc = Double.parseDouble(camp[7]);
                        int c_hdd = Integer.parseInt(camp[8]);
                        SistemOperare sistemOperare = SistemOperare.valueOf(camp[9].toLowerCase());
                        echipamente.add(new SistemCalcul(denumire,nr_inv,pret,zona_mag,status,tip_mon,vit_proc,c_hdd,sistemOperare));
                    }
                    default -> System.out.println(tip + " nu exista!");
                }
            }
        }
        catch (IOException e){
            System.out.println("Eroare la citirea fisierului!" + e.getMessage());
        }
    }
    //1.afisare echipamente
    public void afisareEchipament(){
        System.out.println("Toate echipamentele: ");
        echipamente.forEach(System.out::println);
    }

    //2.Afisare Imprimante
    public void afisareImprimanta () {
        //System.out.println("Imprimante: ");
        echipamente.stream().filter(e->e instanceof Imprimanta).forEach(System.out::println);
    }

    //3.Afisare copiatoare
    public void afisareCopiator () {
        //System.out.println("Copiatoare: ");
        echipamente.stream().filter(e->e instanceof Copiator).forEach(System.out::println);
    }

    //4,Afisare Sisteme de calcul
    public void afisareSistemCalcul () {
        //System.out.println("Sisteme de Calcul: ");
        echipamente.stream().filter(e->e instanceof SistemCalcul).forEach(System.out::println);
    }

    //5.Modificarea Starii
    public void modificareStare(int nr_inv, Status statusNou){
        echipamente.stream().filter(e->e.nr_inv == nr_inv).findFirst().ifPresent(e->e.setStatus(statusNou));

    }

    //6.Setare mod de scriere pentru imprimanta
    public void setareTiparire(int nr_inv, Tiparire actualizareTiparire){
        echipamente.stream().filter(e->e.nr_inv == nr_inv && e instanceof Imprimanta).map(e-> (Imprimanta)e).findFirst().ifPresent(e->e.setTiparire(actualizareTiparire));
    }

    //7.Setare format copiere
    public void setareFormat(Format actualizareFormat){
        for(Echipament echipament : echipamente){
            if(echipament instanceof Copiator){
                Copiator copiator = (Copiator)echipament;
                copiator.setFormat(actualizareFormat);
            }
        }
    }

    //8.Instalare sistem operare
    public void instalareSistemOperare (int nr_inv, SistemOperare actualizareSistemOperare){
        echipamente.stream().filter(e->e.nr_inv == nr_inv && e instanceof SistemCalcul).map(e-> (SistemCalcul)e).findFirst().ifPresent(e->e.setSistemOperare(actualizareSistemOperare));
    }

    //9.serializare
    public static void serializare(List<Echipament> echipamente){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(Fisier_Serializare))){
            oos.writeObject(echipamente);
            System.out.println("Serializare reusita!");
        }
        catch (IOException e){
            System.err.println("Eroare la serializare!"+e.getMessage());
        }
    }
    public List<Echipament> getEchipamente(){
        return echipamente;
    }

    //10.deserializare
    public static List<Echipament> deserializare(){
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(Fisier_Serializare))){
            System.out.println("Deserializare reusita!");
            return (List<Echipament>) ois.readObject();
        }
        catch (IOException | ClassNotFoundException e){
            System.err.println("Eroare la deserializare!"+e.getMessage());
        }
        return null;
    }

    //11 Afisarea echipamentelor vandute
    public void afisareVandut (){
        System.out.println("Vandut: ");
        echipamente.stream().filter(e->e.status == Status.vandut).forEach(System.out::println);
    }
}
