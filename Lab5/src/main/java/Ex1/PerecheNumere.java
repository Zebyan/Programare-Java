package Ex1;

import java.util.*;
import java.io.*;

public class PerecheNumere {
    private int numar1;
    private int numar2;

    // Constructor fără parametri
    public PerecheNumere() {
        this.numar1 = 0;
        this.numar2 = 0;
    }

    // Constructor cu parametri
    public PerecheNumere(int numar1, int numar2) {
        this.numar1 = numar1;
        this.numar2 = numar2;
    }

    // Gettere și settere
    public int getNumar1() {
        return numar1;
    }

    public void setNumar1(int numar1) {
        this.numar1 = numar1;
    }

    public int getNumar2() {
        return numar2;
    }

    public void setNumar2(int numar2) {
        this.numar2 = numar2;
    }

    // Suprascrierea metodei toString
    @Override
    public String toString() {
        return "(" + numar1 + ", " + numar2 + ")";
    }

    // Verifică dacă numerele sunt consecutive în șirul lui Fibonacci
    public boolean suntConsecutiveFibonacci() {
        return esteFibonacci(numar1) && esteFibonacci(numar2) &&
                (Math.abs(pozitieFibonacci(numar1) - pozitieFibonacci(numar2)) == 1);
    }

    private boolean esteFibonacci(int n) {
        int x1 = 5 * n * n + 4;
        int x2 = 5 * n * n - 4;
        return estePatratPerfect(x1) || estePatratPerfect(x2);
    }

    private boolean estePatratPerfect(int n) {
        int sqrt = (int) Math.sqrt(n);
        return sqrt * sqrt == n;
    }

    private int pozitieFibonacci(int n) {
        int a = 0, b = 1, pozitie = 1;
        while (b < n) {
            int temp = b;
            b += a;
            a = temp;
            pozitie++;
        }
        return b == n ? pozitie : -1;
    }

    // Calculare CMMMC
    public int celMaiMicMultipluComun() {
        return (numar1 * numar2) / cmmdc(numar1, numar2);
    }

    private int cmmdc(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Verificare dacă suma cifrelor este egală
    public boolean sumaCifrelorEgala() {
        return sumaCifrelor(numar1) == sumaCifrelor(numar2);
    }

    private int sumaCifrelor(int n) {
        int suma = 0;
        while (n != 0) {
            suma += n % 10;
            n /= 10;
        }
        return suma;
    }

    // Verificare dacă au același număr de cifre pare
    public boolean aceeasiNumarCifrePare() {
        return numarCifrePare(numar1) == numarCifrePare(numar2);
    }

    private int numarCifrePare(int n) {
        int count = 0;
        while (n != 0) {
            if ((n % 10) % 2 == 0) {
                count++;
            }
            n /= 10;
        }
        return count;
    }
}


