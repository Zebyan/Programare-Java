import Ex1.PerecheNumere;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PerecheNumereTest {

    @Test
    void testSuntConsecutiveFibonacci() {
        // Testează numere consecutive Fibonacci
        PerecheNumere pereche1 = new PerecheNumere(8, 13);
        assertTrue(pereche1.suntConsecutiveFibonacci());

        // Testează numere care nu sunt Fibonacci
        PerecheNumere pereche2 = new PerecheNumere(4, 6);
        assertFalse(pereche2.suntConsecutiveFibonacci());

        // Testează numere Fibonacci care nu sunt consecutive
        PerecheNumere pereche3 = new PerecheNumere(5, 13);
        assertFalse(pereche3.suntConsecutiveFibonacci());
    }

    @Test
    void testCelMaiMicMultipluComun() {
        // Testează pentru numere prime
        PerecheNumere pereche1 = new PerecheNumere(3, 5);
        assertEquals(15, pereche1.celMaiMicMultipluComun());

        // Testează pentru numere egale
        PerecheNumere pereche2 = new PerecheNumere(7, 7);
        assertEquals(7, pereche2.celMaiMicMultipluComun());

        // Testează pentru numere care au un divizor comun
        PerecheNumere pereche3 = new PerecheNumere(6, 9);
        assertEquals(18, pereche3.celMaiMicMultipluComun());
    }

    @Test
    void testSumaCifrelorEgala() {
        // Testează pentru numere cu suma cifrelor egală
        PerecheNumere pereche1 = new PerecheNumere(123, 51);
        assertTrue(pereche1.sumaCifrelorEgala());

        // Testează pentru numere cu suma cifrelor diferită
        PerecheNumere pereche2 = new PerecheNumere(10, 22);
        assertFalse(pereche2.sumaCifrelorEgala());

        // Testează pentru numere negative (suma trebuie calculată pentru valoarea absolută)
        PerecheNumere pereche3 = new PerecheNumere(-12, 3);
        assertFalse(pereche3.sumaCifrelorEgala());
    }

    @Test
    void testAceeasiNumarCifrePare() {
        // Testează pentru numere cu același număr de cifre pare
        PerecheNumere pereche1 = new PerecheNumere(24, 46);
        assertTrue(pereche1.aceeasiNumarCifrePare());

        // Testează pentru numere cu un număr diferit de cifre pare
        PerecheNumere pereche2 = new PerecheNumere(123, 456);
        assertFalse(pereche2.aceeasiNumarCifrePare());

        // Testează pentru un număr cu toate cifrele impare
        PerecheNumere pereche3 = new PerecheNumere(135, 1357);
        assertTrue(pereche3.aceeasiNumarCifrePare());
    }
}

