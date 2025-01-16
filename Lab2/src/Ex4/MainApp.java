package Ex4;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduceti numarul de persoane : ");
        int n = sc.nextInt();
        sc.nextLine();

        Persoana [] persoane = new Persoana[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Introduceti numele persoanei : ");
            String nume = sc.nextLine();

            String cnp;
            while (true){
                System.out.println("Introduceti cnp-ul pentru " + nume + ": ");
                cnp = sc.nextLine();
                if (Persoana.cnpValid(cnp)){
                    break;
                }
                else {
                    System.out.println("CNP INVALID!");
                }
            }
            persoane[i] = new Persoana(nume,cnp);
            System.out.println("\nDate Persoane: ");
            for (Persoana persoana : persoane) {
                System.out.println(persoana.getNume() + " , " + persoana.getCnp() + ",varsta: "+persoana.getVarsta());
            }
        }
    }
}
